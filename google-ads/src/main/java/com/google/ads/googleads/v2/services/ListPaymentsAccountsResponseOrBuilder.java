// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v2/services/payments_account_service.proto

package com.google.ads.googleads.v2.services;

public interface ListPaymentsAccountsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ads.googleads.v2.services.ListPaymentsAccountsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The list of accessible payments accounts.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v2.resources.PaymentsAccount payments_accounts = 1;</code>
   */
  java.util.List<com.google.ads.googleads.v2.resources.PaymentsAccount> 
      getPaymentsAccountsList();
  /**
   * <pre>
   * The list of accessible payments accounts.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v2.resources.PaymentsAccount payments_accounts = 1;</code>
   */
  com.google.ads.googleads.v2.resources.PaymentsAccount getPaymentsAccounts(int index);
  /**
   * <pre>
   * The list of accessible payments accounts.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v2.resources.PaymentsAccount payments_accounts = 1;</code>
   */
  int getPaymentsAccountsCount();
  /**
   * <pre>
   * The list of accessible payments accounts.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v2.resources.PaymentsAccount payments_accounts = 1;</code>
   */
  java.util.List<? extends com.google.ads.googleads.v2.resources.PaymentsAccountOrBuilder> 
      getPaymentsAccountsOrBuilderList();
  /**
   * <pre>
   * The list of accessible payments accounts.
   * </pre>
   *
   * <code>repeated .google.ads.googleads.v2.resources.PaymentsAccount payments_accounts = 1;</code>
   */
  com.google.ads.googleads.v2.resources.PaymentsAccountOrBuilder getPaymentsAccountsOrBuilder(
      int index);
}
