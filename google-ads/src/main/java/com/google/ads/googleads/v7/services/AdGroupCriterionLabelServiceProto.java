// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v7/services/ad_group_criterion_label_service.proto

package com.google.ads.googleads.v7.services;

public final class AdGroupCriterionLabelServiceProto {
  private AdGroupCriterionLabelServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v7_services_GetAdGroupCriterionLabelRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v7_services_GetAdGroupCriterionLabelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v7_services_AdGroupCriterionLabelOperation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v7_services_AdGroupCriterionLabelOperation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nGgoogle/ads/googleads/v7/services/ad_gr" +
      "oup_criterion_label_service.proto\022 googl" +
      "e.ads.googleads.v7.services\032@google/ads/" +
      "googleads/v7/resources/ad_group_criterio" +
      "n_label.proto\032\034google/api/annotations.pr" +
      "oto\032\027google/api/client.proto\032\037google/api" +
      "/field_behavior.proto\032\031google/api/resour" +
      "ce.proto\032\027google/rpc/status.proto\"p\n\037Get" +
      "AdGroupCriterionLabelRequest\022M\n\rresource" +
      "_name\030\001 \001(\tB6\340A\002\372A0\n.googleads.googleapi" +
      "s.com/AdGroupCriterionLabel\"\312\001\n#MutateAd" +
      "GroupCriterionLabelsRequest\022\030\n\013customer_" +
      "id\030\001 \001(\tB\003\340A\002\022Y\n\noperations\030\002 \003(\0132@.goog" +
      "le.ads.googleads.v7.services.AdGroupCrit" +
      "erionLabelOperationB\003\340A\002\022\027\n\017partial_fail" +
      "ure\030\003 \001(\010\022\025\n\rvalidate_only\030\004 \001(\010\"\213\001\n\036AdG" +
      "roupCriterionLabelOperation\022J\n\006create\030\001 " +
      "\001(\01328.google.ads.googleads.v7.resources." +
      "AdGroupCriterionLabelH\000\022\020\n\006remove\030\002 \001(\tH" +
      "\000B\013\n\toperation\"\257\001\n$MutateAdGroupCriterio" +
      "nLabelsResponse\0221\n\025partial_failure_error" +
      "\030\003 \001(\0132\022.google.rpc.Status\022T\n\007results\030\002 " +
      "\003(\0132C.google.ads.googleads.v7.services.M" +
      "utateAdGroupCriterionLabelResult\":\n!Muta" +
      "teAdGroupCriterionLabelResult\022\025\n\rresourc" +
      "e_name\030\001 \001(\t2\342\004\n\034AdGroupCriterionLabelSe" +
      "rvice\022\351\001\n\030GetAdGroupCriterionLabel\022A.goo" +
      "gle.ads.googleads.v7.services.GetAdGroup" +
      "CriterionLabelRequest\0328.google.ads.googl" +
      "eads.v7.resources.AdGroupCriterionLabel\"" +
      "P\202\323\344\223\002:\0228/v7/{resource_name=customers/*/" +
      "adGroupCriterionLabels/*}\332A\rresource_nam" +
      "e\022\216\002\n\034MutateAdGroupCriterionLabels\022E.goo" +
      "gle.ads.googleads.v7.services.MutateAdGr" +
      "oupCriterionLabelsRequest\032F.google.ads.g" +
      "oogleads.v7.services.MutateAdGroupCriter" +
      "ionLabelsResponse\"_\202\323\344\223\002@\";/v7/customers" +
      "/{customer_id=*}/adGroupCriterionLabels:" +
      "mutate:\001*\332A\026customer_id,operations\032E\312A\030g" +
      "oogleads.googleapis.com\322A\'https://www.go" +
      "ogleapis.com/auth/adwordsB\210\002\n$com.google" +
      ".ads.googleads.v7.servicesB!AdGroupCrite" +
      "rionLabelServiceProtoP\001ZHgoogle.golang.o" +
      "rg/genproto/googleapis/ads/googleads/v7/" +
      "services;services\242\002\003GAA\252\002 Google.Ads.Goo" +
      "gleAds.V7.Services\312\002 Google\\Ads\\GoogleAd" +
      "s\\V7\\Services\352\002$Google::Ads::GoogleAds::" +
      "V7::Servicesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v7.resources.AdGroupCriterionLabelProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          com.google.rpc.StatusProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v7_services_GetAdGroupCriterionLabelRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v7_services_GetAdGroupCriterionLabelRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v7_services_GetAdGroupCriterionLabelRequest_descriptor,
        new java.lang.String[] { "ResourceName", });
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsRequest_descriptor,
        new java.lang.String[] { "CustomerId", "Operations", "PartialFailure", "ValidateOnly", });
    internal_static_google_ads_googleads_v7_services_AdGroupCriterionLabelOperation_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_ads_googleads_v7_services_AdGroupCriterionLabelOperation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v7_services_AdGroupCriterionLabelOperation_descriptor,
        new java.lang.String[] { "Create", "Remove", "Operation", });
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelsResponse_descriptor,
        new java.lang.String[] { "PartialFailureError", "Results", });
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelResult_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v7_services_MutateAdGroupCriterionLabelResult_descriptor,
        new java.lang.String[] { "ResourceName", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ads.googleads.v7.resources.AdGroupCriterionLabelProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}