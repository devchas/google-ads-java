// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v1/services/campaign_draft_service.proto

package com.google.ads.googleads.v1.services;

public final class CampaignDraftServiceProto {
  private CampaignDraftServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_GetCampaignDraftRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_GetCampaignDraftRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_PromoteCampaignDraftRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_PromoteCampaignDraftRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_CampaignDraftOperation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_CampaignDraftOperation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_MutateCampaignDraftResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n=google/ads/googleads/v1/services/campa" +
      "ign_draft_service.proto\022 google.ads.goog" +
      "leads.v1.services\0326google/ads/googleads/" +
      "v1/resources/campaign_draft.proto\032\034googl" +
      "e/api/annotations.proto\032#google/longrunn" +
      "ing/operations.proto\032 google/protobuf/fi" +
      "eld_mask.proto\032\036google/protobuf/wrappers" +
      ".proto\032\027google/rpc/status.proto\"0\n\027GetCa" +
      "mpaignDraftRequest\022\025\n\rresource_name\030\001 \001(" +
      "\t\"\260\001\n\033MutateCampaignDraftsRequest\022\023\n\013cus" +
      "tomer_id\030\001 \001(\t\022L\n\noperations\030\002 \003(\01328.goo" +
      "gle.ads.googleads.v1.services.CampaignDr" +
      "aftOperation\022\027\n\017partial_failure\030\003 \001(\010\022\025\n" +
      "\rvalidate_only\030\004 \001(\010\"5\n\033PromoteCampaignD" +
      "raftRequest\022\026\n\016campaign_draft\030\001 \001(\t\"\360\001\n\026" +
      "CampaignDraftOperation\022/\n\013update_mask\030\004 " +
      "\001(\0132\032.google.protobuf.FieldMask\022B\n\006creat" +
      "e\030\001 \001(\01320.google.ads.googleads.v1.resour" +
      "ces.CampaignDraftH\000\022B\n\006update\030\002 \001(\01320.go" +
      "ogle.ads.googleads.v1.resources.Campaign" +
      "DraftH\000\022\020\n\006remove\030\003 \001(\tH\000B\013\n\toperation\"\237" +
      "\001\n\034MutateCampaignDraftsResponse\0221\n\025parti" +
      "al_failure_error\030\003 \001(\0132\022.google.rpc.Stat" +
      "us\022L\n\007results\030\002 \003(\0132;.google.ads.googlea" +
      "ds.v1.services.MutateCampaignDraftResult" +
      "\"2\n\031MutateCampaignDraftResult\022\025\n\rresourc" +
      "e_name\030\001 \001(\t\"c\n#ListCampaignDraftAsyncEr" +
      "rorsRequest\022\025\n\rresource_name\030\001 \001(\t\022\022\n\npa" +
      "ge_token\030\002 \001(\t\022\021\n\tpage_size\030\003 \001(\005\"c\n$Lis" +
      "tCampaignDraftAsyncErrorsResponse\022\"\n\006err" +
      "ors\030\001 \003(\0132\022.google.rpc.Status\022\027\n\017next_pa" +
      "ge_token\030\002 \001(\t2\341\006\n\024CampaignDraftService\022" +
      "\271\001\n\020GetCampaignDraft\0229.google.ads.google" +
      "ads.v1.services.GetCampaignDraftRequest\032" +
      "0.google.ads.googleads.v1.resources.Camp" +
      "aignDraft\"8\202\323\344\223\0022\0220/v1/{resource_name=cu" +
      "stomers/*/campaignDrafts/*}\022\325\001\n\024MutateCa" +
      "mpaignDrafts\022=.google.ads.googleads.v1.s" +
      "ervices.MutateCampaignDraftsRequest\032>.go" +
      "ogle.ads.googleads.v1.services.MutateCam" +
      "paignDraftsResponse\">\202\323\344\223\0028\"3/v1/custome" +
      "rs/{customer_id=*}/campaignDrafts:mutate" +
      ":\001*\022\272\001\n\024PromoteCampaignDraft\022=.google.ad" +
      "s.googleads.v1.services.PromoteCampaignD" +
      "raftRequest\032\035.google.longrunning.Operati" +
      "on\"D\202\323\344\223\002>\"9/v1/{campaign_draft=customer" +
      "s/*/campaignDrafts/*}:promote:\001*\022\367\001\n\034Lis" +
      "tCampaignDraftAsyncErrors\022E.google.ads.g" +
      "oogleads.v1.services.ListCampaignDraftAs" +
      "yncErrorsRequest\032F.google.ads.googleads." +
      "v1.services.ListCampaignDraftAsyncErrors" +
      "Response\"H\202\323\344\223\002B\022@/v1/{resource_name=cus" +
      "tomers/*/campaignDrafts/*}:listAsyncErro" +
      "rsB\200\002\n$com.google.ads.googleads.v1.servi" +
      "cesB\031CampaignDraftServiceProtoP\001ZHgoogle" +
      ".golang.org/genproto/googleapis/ads/goog" +
      "leads/v1/services;services\242\002\003GAA\252\002 Googl" +
      "e.Ads.GoogleAds.V1.Services\312\002 Google\\Ads" +
      "\\GoogleAds\\V1\\Services\352\002$Google::Ads::Go" +
      "ogleAds::V1::Servicesb\006proto3"
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
          com.google.ads.googleads.v1.resources.CampaignDraftProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.longrunning.OperationsProto.getDescriptor(),
          com.google.protobuf.FieldMaskProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.google.rpc.StatusProto.getDescriptor(),
        }, assigner);
    internal_static_google_ads_googleads_v1_services_GetCampaignDraftRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v1_services_GetCampaignDraftRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_GetCampaignDraftRequest_descriptor,
        new java.lang.String[] { "ResourceName", });
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsRequest_descriptor,
        new java.lang.String[] { "CustomerId", "Operations", "PartialFailure", "ValidateOnly", });
    internal_static_google_ads_googleads_v1_services_PromoteCampaignDraftRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_ads_googleads_v1_services_PromoteCampaignDraftRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_PromoteCampaignDraftRequest_descriptor,
        new java.lang.String[] { "CampaignDraft", });
    internal_static_google_ads_googleads_v1_services_CampaignDraftOperation_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_ads_googleads_v1_services_CampaignDraftOperation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_CampaignDraftOperation_descriptor,
        new java.lang.String[] { "UpdateMask", "Create", "Update", "Remove", "Operation", });
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_MutateCampaignDraftsResponse_descriptor,
        new java.lang.String[] { "PartialFailureError", "Results", });
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftResult_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_ads_googleads_v1_services_MutateCampaignDraftResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_MutateCampaignDraftResult_descriptor,
        new java.lang.String[] { "ResourceName", });
    internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsRequest_descriptor,
        new java.lang.String[] { "ResourceName", "PageToken", "PageSize", });
    internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v1_services_ListCampaignDraftAsyncErrorsResponse_descriptor,
        new java.lang.String[] { "Errors", "NextPageToken", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.ads.googleads.v1.resources.CampaignDraftProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}