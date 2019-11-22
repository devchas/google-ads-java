// Copyright 2020 Google LLC
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

package com.google.ads.googleads.examples.campaignmanagement;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.examples.utils.CodeSampleParams;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.lib.utils.FieldMasks;
import com.google.ads.googleads.v2.common.DeviceInfo;
import com.google.ads.googleads.v2.enums.DeviceEnum.Device;
import com.google.ads.googleads.v2.services.CampaignCriterionOperation;
import com.google.ads.googleads.v2.errors.GoogleAdsError;
import com.google.ads.googleads.v2.errors.GoogleAdsException;
import com.google.ads.googleads.v2.resources.CampaignCriterion;
import com.google.ads.googleads.v2.services.CampaignCriterionServiceClient;
import com.google.ads.googleads.v2.services.MutateCampaignCriteriaResponse;
import com.google.ads.googleads.v2.services.MutateCampaignCriterionResult;
import com.google.ads.googleads.v2.utils.ResourceNames;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.FloatValue;
import java.io.FileNotFoundException;
import java.io.IOException;

/** Sets a bid modifier for the mobile platform on given campaign. */
public class SetBidModifier {

  private static final float BID_MODIFIER = 1.5f;

  private static class SetBidModifierParams extends CodeSampleParams {

    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private Long customerId;

    @Parameter(names = ArgumentNames.CAMPAIGN_ID, required = true)
    private Long campaignId;
  }

  public static void main(String[] args) throws IOException {
    SetBidModifierParams params = new SetBidModifierParams();
    if (!params.parseArguments(args)) {

      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.customerId = Long.parseLong("INSERT_CUSTOMER_ID_HERE");
      params.campaignId = Long.parseLong("INSERT_CAMPAIGN_ID_HERE");
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
      new SetBidModifier().runExample(googleAdsClient, params.customerId, params.campaignId);
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
   * @param campaignId the campaign ID.
   * @throws GoogleAdsException if an API request failed with one or more service errors.
   */
  private void runExample(GoogleAdsClient googleAdsClient, long customerId, long campaignId) {
    // Mobile device campaign criteria are unique in that all of the mobile device campaign
    // criteria are created automatically at the time of campaign creation. Use the campaign ID and
    // mobile device constant to get the resource name of a mobile device campaign criterion for a
    // given campaign.
    long mobileDeviceConstant = 30001;
    String criterionResourceName =
        ResourceNames.campaignCriterion(customerId, campaignId, mobileDeviceConstant);

    // Creates the CampaignCriterion.
    CampaignCriterion campaignCriterion = CampaignCriterion.newBuilder()
        .setResourceName(criterionResourceName)
        .setBidModifier(FloatValue.of(BID_MODIFIER))
        .setDevice(DeviceInfo.newBuilder().setType(Device.MOBILE).build())
        .build();

    // Creates the operation. This is an update operation because mobile device campaign criteria
    // are automatically created at the time of campaign creation.
    CampaignCriterionOperation operation =
      CampaignCriterionOperation.newBuilder()
          .setUpdate(campaignCriterion)
          .setUpdateMask(FieldMasks.allSetFieldsOf(campaignCriterion))
          .build();

    // Creates the CampaignCriterionServiceClient.
    try (CampaignCriterionServiceClient campaignCriterionServiceClient =
        googleAdsClient.getLatestVersion().createCampaignCriterionServiceClient()) {
      // Adds the CampaignCriterion.
      MutateCampaignCriteriaResponse response =
          campaignCriterionServiceClient.mutateCampaignCriteria(
              Long.toString(customerId), ImmutableList.of(operation));
      for (MutateCampaignCriterionResult result : response.getResultsList()) {
        System.out.printf("Campaign criterion with resource name '%s' was modified.%n",
            result.getResourceName());
      }
    }
  }
}
