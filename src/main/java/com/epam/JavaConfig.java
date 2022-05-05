package com.epam;

import java.util.Set;
import java.util.Map;

import org.reflections.Reflections;

public class JavaConfig implements Config {
  private Reflections scanner;
  private Map<Class, Class> ifc2ImplClass;

  public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass) {
    this.ifc2ImplClass = ifc2ImplClass;
    this.scanner = new Reflections(packageToScan);
  }

  @Override
  public <T> Class<? extends T> getImplClass(Class<T> ifc) {
    return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
      Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
      if (classes.size() != 1) {
        throw new RuntimeException(ifc + " has 0 or more than one impl, update config");
      }
      return classes.iterator().next();
    });
  }
}
