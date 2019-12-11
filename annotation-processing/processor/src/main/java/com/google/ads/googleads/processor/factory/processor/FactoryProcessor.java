package com.google.ads.googleads.processor.factory.processor;

import com.google.ads.googleads.annotations.ServiceClientDescriptor;
import com.google.ads.googleads.annotations.VersionDescriptorFactory;
import com.google.auto.service.AutoService;
import com.google.ads.googleads.annotations.ReqClassFactory;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class FactoryProcessor extends AbstractProcessor {

  private Types typeUtils;
  private Elements elementUtils;
  private Filer filer;
  private Messager messager;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    typeUtils = processingEnv.getTypeUtils();
    elementUtils = processingEnv.getElementUtils();
    filer = processingEnv.getFiler();
    messager = processingEnv.getMessager();
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    Set<String> annotations = new LinkedHashSet<String>();
    annotations.add(ReqClassFactory.class.getCanonicalName());
    annotations.add(ServiceClientDescriptor.class.getCanonicalName());
    annotations.add(VersionDescriptorFactory.class.getCanonicalName());
    return annotations;
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    try {
      FactoryCollector factoryCollector = new FactoryCollector(messager);
      for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(ReqClassFactory.class)) {
        TypeElement typeElement = (TypeElement) annotatedElement;
        AnnotatedClass annotatedClass = new AnnotatedClass(typeElement);
        factoryCollector.addClassElement(annotatedClass);
      }
      factoryCollector.generateCode(filer);

      // TO DO:
      // for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(ServiceClientDescriptor.class)) {
      //
      // }
      //
      // for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(VersionDescriptorFactory.class)) {
      //
      // }
    } catch (IOException ioe) {
      error(null, ioe.getMessage());
    }

    return false;
  }

  // TO DO
  private void checkValidClass() {

  }

  public void error(Element e, String msg) {
    messager.printMessage(Diagnostic.Kind.ERROR, msg, e);
  }
}
