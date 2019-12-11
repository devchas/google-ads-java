package com.google.ads.googleads.processor.factory.processor;

import com.google.ads.googleads.annotations.ReqClassFactory;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

public class AnnotatedClass {

  private TypeElement annotatedClassElement;
  private String qualifiedGroupClassName;
  private String simpleFactoryGroupName;
  private String id;
  private Class classType;

  public AnnotatedClass(TypeElement classElement) {
    this.annotatedClassElement = classElement;
    ReqClassFactory annotation = classElement.getAnnotation(ReqClassFactory.class);
    id = annotation.id();
    classType = classElement.getClass();

    // Get the full QualifiedTypeName
    try {
      Class<?> clazz = annotation.type();
      qualifiedGroupClassName = clazz.getCanonicalName();
      simpleFactoryGroupName = clazz.getSimpleName();
    } catch (MirroredTypeException mte) {
      DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
      TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
      qualifiedGroupClassName = classTypeElement.getQualifiedName().toString();
      simpleFactoryGroupName = classTypeElement.getSimpleName().toString();
  }
}

  /**
   * Get the id as specified in {@link ReqClassFactory#id()}.
   * return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Get the full qualified name of the type specified in  {@link ReqClassFactory#type()}.
   *
   * @return qualified name
   */
  public String getQualifiedFactoryGroupName() {
    return qualifiedGroupClassName;
  }

  /**
   * Get the simple name of the type specified in  {@link ReqClassFactory#type()}.
   *
   * @return qualified name
   */
  public String getSimpleFactoryGroupName() {
    return simpleFactoryGroupName;
  }

  /**
   * The original element that was annotated with @Factory
   */
  public TypeElement getTypeElement() {
    return annotatedClassElement;
  }

  public Class getElemClass() { return classType; }
}
