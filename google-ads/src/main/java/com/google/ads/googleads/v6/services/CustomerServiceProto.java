// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v6/services/customer_service.proto

package com.google.ads.googleads.v6.services;

public final class CustomerServiceProto {
  private CustomerServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_GetCustomerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_GetCustomerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_MutateCustomerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_MutateCustomerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_CreateCustomerClientRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_CreateCustomerClientRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_CustomerOperation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_CustomerOperation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_CreateCustomerClientResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_CreateCustomerClientResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_MutateCustomerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_MutateCustomerResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_MutateCustomerResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_MutateCustomerResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n7google/ads/googleads/v6/services/custo" +
      "mer_service.proto\022 google.ads.googleads." +
      "v6.services\032/google/ads/googleads/v6/enu" +
      "ms/access_role.proto\0329google/ads/googlea" +
      "ds/v6/enums/response_content_type.proto\032" +
      "0google/ads/googleads/v6/resources/custo" +
      "mer.proto\032\034google/api/annotations.proto\032" +
      "\027google/api/client.proto\032\037google/api/fie" +
      "ld_behavior.proto\032\031google/api/resource.p" +
      "roto\032 google/protobuf/field_mask.proto\"V" +
      "\n\022GetCustomerRequest\022@\n\rresource_name\030\001 " +
      "\001(\tB)\340A\002\372A#\n!googleads.googleapis.com/Cu" +
      "stomer\"\200\002\n\025MutateCustomerRequest\022\030\n\013cust" +
      "omer_id\030\001 \001(\tB\003\340A\002\022K\n\toperation\030\004 \001(\01323." +
      "google.ads.googleads.v6.services.Custome" +
      "rOperationB\003\340A\002\022\025\n\rvalidate_only\030\005 \001(\010\022i" +
      "\n\025response_content_type\030\006 \001(\0162J.google.a" +
      "ds.googleads.v6.enums.ResponseContentTyp" +
      "eEnum.ResponseContentType\"\377\001\n\033CreateCust" +
      "omerClientRequest\022\030\n\013customer_id\030\001 \001(\tB\003" +
      "\340A\002\022I\n\017customer_client\030\002 \001(\0132+.google.ad" +
      "s.googleads.v6.resources.CustomerB\003\340A\002\022\032" +
      "\n\remail_address\030\005 \001(\tH\000\210\001\001\022M\n\013access_rol" +
      "e\030\004 \001(\01628.google.ads.googleads.v6.enums." +
      "AccessRoleEnum.AccessRoleB\020\n\016_email_addr" +
      "ess\"\201\001\n\021CustomerOperation\022;\n\006update\030\001 \001(" +
      "\0132+.google.ads.googleads.v6.resources.Cu" +
      "stomer\022/\n\013update_mask\030\002 \001(\0132\032.google.pro" +
      "tobuf.FieldMask\"N\n\034CreateCustomerClientR" +
      "esponse\022\025\n\rresource_name\030\002 \001(\t\022\027\n\017invita" +
      "tion_link\030\003 \001(\t\"`\n\026MutateCustomerRespons" +
      "e\022F\n\006result\030\002 \001(\01326.google.ads.googleads" +
      ".v6.services.MutateCustomerResult\"l\n\024Mut" +
      "ateCustomerResult\022\025\n\rresource_name\030\001 \001(\t" +
      "\022=\n\010customer\030\002 \001(\0132+.google.ads.googlead" +
      "s.v6.resources.Customer\" \n\036ListAccessibl" +
      "eCustomersRequest\"9\n\037ListAccessibleCusto" +
      "mersResponse\022\026\n\016resource_names\030\001 \003(\t2\230\007\n" +
      "\017CustomerService\022\251\001\n\013GetCustomer\0224.googl" +
      "e.ads.googleads.v6.services.GetCustomerR" +
      "equest\032+.google.ads.googleads.v6.resourc" +
      "es.Customer\"7\202\323\344\223\002!\022\037/v6/{resource_name=" +
      "customers/*}\332A\rresource_name\022\314\001\n\016MutateC" +
      "ustomer\0227.google.ads.googleads.v6.servic" +
      "es.MutateCustomerRequest\0328.google.ads.go" +
      "ogleads.v6.services.MutateCustomerRespon" +
      "se\"G\202\323\344\223\002)\"$/v6/customers/{customer_id=*" +
      "}:mutate:\001*\332A\025customer_id,operation\022\315\001\n\027" +
      "ListAccessibleCustomers\022@.google.ads.goo" +
      "gleads.v6.services.ListAccessibleCustome" +
      "rsRequest\032A.google.ads.googleads.v6.serv" +
      "ices.ListAccessibleCustomersResponse\"-\202\323" +
      "\344\223\002\'\022%/v6/customers:listAccessibleCustom" +
      "ers\022\362\001\n\024CreateCustomerClient\022=.google.ad" +
      "s.googleads.v6.services.CreateCustomerCl" +
      "ientRequest\032>.google.ads.googleads.v6.se" +
      "rvices.CreateCustomerClientResponse\"[\202\323\344" +
      "\223\0027\"2/v6/customers/{customer_id=*}:creat" +
      "eCustomerClient:\001*\332A\033customer_id,custome" +
      "r_client\032E\312A\030googleads.googleapis.com\322A\'" +
      "https://www.googleapis.com/auth/adwordsB" +
      "\373\001\n$com.google.ads.googleads.v6.services" +
      "B\024CustomerServiceProtoP\001ZHgoogle.golang." +
      "org/genproto/googleapis/ads/googleads/v6" +
      "/services;services\242\002\003GAA\252\002 Google.Ads.Go" +
      "ogleAds.V6.Services\312\002 Google\\Ads\\GoogleA" +
      "ds\\V6\\Services\352\002$Google::Ads::GoogleAds:" +
      ":V6::Servicesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.ads.googleads.v6.enums.AccessRoleProto.getDescriptor(),
          com.google.ads.googleads.v6.enums.ResponseContentTypeProto.getDescriptor(),
          com.google.ads.googleads.v6.resources.CustomerProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          com.google.protobuf.FieldMaskProto.getDescriptor(),
        });
    internal_static_google_ads_googleads_v6_services_GetCustomerRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_googleads_v6_services_GetCustomerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_GetCustomerRequest_descriptor,
        new java.lang.String[] { "ResourceName", });
    internal_static_google_ads_googleads_v6_services_MutateCustomerRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_ads_googleads_v6_services_MutateCustomerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_MutateCustomerRequest_descriptor,
        new java.lang.String[] { "CustomerId", "Operation", "ValidateOnly", "ResponseContentType", });
    internal_static_google_ads_googleads_v6_services_CreateCustomerClientRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_ads_googleads_v6_services_CreateCustomerClientRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_CreateCustomerClientRequest_descriptor,
        new java.lang.String[] { "CustomerId", "CustomerClient", "EmailAddress", "AccessRole", "EmailAddress", });
    internal_static_google_ads_googleads_v6_services_CustomerOperation_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_ads_googleads_v6_services_CustomerOperation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_CustomerOperation_descriptor,
        new java.lang.String[] { "Update", "UpdateMask", });
    internal_static_google_ads_googleads_v6_services_CreateCustomerClientResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_ads_googleads_v6_services_CreateCustomerClientResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_CreateCustomerClientResponse_descriptor,
        new java.lang.String[] { "ResourceName", "InvitationLink", });
    internal_static_google_ads_googleads_v6_services_MutateCustomerResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_ads_googleads_v6_services_MutateCustomerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_MutateCustomerResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_google_ads_googleads_v6_services_MutateCustomerResult_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_ads_googleads_v6_services_MutateCustomerResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_MutateCustomerResult_descriptor,
        new java.lang.String[] { "ResourceName", "Customer", });
    internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersRequest_descriptor,
        new java.lang.String[] { });
    internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_ads_googleads_v6_services_ListAccessibleCustomersResponse_descriptor,
        new java.lang.String[] { "ResourceNames", });
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
    com.google.ads.googleads.v6.enums.AccessRoleProto.getDescriptor();
    com.google.ads.googleads.v6.enums.ResponseContentTypeProto.getDescriptor();
    com.google.ads.googleads.v6.resources.CustomerProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
