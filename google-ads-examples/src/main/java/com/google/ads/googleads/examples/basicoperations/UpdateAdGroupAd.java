// Copyright 2018 Google LLC
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

package com.google.ads.googleads.examples.basicoperations;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.examples.utils.CodeSampleParams;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v1.common.ExpandedTextAdInfo;
import com.google.ads.googleads.v1.errors.GoogleAdsException;
import com.google.ads.googleads.lib.utils.FieldMasks;
import com.google.ads.googleads.v1.resources.Ad;
import com.google.ads.googleads.v1.resources.AdGroupAd;
import com.google.ads.googleads.v1.services.AdGroupAdOperation;
import com.google.ads.googleads.v1.services.AdGroupAdServiceClient;
import com.google.ads.googleads.v1.services.MutateAdGroupAdResult;
import com.google.ads.googleads.v1.services.MutateAdGroupAdsResponse;
import com.google.ads.googleads.v1.errors.GoogleAdsError;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.StringValue;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This example updates the description of an ad group ad expanded text ad.
 */
public class UpdateAdGroupAd {

  private static class UpdateAdGroupAdParams extends CodeSampleParams {

    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private Long customerId;
  }

  public static void main(String[] args) {
    UpdateAdGroupAdParams params = new UpdateAdGroupAdParams();
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
      new UpdateAdGroupAd().runExample(googleAdsClient, params.customerId);
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
    String adGroupAdResourceName = "customers/5554634905/adGroupAds/64574803810~343691913012";

    // Create the ad.
    Ad ad = Ad.newBuilder()
      .setName(StringValue.of("My Awesome Ad"))
      .setExpandedTextAd(ExpandedTextAdInfo.newBuilder()
        .setDescription(StringValue.of("Buy your tickets later!"))
        .build())
      .build();


    // Creates the ad group ad.
    AdGroupAd adGroupAd = AdGroupAd.newBuilder()
      .setResourceName(adGroupAdResourceName)
      .setAd(ad)
      .build();

    // Constructs an operation that will update the ad group ad, using the FieldMasks utility to
    // derive the update mask. This mask tells the Google Ads API which attributes of the
    // ad group you want to change.
    AdGroupAdOperation operation = AdGroupAdOperation.newBuilder()
      .setUpdate(adGroupAd)
      .setUpdateMask(FieldMasks.allSetFieldsOf(adGroupAd))
      .build();

    // Creates the ad group ad service client.
    try (AdGroupAdServiceClient adGroupAdServiceClient =
           googleAdsClient.getLatestVersion().createAdGroupAdServiceClient()) {
      // Send the operation in a mutate request.
      MutateAdGroupAdsResponse response =
        adGroupAdServiceClient.mutateAdGroupAds(
          Long.toString(customerId), ImmutableList.of(operation));
      // Print the resource name of each updated object.
      for (MutateAdGroupAdResult mutateAdGroupAdResult : response.getResultsList()) {
        System.out.printf(
          "Updated ad group with resourceName: '%s'.%n", mutateAdGroupAdResult.getResourceName());
      }
    }
  }
}
