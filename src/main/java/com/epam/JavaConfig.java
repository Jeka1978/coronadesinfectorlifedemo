package com.epam;

import java.util.Set;

import org.reflections.Reflections;

public class JavaConfig implements Config {
  private Reflections scanner;

  public JavaConfig(String packageToScan) {
    this.scanner = new Reflections(packageToScan);
  }

  @Override
  public <T> Class<? extends T> getImplClass(Class<T> ifc) {
    Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
    if (classes.size() != 1) {
      throw new RuntimeException(ifc + "has 0 or more than one impl.");
    }
    return classes.iterator().next();
  }
}
