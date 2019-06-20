// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.ads.googleads.examples.misc;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.examples.utils.CodeSampleParams;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v1.common.ImageAsset;
import com.google.ads.googleads.v1.errors.GoogleAdsException;
import com.google.ads.googleads.v1.errors.GoogleAdsError;
import com.google.ads.googleads.v1.resources.Asset;
import com.google.ads.googleads.v1.services.AssetOperation;
import com.google.ads.googleads.v1.services.GoogleAdsRow;
import com.google.ads.googleads.v1.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v1.services.GoogleAdsServiceClient.SearchPagedResponse;
import com.google.ads.googleads.v1.services.SearchGoogleAdsRequest;
import com.google.ads.googleads.v1.utils.ResourceNames;
import com.google.common.io.ByteStreams;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/** This example gets all video and image files. */
public class GetAllVideosAndImages {
  private static final int PAGE_SIZE = 1_000;

  private static class GetAllVideosAndImagesParams extends CodeSampleParams {

    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private Long customerId;
  }

  public static void main(String[] args) throws IOException {
    GetAllVideosAndImagesParams params = new GetAllVideosAndImagesParams();
    if (!params.parseArguments(args)) {

      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.customerId = Long.parseLong("INSERT_CUSTOMER_ID_HERE");
    }

    GoogleAdsClient googleAdsClient;
    try {
      googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
    } catch (FileNotFoundException fnfe) {
      System.err.printf(
        "Failed to load GoogleAdsClient configuration from file. Exception: %s%n", fnfe);
      return;
    } catch (IOException ioe) {
      System.err.printf("Failed to create GoogleAdsClient. Exception: %s%n", ioe);
      return;
    }

    try {
      new GetAllVideosAndImages().runExample(googleAdsClient, params.customerId);
    } catch (GoogleAdsException gae) {
      // GoogleAdsException is the base class for most exceptions thrown by an API request.
      // Instances of this exception have a message and a GoogleAdsFailure that contains a
      // collection of GoogleAdsErrors that indicate the underlying causes of the
      // GoogleAdsException.
      System.err.printf(
        "Request ID %s failed due to GoogleAdsException. Underlying errors:%n",
        gae.getRequestId());
      int i = 0;
      for (GoogleAdsError googleAdsError : gae.getGoogleAdsFailure().getErrorsList()) {
        System.err.printf("  Error %d: %s%n", i++, googleAdsError);
      }
    }
  }

  /**
   * Runs the example.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID.
   * @throws GoogleAdsException if an API request failed with one or more service errors.
   */
  private void runExample(GoogleAdsClient googleAdsClient, long customerId) {
    try (GoogleAdsServiceClient googleAdsServiceClient =
           googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
      // Creates a request that will retrieve all video and image files using pages of the
      // specified page size.
      SearchGoogleAdsRequest request =
        SearchGoogleAdsRequest.newBuilder()
          .setCustomerId(Long.toString(customerId))
          .setPageSize(PAGE_SIZE)
          .setQuery("SELECT asset.id, asset.name, asset.type " +
            "FROM asset ORDER BY asset.id")
          .build();
      // Issues the search request.
      SearchPagedResponse searchPagedResponse = googleAdsServiceClient.search(request);
      // Iterates over all rows in all pages and prints the requested field values for the media file
      // in each row.
      for (GoogleAdsRow googleAdsRow : searchPagedResponse.iterateAll()) {
        System.out.printf(
          "Asset with ID %d, name '%s', and type '%s' was found.%n",
          googleAdsRow.getAsset().getId().getValue(),
          googleAdsRow.getAsset().getName().getValue(),
          googleAdsRow.getAsset().getType());
      }
    }
  }


  private void removeAssets(GoogleAdsClient googleAdsClient, long customerId, List<Long>
    assetIds) throws MalformedURLException, IOException {
    List<AssetOperation> operations = new ArrayList<>();

    String imageUrl = "https://lh3.googleusercontent" +
      ".com/lq9kbsdj9-eMYfu1x8um61NqD_c99Ad1kq9E-pHUiS9I2KTbK_kWGSTiiYJB2o2HlarNIs09u_hbSPn4ISfqvV8F0H7x95Z_RjDt=w300";
    byte[] imageData = ByteStreams.toByteArray(new URL(imageUrl).openStream());

    for (long assetId : assetIds) {
      String assetResName = ResourceNames.asset(customerId, assetId);
      Asset asset = Asset.newBuilder()
        .setResourceName(assetResName)
        .setImageAsset(ImageAsset.newBuilder()
          .setData(BytesValue.of(ByteString.copyFrom(imageData)))
          .build())
        .build();

//      AssetOperation operation = AssetOperation.newBuilder().set
    }
  }
}
