// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v1/services/conversion_upload_service.proto

package com.google.ads.googleads.v1.services;

public interface CallConversionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ads.googleads.v1.services.CallConversion)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The caller id from which this call was placed. Caller id is expected to be
   * in E.164 format with preceding '+' sign. e.g. "+16502531234".
   * </pre>
   *
   * <code>.google.protobuf.StringValue caller_id = 1;</code>
   */
  boolean hasCallerId();
  /**
   * <pre>
   * The caller id from which this call was placed. Caller id is expected to be
   * in E.164 format with preceding '+' sign. e.g. "+16502531234".
   * </pre>
   *
   * <code>.google.protobuf.StringValue caller_id = 1;</code>
   */
  com.google.protobuf.StringValue getCallerId();
  /**
   * <pre>
   * The caller id from which this call was placed. Caller id is expected to be
   * in E.164 format with preceding '+' sign. e.g. "+16502531234".
   * </pre>
   *
   * <code>.google.protobuf.StringValue caller_id = 1;</code>
   */
  com.google.protobuf.StringValueOrBuilder getCallerIdOrBuilder();

  /**
   * <pre>
   * The date time at which the call occurred. The timezone must be specified.
   * The format is "yyyy-mm-dd hh:mm:ss+|-hh:mm",
   * e.g. "2019-01-01 12:32:45-08:00".
   * </pre>
   *
   * <code>.google.protobuf.StringValue call_start_date_time = 2;</code>
   */
  boolean hasCallStartDateTime();
  /**
   * <pre>
   * The date time at which the call occurred. The timezone must be specified.
   * The format is "yyyy-mm-dd hh:mm:ss+|-hh:mm",
   * e.g. "2019-01-01 12:32:45-08:00".
   * </pre>
   *
   * <code>.google.protobuf.StringValue call_start_date_time = 2;</code>
   */
  com.google.protobuf.StringValue getCallStartDateTime();
  /**
   * <pre>
   * The date time at which the call occurred. The timezone must be specified.
   * The format is "yyyy-mm-dd hh:mm:ss+|-hh:mm",
   * e.g. "2019-01-01 12:32:45-08:00".
   * </pre>
   *
   * <code>.google.protobuf.StringValue call_start_date_time = 2;</code>
   */
  com.google.protobuf.StringValueOrBuilder getCallStartDateTimeOrBuilder();

  /**
   * <pre>
   * Resource name of the conversion action associated with this conversion.
   * Note: Although this resource name consists of a customer id and a
   * conversion action id, validation will ignore the customer id and use the
   * conversion action id as the sole identifier of the conversion action.
   * </pre>
   *
   * <code>.google.protobuf.StringValue conversion_action = 3;</code>
   */
  boolean hasConversionAction();
  /**
   * <pre>
   * Resource name of the conversion action associated with this conversion.
   * Note: Although this resource name consists of a customer id and a
   * conversion action id, validation will ignore the customer id and use the
   * conversion action id as the sole identifier of the conversion action.
   * </pre>
   *
   * <code>.google.protobuf.StringValue conversion_action = 3;</code>
   */
  com.google.protobuf.StringValue getConversionAction();
  /**
   * <pre>
   * Resource name of the conversion action associated with this conversion.
   * Note: Although this resource name consists of a customer id and a
   * conversion action id, validation will ignore the customer id and use the
   * conversion action id as the sole identifier of the conversion action.
   * </pre>
   *
   * <code>.google.protobuf.StringValue conversion_action = 3;</code>
   */
  com.google.protobuf.StringValueOrBuilder getConversionActionOrBuilder();

  /**
   * <pre>
   * The date time at which the conversion occurred. Must be after the call
   * time. The timezone must be specified. The format is
   * "yyyy-mm-dd hh:mm:ss+|-hh:mm", e.g. "2019-01-01 12:32:45-08:00".
   * </pre>
   *
   * <code>.google.protobuf.StringValue conversion_date_time = 4;</code>
   */
  boolean hasConversionDateTime();
  /**
   * <pre>
   * The date time at which the conversion occurred. Must be after the call
   * time. The timezone must be specified. The format is
   * "yyyy-mm-dd hh:mm:ss+|-hh:mm", e.g. "2019-01-01 12:32:45-08:00".
   * </pre>
   *
   * <code>.google.protobuf.StringValue conversion_date_time = 4;</code>
   */
  com.google.protobuf.StringValue getConversionDateTime();
  /**
   * <pre>
   * The date time at which the conversion occurred. Must be after the call
   * time. The timezone must be specified. The format is
   * "yyyy-mm-dd hh:mm:ss+|-hh:mm", e.g. "2019-01-01 12:32:45-08:00".
   * </pre>
   *
   * <code>.google.protobuf.StringValue conversion_date_time = 4;</code>
   */
  com.google.protobuf.StringValueOrBuilder getConversionDateTimeOrBuilder();

  /**
   * <pre>
   * The value of the conversion for the advertiser.
   * </pre>
   *
   * <code>.google.protobuf.DoubleValue conversion_value = 5;</code>
   */
  boolean hasConversionValue();
  /**
   * <pre>
   * The value of the conversion for the advertiser.
   * </pre>
   *
   * <code>.google.protobuf.DoubleValue conversion_value = 5;</code>
   */
  com.google.protobuf.DoubleValue getConversionValue();
  /**
   * <pre>
   * The value of the conversion for the advertiser.
   * </pre>
   *
   * <code>.google.protobuf.DoubleValue conversion_value = 5;</code>
   */
  com.google.protobuf.DoubleValueOrBuilder getConversionValueOrBuilder();

  /**
   * <pre>
   * Currency associated with the conversion value. This is the ISO 4217
   * 3-character currency code. For example: USD, EUR.
   * </pre>
   *
   * <code>.google.protobuf.StringValue currency_code = 6;</code>
   */
  boolean hasCurrencyCode();
  /**
   * <pre>
   * Currency associated with the conversion value. This is the ISO 4217
   * 3-character currency code. For example: USD, EUR.
   * </pre>
   *
   * <code>.google.protobuf.StringValue currency_code = 6;</code>
   */
  com.google.protobuf.StringValue getCurrencyCode();
  /**
   * <pre>
   * Currency associated with the conversion value. This is the ISO 4217
   * 3-character currency code. For example: USD, EUR.
   * </pre>
   *
   * <code>.google.protobuf.StringValue currency_code = 6;</code>
   */
  com.google.protobuf.StringValueOrBuilder getCurrencyCodeOrBuilder();
}
