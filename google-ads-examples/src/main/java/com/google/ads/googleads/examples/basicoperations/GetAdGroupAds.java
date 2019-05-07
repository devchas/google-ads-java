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
import com.google.ads.googleads.v1.errors.GoogleAdsException;
import com.google.ads.googleads.v1.errors.GoogleAdsError;
import com.google.ads.googleads.v1.resources.AdGroup;
import com.google.ads.googleads.v1.resources.AdGroupAd;
import com.google.ads.googleads.v1.services.GoogleAdsRow;
import com.google.ads.googleads.v1.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v1.services.GoogleAdsServiceClient.SearchPagedResponse;
import com.google.ads.googleads.v1.services.SearchGoogleAdsRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.Nullable;

/** This example gets ad group ads. */
public class GetAdGroupAds {

  private static final int PAGE_SIZE = 1_000;

  private static class GetAdGroupAdsParams extends CodeSampleParams {

    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private Long customerId;

    @Parameter(names = ArgumentNames.CAMPAIGN_ID)
    private Long campaignId;
  }

  public static void main(String[] args) throws IOException {
    GetAdGroupAdsParams params = new GetAdGroupAdsParams();
    if (!params.parseArguments(args)) {

      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.customerId = Long.parseLong("INSERT_CUSTOMER_ID_HERE");

      // Optional: Specify a campaign ID to restrict search to only a given campaign.
      params.campaignId = null;
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
      new GetAdGroupAds().runExample(googleAdsClient, params.customerId, params.campaignId);
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
   * @param campaignId the campaign ID for which ad groups will be retrieved. If {@code null},
   *     returns from all campaigns.
   * @throws GoogleAdsException if an API request failed with one or more service errors.
   */
  private void runExample(
    GoogleAdsClient googleAdsClient, long customerId, @Nullable Long campaignId) {
    try (GoogleAdsServiceClient googleAdsServiceClient =
           googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
      String searchQuery =
        "SELECT " +
          "ad_group_ad.resource_name, " +
          "ad_group.id, " +
          "ad_group.name, " +
          "ad_group_ad.ad.id, " +
          "ad_group_ad.ad.expanded_text_ad.description " +
        "FROM " +
          "ad_group_ad " +
        "WHERE " +
          "ad_group_ad.ad.id = '343691913012' ";

      // Creates a request that will retrieve all ad groups using pages of the specified page size.
      SearchGoogleAdsRequest request =
        SearchGoogleAdsRequest.newBuilder()
          .setCustomerId(Long.toString(customerId))
          .setPageSize(PAGE_SIZE)
          .setQuery(searchQuery)
          .build();
      // Issues the search request.
      SearchPagedResponse searchPagedResponse = googleAdsServiceClient.search(request);
      // Iterates over all rows in all pages and prints the requested field values for the ad group
      // in each row.
      for (GoogleAdsRow googleAdsRow : searchPagedResponse.iterateAll()) {
        AdGroupAd adGroupAd = googleAdsRow.getAdGroupAd();
        AdGroup adGroup = googleAdsRow.getAdGroup();
        System.out.printf(
          "Ad group ad with resource name '%s', ad group ID %d, ad group name '%s', ad ID %d, ad " +
            "description '%s' was found.%n",
          adGroupAd.getResourceName(),
          adGroup.getId().getValue(),
          adGroup.getName().getValue(),
          adGroupAd.getAd().getId().getValue(),
          adGroupAd.getAd().getExpandedTextAd().getDescription().getValue());
      }
    }
  }
}
