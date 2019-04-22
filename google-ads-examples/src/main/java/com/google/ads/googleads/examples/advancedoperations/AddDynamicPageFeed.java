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
import com.google.ads.googleads.v1.enums.DsaPageFeedCriterionFieldEnum.DsaPageFeedCriterionField;
import com.google.ads.googleads.v1.enums.FeedMappingCriterionTypeEnum.FeedMappingCriterionType;
import com.google.ads.googleads.v1.resources.*;
import com.google.ads.googleads.v1.services.*;
import com.google.ads.googleads.v1.services.GoogleAdsServiceClient.SearchPagedResponse;
import com.google.ads.googleads.v1.utils.ResourceNames;
import com.google.ads.googleads.v1.enums.FeedAttributeTypeEnum.FeedAttributeType;
import com.google.ads.googleads.v1.enums.FeedOriginEnum.FeedOrigin;
import com.google.ads.googleads.v1.errors.GoogleAdsError;
import com.google.ads.googleads.v1.errors.GoogleAdsException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * This code example adds a page feed to specify precisely which URLs to use with
 * your Dynamic Search Ads campaign.
 */
public class AddDynamicPageFeed {
  private static final int PAGE_SIZE = 1_000;

  private static class AddDynamicPageFeedParams extends CodeSampleParams {

    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private long customerId;

    @Parameter(names = ArgumentNames.CAMPAIGN_ID, required = true)
    private long campaignId;

    @Parameter(names = ArgumentNames.AD_GROUP_ID, required = true)
    private long adGroupId;
  }

  private static class FeedDetails {
    private String feedResourceName;
    private long urlAttributeId;
    private long labelAttributeId;

    private FeedDetails(String feedResourceName, long urlAttributeId, long labelAttributeId) {
      this.feedResourceName = feedResourceName;
      this.urlAttributeId = urlAttributeId;
      this.labelAttributeId = labelAttributeId;
    }

    private String getFeedResourceName() {
      return this.feedResourceName;
    }

    private long getUrlAttributeId() {
      return this.urlAttributeId;
    }

    private long getLabelAttributeId() {
      return this.labelAttributeId;
    }
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

  /**
   * Runs the example.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID in which to create criterion.
   * @param adGroupId the adGroup ID.
   * @param campaignId the campaign ID.
   * @throws GoogleAdsException if an API request failed with one or more service errors.
   */
  private void runExample(
      GoogleAdsClient googleAdsClient,
      long customerId,
      long campaignId,
      long adGroupId) {
    String dsaPageUrlLabel = "discounts";

    // Get the page feed details. This code example creates a new feed, but you can
    // fetch and re-use an existing feed.
    FeedDetails feedDetails = createFeed(googleAdsClient, customerId);
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

  /**
   * Creates a feed.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID in which to create criterion.
   * @return a FeedDetails object containing relevant information.
   */
  private FeedDetails createFeed(GoogleAdsClient googleAdsClient, long customerId) {
    // Create a URL attribute
    FeedAttribute urlAttribute = FeedAttribute.newBuilder()
      .setType(FeedAttributeType.URL_LIST)
      .setName(StringValue.of("Page URL"))
      .build();

    // Create a label attribute
    FeedAttribute labelAttribute = FeedAttribute.newBuilder()
      .setType(FeedAttributeType.STRING_LIST)
      .setName(StringValue.of("Label"))
      .build();

    // Create the feed.
    Feed feed = Feed.newBuilder()
      .setName(StringValue.of("DSA Feed #" + System.currentTimeMillis()))
      .addAttributes(urlAttribute)
      .addAttributes(labelAttribute)
      .setOrigin(FeedOrigin.USER)
      .build();

    // Create the operation.
    FeedOperation operation = FeedOperation.newBuilder().setCreate(feed).build();

    // Create the feed service client.
    try (FeedServiceClient feedServiceClient =
           googleAdsClient.getLatestVersion().createFeedServiceClient()) {
      // Add the feed.
      MutateFeedsResponse response =
        feedServiceClient.mutateFeeds(String.valueOf(customerId), ImmutableList.of(operation));
      String feedResourceName = response.getResults(0).getResourceName();
      // Display the result.
      System.out.printf(
        "Feed with resource name '%s' was created.%n", feedResourceName);

      // Return a FeedDetails object.
      return getFeed(googleAdsClient, customerId, feedResourceName);
    }

  }

  /**
   * Retrieves details about a feed.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID in which to create criterion.
   * @return a FeedDetails object containing relevant information.
   */
  private FeedDetails getFeed(GoogleAdsClient googleAdsClient, long customerId, String feedResourceName) {
    // Construct the query.
    String query =
      "SELECT feed.attributes FROM feed WHERE feed.resource_name = '" + feedResourceName + "'";

    // Construct the request.
    SearchGoogleAdsRequest request = SearchGoogleAdsRequest.newBuilder()
      .setCustomerId(String.valueOf(customerId))
      .setPageSize(PAGE_SIZE)
      .setQuery(query)
      .build();

    // Issue the search request.
    try (GoogleAdsServiceClient googleAdsServiceClient =
           googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
      SearchPagedResponse searchPagedResponse = googleAdsServiceClient.search(request);
      // Get the first result because we only need the single feed item we created previously.
      GoogleAdsRow googleAdsRow = searchPagedResponse.getPage().getResponse().getResults(0);
      // Get the attributes list from the feed and create a map with keys of each attribute and
      // values of each corresponding ID.
      List<FeedAttribute> feedAttributeList = googleAdsRow.getFeed().getAttributesList();
      Map<String, Long> feedAttributeMap = new Hashtable<>();
      for (FeedAttribute feedAttribute : feedAttributeList) {
        feedAttributeMap.put(feedAttribute.getName().getValue(), feedAttribute.getId().getValue());
      }
      // Finally, construct a FeedDetails object so that we have a nice small
      // wrapper around the details we care about for the next phase.
      FeedDetails feedDetails = new FeedDetails(
        googleAdsRow.getFeed().getResourceName(),
        feedAttributeMap.get("Page URL"),
        feedAttributeMap.get("Label"));

      return feedDetails;
    }
  }

  /**
   * Creates a field mapping for a given feed.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID in which to create criterion.
   * @param feedDetails the relevant information about the feed and its attributes.
   */
  private void createFeedMapping(GoogleAdsClient googleAdsClient, long customerId, FeedDetails feedDetails) {
    // Map the FeedAttributeIds to the fieldId constants.
    AttributeFieldMapping urlFieldMapping = AttributeFieldMapping.newBuilder()
      .setFeedAttributeId(Int64Value.of(feedDetails.getUrlAttributeId()))
      .setDsaPageFeedField(DsaPageFeedCriterionField.PAGE_URL)
      .build();
    AttributeFieldMapping labelFieldMapping = AttributeFieldMapping.newBuilder()
      .setFeedAttributeId(Int64Value.of(feedDetails.getLabelAttributeId()))
      .setDsaPageFeedField(DsaPageFeedCriterionField.LABEL)
      .build();

    // Map the FeedAttributeIds to the fieldId constants.
    FeedMapping feedMapping = FeedMapping.newBuilder()
      .setCriterionType(FeedMappingCriterionType.DSA_PAGE_FEED)
      .setFeed(StringValue.of(feedDetails.getFeedResourceName()))
      .addAttributeFieldMappings(urlFieldMapping)
      .addAttributeFieldMappings(labelFieldMapping)
      .build();

    // Create the operation
    FeedMappingOperation operation =
      FeedMappingOperation.newBuilder().setCreate(feedMapping).build();

    // Add the FeedMapping.
    try (FeedMappingServiceClient feedMappingServiceClient =
           googleAdsClient.getLatestVersion().createFeedMappingServiceClient()) {
      MutateFeedMappingsResponse response =
        feedMappingServiceClient.mutateFeedMappings(
          Long.toString(customerId),
          ImmutableList.of(operation));

      // Display the results
      for (MutateFeedMappingResult result : response.getResultsList()) {
        System.out.printf("Created feed mapping with resource name '%s'", result.getResourceName());
      }
    }
    return;
  }

  /**
   * Creates feed items for a given feed.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID in which to create criterion.
   * @param feedDetails the relevant information about the feed and its attributes.
   * @param dsaPageUrlLabel the label for the DSA Page URLs.
   */
  private void createFeedItems(GoogleAdsClient googleAdsClient, long customerId,
                               FeedDetails feedDetails, String dsaPageUrlLabel) {
    List<String> urls = Arrays.asList(
      "http://www.example.com/discounts/rental-cars",
      "http://www.example.com/discounts/hotel-deals",
      "http://www.example.com/discounts/flight-deals"
    );

    List<FeedItemOperation> ops = new ArrayList<>();

    for (String url : urls) {
      // Create a url attribute.
      FeedItemAttributeValue urlAttributeValue = FeedItemAttributeValue.newBuilder()
        .setFeedAttributeId(
          Int64Value.of(feedDetails.getUrlAttributeId()))
        .setStringValue(StringValue.of(url))
        .build();
      // Create a label attribute.
      FeedItemAttributeValue labelAttributeValue = FeedItemAttributeValue.newBuilder()
        .setFeedAttributeId(
          Int64Value.of(feedDetails.getLabelAttributeId()))
        .setStringValue(StringValue.of(dsaPageUrlLabel))
        .build();
      // Create a feed item.
      FeedItem feedItem = FeedItem.newBuilder()
        .setFeed(StringValue.of(feedDetails.getFeedResourceName()))
        .addAttributeValues(urlAttributeValue)
        .addAttributeValues(labelAttributeValue)
        .build();
      // Create an operation.
      FeedItemOperation operation = FeedItemOperation.newBuilder()
        .setCreate(feedItem)
        .build();
      ops.add(operation);
    }

    // Create the feed item service client.
    try (FeedItemServiceClient feedItemServiceClient =
           googleAdsClient.getLatestVersion().createFeedItemServiceClient()) {
      // Add the feed items.
      MutateFeedItemsResponse response =
        feedItemServiceClient.mutateFeedItems(Long.toString(customerId), ops);
      // Display the results.
      for (MutateFeedItemResult result : response.getResultsList()) {
        System.out.printf("Created feed items with resource name '%s'.%n",
        result.getResourceName());
      }
    }
    return;
  }

  private void updateCampaignDsaSetting(GoogleAdsClient googleAdsClient, long customerId,
                                        String campaignResourceName, FeedDetails feedDetail) {
    return;
  }

  private void addDsaTarget(GoogleAdsClient googleAdsClient, long customerId,
                            String adGroupResourceName, String dsaPageUrlLabel) {
    return;
  }
}
