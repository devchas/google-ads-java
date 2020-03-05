// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ads/googleads/v3/common/ad_type_infos.proto

package com.google.ads.googleads.v3.common;

/**
 * <pre>
 * Product image specific data.
 * </pre>
 *
 * Protobuf type {@code google.ads.googleads.v3.common.ProductImage}
 */
public  final class ProductImage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.ads.googleads.v3.common.ProductImage)
    ProductImageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ProductImage.newBuilder() to construct.
  private ProductImage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ProductImage() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ProductImage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.google.protobuf.StringValue.Builder subBuilder = null;
            if (productImage_ != null) {
              subBuilder = productImage_.toBuilder();
            }
            productImage_ = input.readMessage(com.google.protobuf.StringValue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(productImage_);
              productImage_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.google.protobuf.StringValue.Builder subBuilder = null;
            if (description_ != null) {
              subBuilder = description_.toBuilder();
            }
            description_ = input.readMessage(com.google.protobuf.StringValue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(description_);
              description_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.google.ads.googleads.v3.common.DisplayCallToAction.Builder subBuilder = null;
            if (displayCallToAction_ != null) {
              subBuilder = displayCallToAction_.toBuilder();
            }
            displayCallToAction_ = input.readMessage(com.google.ads.googleads.v3.common.DisplayCallToAction.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(displayCallToAction_);
              displayCallToAction_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.ads.googleads.v3.common.AdTypeInfosProto.internal_static_google_ads_googleads_v3_common_ProductImage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ads.googleads.v3.common.AdTypeInfosProto.internal_static_google_ads_googleads_v3_common_ProductImage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ads.googleads.v3.common.ProductImage.class, com.google.ads.googleads.v3.common.ProductImage.Builder.class);
  }

  public static final int PRODUCT_IMAGE_FIELD_NUMBER = 1;
  private com.google.protobuf.StringValue productImage_;
  /**
   * <pre>
   * The MediaFile resource name of the product image. Valid image types are
   * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
   * must be 1:1 (+-1%).
   * </pre>
   *
   * <code>.google.protobuf.StringValue product_image = 1;</code>
   */
  public boolean hasProductImage() {
    return productImage_ != null;
  }
  /**
   * <pre>
   * The MediaFile resource name of the product image. Valid image types are
   * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
   * must be 1:1 (+-1%).
   * </pre>
   *
   * <code>.google.protobuf.StringValue product_image = 1;</code>
   */
  public com.google.protobuf.StringValue getProductImage() {
    return productImage_ == null ? com.google.protobuf.StringValue.getDefaultInstance() : productImage_;
  }
  /**
   * <pre>
   * The MediaFile resource name of the product image. Valid image types are
   * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
   * must be 1:1 (+-1%).
   * </pre>
   *
   * <code>.google.protobuf.StringValue product_image = 1;</code>
   */
  public com.google.protobuf.StringValueOrBuilder getProductImageOrBuilder() {
    return getProductImage();
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  private com.google.protobuf.StringValue description_;
  /**
   * <pre>
   * Description of the product.
   * </pre>
   *
   * <code>.google.protobuf.StringValue description = 2;</code>
   */
  public boolean hasDescription() {
    return description_ != null;
  }
  /**
   * <pre>
   * Description of the product.
   * </pre>
   *
   * <code>.google.protobuf.StringValue description = 2;</code>
   */
  public com.google.protobuf.StringValue getDescription() {
    return description_ == null ? com.google.protobuf.StringValue.getDefaultInstance() : description_;
  }
  /**
   * <pre>
   * Description of the product.
   * </pre>
   *
   * <code>.google.protobuf.StringValue description = 2;</code>
   */
  public com.google.protobuf.StringValueOrBuilder getDescriptionOrBuilder() {
    return getDescription();
  }

  public static final int DISPLAY_CALL_TO_ACTION_FIELD_NUMBER = 3;
  private com.google.ads.googleads.v3.common.DisplayCallToAction displayCallToAction_;
  /**
   * <pre>
   * Display-call-to-action of the product image.
   * </pre>
   *
   * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
   */
  public boolean hasDisplayCallToAction() {
    return displayCallToAction_ != null;
  }
  /**
   * <pre>
   * Display-call-to-action of the product image.
   * </pre>
   *
   * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
   */
  public com.google.ads.googleads.v3.common.DisplayCallToAction getDisplayCallToAction() {
    return displayCallToAction_ == null ? com.google.ads.googleads.v3.common.DisplayCallToAction.getDefaultInstance() : displayCallToAction_;
  }
  /**
   * <pre>
   * Display-call-to-action of the product image.
   * </pre>
   *
   * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
   */
  public com.google.ads.googleads.v3.common.DisplayCallToActionOrBuilder getDisplayCallToActionOrBuilder() {
    return getDisplayCallToAction();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (productImage_ != null) {
      output.writeMessage(1, getProductImage());
    }
    if (description_ != null) {
      output.writeMessage(2, getDescription());
    }
    if (displayCallToAction_ != null) {
      output.writeMessage(3, getDisplayCallToAction());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (productImage_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getProductImage());
    }
    if (description_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getDescription());
    }
    if (displayCallToAction_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getDisplayCallToAction());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.ads.googleads.v3.common.ProductImage)) {
      return super.equals(obj);
    }
    com.google.ads.googleads.v3.common.ProductImage other = (com.google.ads.googleads.v3.common.ProductImage) obj;

    if (hasProductImage() != other.hasProductImage()) return false;
    if (hasProductImage()) {
      if (!getProductImage()
          .equals(other.getProductImage())) return false;
    }
    if (hasDescription() != other.hasDescription()) return false;
    if (hasDescription()) {
      if (!getDescription()
          .equals(other.getDescription())) return false;
    }
    if (hasDisplayCallToAction() != other.hasDisplayCallToAction()) return false;
    if (hasDisplayCallToAction()) {
      if (!getDisplayCallToAction()
          .equals(other.getDisplayCallToAction())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasProductImage()) {
      hash = (37 * hash) + PRODUCT_IMAGE_FIELD_NUMBER;
      hash = (53 * hash) + getProductImage().hashCode();
    }
    if (hasDescription()) {
      hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
      hash = (53 * hash) + getDescription().hashCode();
    }
    if (hasDisplayCallToAction()) {
      hash = (37 * hash) + DISPLAY_CALL_TO_ACTION_FIELD_NUMBER;
      hash = (53 * hash) + getDisplayCallToAction().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ads.googleads.v3.common.ProductImage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.ads.googleads.v3.common.ProductImage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Product image specific data.
   * </pre>
   *
   * Protobuf type {@code google.ads.googleads.v3.common.ProductImage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.ads.googleads.v3.common.ProductImage)
      com.google.ads.googleads.v3.common.ProductImageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.ads.googleads.v3.common.AdTypeInfosProto.internal_static_google_ads_googleads_v3_common_ProductImage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ads.googleads.v3.common.AdTypeInfosProto.internal_static_google_ads_googleads_v3_common_ProductImage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ads.googleads.v3.common.ProductImage.class, com.google.ads.googleads.v3.common.ProductImage.Builder.class);
    }

    // Construct using com.google.ads.googleads.v3.common.ProductImage.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (productImageBuilder_ == null) {
        productImage_ = null;
      } else {
        productImage_ = null;
        productImageBuilder_ = null;
      }
      if (descriptionBuilder_ == null) {
        description_ = null;
      } else {
        description_ = null;
        descriptionBuilder_ = null;
      }
      if (displayCallToActionBuilder_ == null) {
        displayCallToAction_ = null;
      } else {
        displayCallToAction_ = null;
        displayCallToActionBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.ads.googleads.v3.common.AdTypeInfosProto.internal_static_google_ads_googleads_v3_common_ProductImage_descriptor;
    }

    @java.lang.Override
    public com.google.ads.googleads.v3.common.ProductImage getDefaultInstanceForType() {
      return com.google.ads.googleads.v3.common.ProductImage.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ads.googleads.v3.common.ProductImage build() {
      com.google.ads.googleads.v3.common.ProductImage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ads.googleads.v3.common.ProductImage buildPartial() {
      com.google.ads.googleads.v3.common.ProductImage result = new com.google.ads.googleads.v3.common.ProductImage(this);
      if (productImageBuilder_ == null) {
        result.productImage_ = productImage_;
      } else {
        result.productImage_ = productImageBuilder_.build();
      }
      if (descriptionBuilder_ == null) {
        result.description_ = description_;
      } else {
        result.description_ = descriptionBuilder_.build();
      }
      if (displayCallToActionBuilder_ == null) {
        result.displayCallToAction_ = displayCallToAction_;
      } else {
        result.displayCallToAction_ = displayCallToActionBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.ads.googleads.v3.common.ProductImage) {
        return mergeFrom((com.google.ads.googleads.v3.common.ProductImage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ads.googleads.v3.common.ProductImage other) {
      if (other == com.google.ads.googleads.v3.common.ProductImage.getDefaultInstance()) return this;
      if (other.hasProductImage()) {
        mergeProductImage(other.getProductImage());
      }
      if (other.hasDescription()) {
        mergeDescription(other.getDescription());
      }
      if (other.hasDisplayCallToAction()) {
        mergeDisplayCallToAction(other.getDisplayCallToAction());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.ads.googleads.v3.common.ProductImage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.ads.googleads.v3.common.ProductImage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.StringValue productImage_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder> productImageBuilder_;
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public boolean hasProductImage() {
      return productImageBuilder_ != null || productImage_ != null;
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public com.google.protobuf.StringValue getProductImage() {
      if (productImageBuilder_ == null) {
        return productImage_ == null ? com.google.protobuf.StringValue.getDefaultInstance() : productImage_;
      } else {
        return productImageBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public Builder setProductImage(com.google.protobuf.StringValue value) {
      if (productImageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        productImage_ = value;
        onChanged();
      } else {
        productImageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public Builder setProductImage(
        com.google.protobuf.StringValue.Builder builderForValue) {
      if (productImageBuilder_ == null) {
        productImage_ = builderForValue.build();
        onChanged();
      } else {
        productImageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public Builder mergeProductImage(com.google.protobuf.StringValue value) {
      if (productImageBuilder_ == null) {
        if (productImage_ != null) {
          productImage_ =
            com.google.protobuf.StringValue.newBuilder(productImage_).mergeFrom(value).buildPartial();
        } else {
          productImage_ = value;
        }
        onChanged();
      } else {
        productImageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public Builder clearProductImage() {
      if (productImageBuilder_ == null) {
        productImage_ = null;
        onChanged();
      } else {
        productImage_ = null;
        productImageBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public com.google.protobuf.StringValue.Builder getProductImageBuilder() {
      
      onChanged();
      return getProductImageFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    public com.google.protobuf.StringValueOrBuilder getProductImageOrBuilder() {
      if (productImageBuilder_ != null) {
        return productImageBuilder_.getMessageOrBuilder();
      } else {
        return productImage_ == null ?
            com.google.protobuf.StringValue.getDefaultInstance() : productImage_;
      }
    }
    /**
     * <pre>
     * The MediaFile resource name of the product image. Valid image types are
     * GIF, JPEG and PNG. The minimum size is 300x300 pixels and the aspect ratio
     * must be 1:1 (+-1%).
     * </pre>
     *
     * <code>.google.protobuf.StringValue product_image = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder> 
        getProductImageFieldBuilder() {
      if (productImageBuilder_ == null) {
        productImageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder>(
                getProductImage(),
                getParentForChildren(),
                isClean());
        productImage_ = null;
      }
      return productImageBuilder_;
    }

    private com.google.protobuf.StringValue description_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder> descriptionBuilder_;
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public boolean hasDescription() {
      return descriptionBuilder_ != null || description_ != null;
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public com.google.protobuf.StringValue getDescription() {
      if (descriptionBuilder_ == null) {
        return description_ == null ? com.google.protobuf.StringValue.getDefaultInstance() : description_;
      } else {
        return descriptionBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public Builder setDescription(com.google.protobuf.StringValue value) {
      if (descriptionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        description_ = value;
        onChanged();
      } else {
        descriptionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public Builder setDescription(
        com.google.protobuf.StringValue.Builder builderForValue) {
      if (descriptionBuilder_ == null) {
        description_ = builderForValue.build();
        onChanged();
      } else {
        descriptionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public Builder mergeDescription(com.google.protobuf.StringValue value) {
      if (descriptionBuilder_ == null) {
        if (description_ != null) {
          description_ =
            com.google.protobuf.StringValue.newBuilder(description_).mergeFrom(value).buildPartial();
        } else {
          description_ = value;
        }
        onChanged();
      } else {
        descriptionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public Builder clearDescription() {
      if (descriptionBuilder_ == null) {
        description_ = null;
        onChanged();
      } else {
        description_ = null;
        descriptionBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public com.google.protobuf.StringValue.Builder getDescriptionBuilder() {
      
      onChanged();
      return getDescriptionFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    public com.google.protobuf.StringValueOrBuilder getDescriptionOrBuilder() {
      if (descriptionBuilder_ != null) {
        return descriptionBuilder_.getMessageOrBuilder();
      } else {
        return description_ == null ?
            com.google.protobuf.StringValue.getDefaultInstance() : description_;
      }
    }
    /**
     * <pre>
     * Description of the product.
     * </pre>
     *
     * <code>.google.protobuf.StringValue description = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder> 
        getDescriptionFieldBuilder() {
      if (descriptionBuilder_ == null) {
        descriptionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder>(
                getDescription(),
                getParentForChildren(),
                isClean());
        description_ = null;
      }
      return descriptionBuilder_;
    }

    private com.google.ads.googleads.v3.common.DisplayCallToAction displayCallToAction_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.ads.googleads.v3.common.DisplayCallToAction, com.google.ads.googleads.v3.common.DisplayCallToAction.Builder, com.google.ads.googleads.v3.common.DisplayCallToActionOrBuilder> displayCallToActionBuilder_;
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public boolean hasDisplayCallToAction() {
      return displayCallToActionBuilder_ != null || displayCallToAction_ != null;
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public com.google.ads.googleads.v3.common.DisplayCallToAction getDisplayCallToAction() {
      if (displayCallToActionBuilder_ == null) {
        return displayCallToAction_ == null ? com.google.ads.googleads.v3.common.DisplayCallToAction.getDefaultInstance() : displayCallToAction_;
      } else {
        return displayCallToActionBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public Builder setDisplayCallToAction(com.google.ads.googleads.v3.common.DisplayCallToAction value) {
      if (displayCallToActionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        displayCallToAction_ = value;
        onChanged();
      } else {
        displayCallToActionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public Builder setDisplayCallToAction(
        com.google.ads.googleads.v3.common.DisplayCallToAction.Builder builderForValue) {
      if (displayCallToActionBuilder_ == null) {
        displayCallToAction_ = builderForValue.build();
        onChanged();
      } else {
        displayCallToActionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public Builder mergeDisplayCallToAction(com.google.ads.googleads.v3.common.DisplayCallToAction value) {
      if (displayCallToActionBuilder_ == null) {
        if (displayCallToAction_ != null) {
          displayCallToAction_ =
            com.google.ads.googleads.v3.common.DisplayCallToAction.newBuilder(displayCallToAction_).mergeFrom(value).buildPartial();
        } else {
          displayCallToAction_ = value;
        }
        onChanged();
      } else {
        displayCallToActionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public Builder clearDisplayCallToAction() {
      if (displayCallToActionBuilder_ == null) {
        displayCallToAction_ = null;
        onChanged();
      } else {
        displayCallToAction_ = null;
        displayCallToActionBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public com.google.ads.googleads.v3.common.DisplayCallToAction.Builder getDisplayCallToActionBuilder() {
      
      onChanged();
      return getDisplayCallToActionFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    public com.google.ads.googleads.v3.common.DisplayCallToActionOrBuilder getDisplayCallToActionOrBuilder() {
      if (displayCallToActionBuilder_ != null) {
        return displayCallToActionBuilder_.getMessageOrBuilder();
      } else {
        return displayCallToAction_ == null ?
            com.google.ads.googleads.v3.common.DisplayCallToAction.getDefaultInstance() : displayCallToAction_;
      }
    }
    /**
     * <pre>
     * Display-call-to-action of the product image.
     * </pre>
     *
     * <code>.google.ads.googleads.v3.common.DisplayCallToAction display_call_to_action = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.ads.googleads.v3.common.DisplayCallToAction, com.google.ads.googleads.v3.common.DisplayCallToAction.Builder, com.google.ads.googleads.v3.common.DisplayCallToActionOrBuilder> 
        getDisplayCallToActionFieldBuilder() {
      if (displayCallToActionBuilder_ == null) {
        displayCallToActionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.ads.googleads.v3.common.DisplayCallToAction, com.google.ads.googleads.v3.common.DisplayCallToAction.Builder, com.google.ads.googleads.v3.common.DisplayCallToActionOrBuilder>(
                getDisplayCallToAction(),
                getParentForChildren(),
                isClean());
        displayCallToAction_ = null;
      }
      return displayCallToActionBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.ads.googleads.v3.common.ProductImage)
  }

  // @@protoc_insertion_point(class_scope:google.ads.googleads.v3.common.ProductImage)
  private static final com.google.ads.googleads.v3.common.ProductImage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.ads.googleads.v3.common.ProductImage();
  }

  public static com.google.ads.googleads.v3.common.ProductImage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ProductImage>
      PARSER = new com.google.protobuf.AbstractParser<ProductImage>() {
    @java.lang.Override
    public ProductImage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ProductImage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ProductImage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ProductImage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ads.googleads.v3.common.ProductImage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
