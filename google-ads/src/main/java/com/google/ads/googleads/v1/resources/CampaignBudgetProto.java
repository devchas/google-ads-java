// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v1/resources/campaign_budget.proto

package com.google.ads.googleads.v1.resources;

public final class CampaignBudgetProto {
  private CampaignBudgetProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_resources_CampaignBudget_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_resources_CampaignBudget_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n7google/ads/googleads/v1/resources/camp" +
      "aign_budget.proto\022!google.ads.googleads." +
      "v1.resources\032:google/ads/googleads/v1/en" +
      "ums/budget_delivery_method.proto\0321google" +
      "/ads/googleads/v1/enums/budget_period.pr" +
      "oto\0321google/ads/googleads/v1/enums/budge" +
      "t_status.proto\032/google/ads/googleads/v1/" +
      "enums/budget_type.proto\032\036google/protobuf" +
      "/wrappers.proto\032\034google/api/annotations." +
      "proto\"\217\t\n\016CampaignBudget\022\025\n\rresource_nam" +
      "e\030\001 \001(\t\022\'\n\002id\030\003 \001(\0132\033.google.protobuf.In" +
      "t64Value\022*\n\004name\030\004 \001(\0132\034.google.protobuf" +
      ".StringValue\0222\n\ramount_micros\030\005 \001(\0132\033.go" +
      "ogle.protobuf.Int64Value\0228\n\023total_amount" +
      "_micros\030\n \001(\0132\033.google.protobuf.Int64Val" +
      "ue\022L\n\006status\030\006 \001(\0162<.google.ads.googlead" +
      "s.v1.enums.BudgetStatusEnum.BudgetStatus" +
      "\022e\n\017delivery_method\030\007 \001(\0162L.google.ads.g" +
      "oogleads.v1.enums.BudgetDeliveryMethodEn" +
      "um.BudgetDeliveryMethod\0225\n\021explicitly_sh" +
      "ared\030\010 \001(\0132\032.google.protobuf.BoolValue\0224" +
      "\n\017reference_count\030\t \001(\0132\033.google.protobu" +
      "f.Int64Value\022:\n\026has_recommended_budget\030\013" +
      " \001(\0132\032.google.protobuf.BoolValue\022E\n reco" +
      "mmended_budget_amount_micros\030\014 \001(\0132\033.goo" +
      "gle.protobuf.Int64Value\022L\n\006period\030\r \001(\0162" +
      "<.google.ads.googleads.v1.enums.BudgetPe" +
      "riodEnum.BudgetPeriod\022V\n1recommended_bud" +
      "get_estimated_change_weekly_clicks\030\016 \001(\013" +
      "2\033.google.protobuf.Int64Value\022[\n6recomme" +
      "nded_budget_estimated_change_weekly_cost" +
      "_micros\030\017 \001(\0132\033.google.protobuf.Int64Val" +
      "ue\022\\\n7recommended_budget_estimated_chang" +
      "e_weekly_interactions\030\020 \001(\0132\033.google.pro" +
      "tobuf.Int64Value\022U\n0recommended_budget_e" +
      "stimated_change_weekly_views\030\021 \001(\0132\033.goo" +
      "gle.protobuf.Int64Value\022F\n\004type\030\022 \001(\01628." +
      "google.ads.googleads.v1.enums.BudgetType" +
      "Enum.BudgetTypeB\200\002\n%com.google.ads.googl" +
      "eads.v1.resourcesB\023CampaignBudgetProtoP\001" +
      "ZJgoogle.golang.org/genproto/googleapis/" +
      "ads/googleads/v1/resources;resources\242\002\003G" +
      "AA\252\002!Google.Ads.GoogleAds.V1.Resources\312\002" +
      "!Google\\Ads\\GoogleAds\\V1\\Resources\352\002%Goo" +
      "gle::Ads::GoogleAds::V1::Resourcesb\006prot" +
      "o3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v1.enums.BudgetDeliveryMethodProto.getDescriptor(),
          com.google.ads.googleads.v1.enums.BudgetPeriodProto.getDescriptor(),
          com.google.ads.googleads.v1.enums.BudgetStatusProto.getDescriptor(),
          com.google.ads.googleads.v1.enums.BudgetTypeProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
        }, assigner);
    internal_static_google_ads_googleads_v1_resources_CampaignBudget_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v1_resources_CampaignBudget_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_resources_CampaignBudget_descriptor,
        new java.lang.String[] { "ResourceName", "Id", "Name", "AmountMicros", "TotalAmountMicros", "Status", "DeliveryMethod", "ExplicitlyShared", "ReferenceCount", "HasRecommendedBudget", "RecommendedBudgetAmountMicros", "Period", "RecommendedBudgetEstimatedChangeWeeklyClicks", "RecommendedBudgetEstimatedChangeWeeklyCostMicros", "RecommendedBudgetEstimatedChangeWeeklyInteractions", "RecommendedBudgetEstimatedChangeWeeklyViews", "Type", });
    com.google.ads.googleads.v1.enums.BudgetDeliveryMethodProto.getDescriptor();
    com.google.ads.googleads.v1.enums.BudgetPeriodProto.getDescriptor();
    com.google.ads.googleads.v1.enums.BudgetStatusProto.getDescriptor();
    com.google.ads.googleads.v1.enums.BudgetTypeProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
