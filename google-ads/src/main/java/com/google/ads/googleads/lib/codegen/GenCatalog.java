package com.google.ads.googleads.lib.codegen;

import com.google.ads.googleads.lib.GoogleAdsAllVersions;
import com.google.ads.googleads.lib.catalog.ApiCatalog;
import com.google.ads.googleads.lib.catalog.Version;
import com.google.ads.googleads.v2.errors.GoogleAdsException.Factory;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.lang.model.element.Modifier;

/** Dynamically generates the NoReflectionApiCatalog class. */
public class GenCatalog {

  public static void main(String[] args) {
    if (args.length < 3) {
      throw new IllegalArgumentException("Three arguments are required.");
    }

    List<Integer> versions = getVersions(args);
    int latestVersion = Integer.parseInt(args[0]);

    try {
      FieldSpec instance = FieldSpec.builder(ApiCatalog.class, "instance")
          .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
          // TO DO: Update class name to 'NoReflectionApiCatalog()'
          .initializer("new NoReflectionApiCatalog()")
          .build();

      MethodSpec getDefault = MethodSpec.methodBuilder("getDefault")
          .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
          .returns(ApiCatalog.class)
          .addStatement("return instance")
          .build();

      MethodSpec main = MethodSpec.constructorBuilder()
          .addModifiers(Modifier.PUBLIC)
          .addStatement("super($T.asList(new $T(\"v999\", new $T(), $T.class)))",
              Arrays.class,
              Version.class,
              Factory.class,
              Class.forName(
                  "com.google.ads.googleads.v" + latestVersion + ".services.GoogleAdsVersion"))
          .addJavadoc("Creates a new constant catalog from a known collection of versions")
          .build();

      // Creates the createAllVersionsClient method.
      MethodSpec createAllVersionsClient = createAllVersionsClient(versions);

      // Creates the NoReflectionApiCatalog class.
      // TO DO: update class name to 'NoReflectionApiCatalog'
      TypeSpec.Builder noReflectionApiCatalogBuilder = TypeSpec.classBuilder("NoReflectionApiCatalog")
          .addModifiers(Modifier.PUBLIC)
          .superclass(com.google.ads.googleads.lib.catalog.ApiCatalogImpl.class)
          .addField(instance)
          .addMethod(getDefault)
          .addMethod(main)
          .addMethod(createAllVersionsClient);

      // Creates a version class for each version.
      for (Integer version : versions) {
        noReflectionApiCatalogBuilder.addType(createClient(version));
      }

      TypeSpec noReflectionApiCatalog = noReflectionApiCatalogBuilder.build();

      JavaFile javaFile = JavaFile.builder("com.google.ads.googleads.lib.catalog", noReflectionApiCatalog)
          .build();

      javaFile.writeTo(Paths.get("./google-ads/src/main/java"));
    } catch (IOException ioe) {
      System.err.printf("Failed to create file. Exception: %s%n", ioe);
      return;
    } catch (ClassNotFoundException cnfe) {
      System.err.printf("Failed to create class. Exception: %s%n", cnfe);
    }
  }

  /** Gets a list of the current versions of the library. */
  private static List<Integer> getVersions(String[] args) {
    int latestVersion = Integer.parseInt(args[0]);
    int numProdVersions = Integer.parseInt(args[1]);

    List<Integer> versions = new ArrayList<>();
    int version = latestVersion;
    for (int i = 0; i < numProdVersions; i++) {
      versions.add(version);
      version -= 1;
    }
    if ("true".equals(args[2])) {
      versions.add(999);
    }
    return versions;
  }

  /** Creates the createAllVersionsClient method. */
  private static MethodSpec createAllVersionsClient(List<Integer> versions) throws ClassNotFoundException {
    TypeSpec.Builder comparatorBuilder = TypeSpec.anonymousClassBuilder("")
        .addSuperinterface(ParameterizedTypeName.get(GoogleAdsAllVersions.class));

    Integer latestVersion = null;
    for (Integer version : versions) {
      // Gets the latest production version.
      if ((latestVersion == null || version > latestVersion) && version != 999) {
        latestVersion = version;
      }
      // Adds the version method.
      comparatorBuilder.addMethod(getVersion(version));
    }

    comparatorBuilder.addMethod(MethodSpec.methodBuilder("getLatestVersion")
        .addAnnotation(Override.class)
        .addModifiers(Modifier.PUBLIC)
        .returns(Class.forName(
            "com.google.ads.googleads.v" + latestVersion + ".services.GoogleAdsVersion"))
        .addStatement("return getVersion$L()", latestVersion)
        .build());

    TypeSpec comparator = comparatorBuilder.build();

    return MethodSpec.methodBuilder("createAllVersionsClient")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .addStatement("return $L", comparator)
        .returns(GoogleAdsAllVersions.class)
        .addParameter(TransportChannelProvider.class, "provider")
        .addParameter(Credentials.class, "credentials")
        .build();
  }

  /** Creates a method to get a particular GoogleAdsVersion. */
  private static MethodSpec getVersion(int version) throws ClassNotFoundException {
    return MethodSpec.methodBuilder("getVersion" + version)
        .addAnnotation(Override.class)
        .addModifiers(Modifier.PUBLIC)
        .returns(createClassName(version, "GoogleAdsVersion"))
        .addStatement("return new V" + version + "Client(provider, credentials)")
        .build();
  }

  /** Creates a client to access all service clients for a given version. */
  private static TypeSpec createClient(int version) throws ClassNotFoundException {
    FieldSpec provider = FieldSpec.builder(TransportChannelProvider.class, "provider")
        .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
        .build();

    FieldSpec credentials = FieldSpec.builder(Credentials.class, "credentials")
        .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
        .build();

    MethodSpec constructor = MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PUBLIC)
        .addParameter(TransportChannelProvider.class, "provider")
        .addParameter(Credentials.class, "credentials")
        .addStatement("this.provider = provider")
        .addStatement("this.credentials = credentials")
        .build();

    TypeSpec.Builder clientBuilder = TypeSpec.classBuilder("V" + version + "Client")
        .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
        .addSuperinterface(Class.forName(
            "com.google.ads.googleads.v" + version + ".services.GoogleAdsVersion"))
        .addField(provider)
        .addField(credentials)
        .addMethod(constructor);

    // Retrieves all of the available methods from a given GoogleAdsVersion.
    Class googleAdsVersion = createClassName(version, "GoogleAdsVersion");
    Method[] methods = googleAdsVersion.getDeclaredMethods();
    for (Method method : methods) {
      String methodName = method.getName();
      // Trims preceding 'create' from method name.
      String serviceClient = methodName.substring(6);
      clientBuilder.addMethod(createServiceClient(version, serviceClient));
    }

    return clientBuilder.build();
  }

  /** Creates a service client creation method for a given version and service client. */
  private static MethodSpec createServiceClient(int version, String serviceClient)
      throws ClassNotFoundException{

    MethodSpec.Builder serviceBuilder = MethodSpec.methodBuilder("create" + serviceClient)
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(Class.forName(
            "com.google.ads.googleads.v" + version + ".services." + serviceClient));

    // Gets the name of the service without the word 'client'.
    String noClientName = serviceClient.substring(0, serviceClient.length() - 6);

    serviceBuilder.addCode(""
            + "try {\n"
            + "  $T settings =\n"
            + "    $T.newBuilder()\n"
            + "      .setCredentialsProvider($T.create(credentials))\n"
            + "      .setTransportChannelProvider(provider)\n"
            + "      .build();\n"
            + "  return $T.create(settings);\n"
            + "} catch ($T e) {\n"
            + "  throw new RuntimeException(e);\n"
            + "}\n",
        createClassName(version, noClientName + "Settings"),
        createClassName(version, noClientName + "Settings"),
        FixedCredentialsProvider.class,
        createClassName(version, serviceClient),
        IOException.class);

    return serviceBuilder.build();
  }

  /** Create a class given a version and service client. */
  private static Class createClassName(int version, String serviceClient)
      throws ClassNotFoundException {
    return Class.forName("com.google.ads.googleads.v" + version + ".services." + serviceClient);
  }
}
