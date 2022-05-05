package com.epam;

public interface Config {
  <T> Class<? extends T> getImplClass(Class<T> ifc);
}
