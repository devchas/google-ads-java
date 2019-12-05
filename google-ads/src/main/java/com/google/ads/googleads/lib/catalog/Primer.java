package com.google.ads.googleads.lib.catalog;

import com.google.auth.Credentials;

public abstract class Primer {

  private static final Primer INSTANCE = new DefaultPrimer();

  public static Primer getInstance() {
    return INSTANCE;
  }

  public abstract void primeCredentialsAsync(Credentials credentials);

  public abstract void primeForServiceClientAsync(Class<?> serviceClass);

  public abstract void primeGrpcAsync();

  public abstract void primeProtobufAsync();

  public abstract void primeAllVersionsAsync();

  public abstract void primeTransportChannelAsync(String endpoint);
}
