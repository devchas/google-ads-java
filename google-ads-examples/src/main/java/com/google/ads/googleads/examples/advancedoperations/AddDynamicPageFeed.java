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

package com.google.ads.googleads.examples.advancedoperations;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.examples.utils.CodeSampleParams;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v0.utils.ResourceNames;
import com.google.ads.googleads.v1.errors.GoogleAdsError;
import com.google.ads.googleads.v1.errors.GoogleAdsException;
import com.google.ads.googleads.v1.resources.Feed;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This code example adds a page feed to specify precisely which URLs to use with
 * your Dynamic Search Ads campaign.
 */
public class AddDynamicPageFeed {
  private static class AddDynamicPageFeedParams extends CodeSampleParams {

    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private long customerId;

    @Parameter(names = ArgumentNames.CAMPAIGN_ID, required = true)
    private long campaignId;

    @Parameter(names = ArgumentNames.AD_GROUP_ID, required = true)
    private long adGroupId;
  }

  private static void main(String[] args) {
    AddDynamicPageFeedParams params = new AddDynamicPageFeedParams();
    if (!params.parseArguments(args)) {

      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.customerId = Long.parseLong("INSERT_CUSTOMER_ID_HERE");
      params.campaignId = Long.parseLong("INSERT_CAMPAIGN_ID_HERE");
      params.adGroupId = Long.parseLong("INSERT_AD_GROUP_ID_HERE");
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
      new AddDynamicPageFeed().runExample(googleAdsClient,
        params.customerId, params.campaignId, params.adGroupId);
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

  private void runExample(
      GoogleAdsClient googleAdsClient,
      long customerId,
      long campaignId,
      long adGroupId) {
    String dsaPageUrlLabel = "discounts";

    // Get the page feed details. This code example creates a new feed, but you can
    // fetch and re-use an existing feed.
    Feed feedDetails = createFeed(customerId);
    createFeedMapping(googleAdsClient, customerId, feedDetails);
    createFeedItems(googleAdsClient, customerId, feedDetails, dsaPageUrlLabel);

    // Associate the page feed with the campaign.
    String campaignResourceName = ResourceNames.campaign(customerId, campaignId);
    updateCampaignDsaSetting(googleAdsClient, customerId, campaignResourceName, feedDetails);

    // Optional: Target web pages matching the feed's label in the ad group.
    String adGroupResourceName = ResourceNames.adGroup(customerId, adGroupId);
    addDsaTarget(googleAdsClient, customerId, adGroupResourceName, dsaPageUrlLabel);

    System.out.printf("Dynamic page feed setup is complete for campaign ID %s.%n", campaignId);
  }

  private Feed createFeed(Long customerId) {
    return Feed.newBuilder().build();
  }

  private void createFeedMapping(GoogleAdsClient googleAdsClient, Long customerId, Feed feedDetails) {
    return;
  }

  private void updateCampaignDsaSetting(GoogleAdsClient googleAdsClient, Long customerId,
                                        String campaignResourceName, Feed feedDetails) {
    return;
  }

  private void addDsaTarget(GoogleAdsClient googleAdsClient, Long customerId,
                            String adGroupResourceName, String dsaPageUrlLabel) {
    return;
  }

  private void createFeedItems(GoogleAdsClient googleAdsClient, Long customerId,
                               Feed feedDetail, String dsaPageUrlLabel) {
    return;
  }
}
