package com.google.ads.googleads.processor.factory.processor;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableSortedSet;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Modifier;
import javax.tools.Diagnostic;

public class FactoryCollector {

  private static HashMap<String, String> requiredClasses = new HashMap<String, String>();
  private Messager messager;


  public FactoryCollector(Messager messager) {
    this.messager = messager;
  }

  public void addClassElement(AnnotatedClass annotatedClass) {
    String id = annotatedClass.getId();
    if (getElementClass(id) != null) { return; }
    requiredClasses.put(id, annotatedClass.getQualifiedFactoryGroupName());
  }

  public static String getElementClass(String id) {
    return requiredClasses.get(id);
  }

  public void generateCode(Filer filer) throws IOException {
    String[] args = {"2", "2", "false"};

    List<Integer> versions = getVersions(args);
    int latestVersion = Integer.parseInt(args[0]);

    try {
      FieldSpec instance = FieldSpec
          .builder(Class.forName(getElementClass("ApiCatalog")), "instance")
          .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
          .initializer("new NoReflectionApiCatalog($T.forVersionList($T.class).getVersions())",
              getElementClass("VersionDescriptorLoader"),
              getElementClass("GoogleAdsAllVersions"))
          .build();

      FieldSpec supportedVersions = FieldSpec
          .builder(ParameterizedTypeName.get(
              ImmutableSortedSet.class,
              Class.forName(getElementClass("Version"))),
             "supportedVersions")
          .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
          .build();

      MethodSpec constructor = MethodSpec.constructorBuilder()
          .addModifiers(Modifier.PUBLIC)
          .addParameter(ParameterizedTypeName.get(
              ImmutableSortedSet.class,
              Class.forName(getElementClass("Version"))),
              "versions")
          .addStatement("supportedVersions = $T.copyOf(new $T<>(versions))",
              ImmutableSortedSet.class,
              TreeSet.class)
          .addJavadoc("Creates a new constant catalog from a known collection of versions")
          .build();

      MethodSpec getDefault = MethodSpec.methodBuilder("getDefault")
          .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
          .returns(Class.forName(getElementClass("ApiCatalog")))
          .addStatement("return instance")
          .build();

      MethodSpec getSupportedVersions = MethodSpec.methodBuilder("getSupportedVersions")
          .addModifiers(Modifier.PUBLIC)
          .returns(ParameterizedTypeName.get(
              SortedSet.class,
              Class.forName(getElementClass("Version"))))
          .addStatement("return supportedVersions")
          .build();

      MethodSpec getLatestVersion = MethodSpec.methodBuilder("getLatestVersion")
          .addModifiers(Modifier.PUBLIC)
          .returns(Class.forName(getElementClass("Version")))
          .addStatement("return getSupportedVersions().first()")
          .build();

      // Creates the createAllVersionsClient method.
      MethodSpec createAllVersionsClient = createAllVersionsClient(versions);

      // Creates the NoReflectionApiCatalog class.
      TypeSpec.Builder noReflectionApiCatalogBuilder = TypeSpec.classBuilder("NoReflectionApiCatalog")
          .addModifiers(Modifier.PUBLIC)
          .addSuperinterface(Class.forName(getElementClass("ApiCatalog")))
          .addField(instance)
          .addField(supportedVersions)
          .addMethod(constructor)
          .addMethod(getDefault)
          .addMethod(getSupportedVersions)
          .addMethod(getLatestVersion)
          .addMethod(createAllVersionsClient);

      // Creates a version class for each version.
      for (Integer version : versions) {
        noReflectionApiCatalogBuilder.addType(createClient(version));
      }

      TypeSpec noReflectionApiCatalog = noReflectionApiCatalogBuilder.build();

      // Writes the file.
      // JavaFile.builder(packageName, noReflectionApiCatalog).build().writeTo(filer);
      JavaFile.builder("com.google.ads.googleads.lib.catalog", noReflectionApiCatalog).build().writeTo(filer);

    } catch (IOException ioe) {
      messager.printMessage(Diagnostic.Kind.ERROR, "Failed to create file: " + ioe);
      return;
    } catch (ClassNotFoundException cnfe) {
      messager.printMessage(Diagnostic.Kind.ERROR, "Failed to create class: " + cnfe);
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
        .addSuperinterface(ParameterizedTypeName.get(
            Class.forName(getElementClass("GoogleAdsAllVersions"))));

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
        .returns(Class.forName(getElementClass("GoogleAdsAllVersions")))
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
