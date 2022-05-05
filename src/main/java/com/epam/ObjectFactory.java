package com.epam;

import lombok.SneakyThrows;

public class ObjectFactory {
  public static ObjectFactory getInstance() { return ourInstance; }

  private static ObjectFactory ourInstance = new ObjectFactory();
  private ObjectFactory() { }
  private Config config = new JavaConfig("com.epam");

  @SneakyThrows
  public <T> T createObject(Class<T> type) {
    Class<? extends T> implClass = type;
    if (type.isInterface()) {
      implClass = config.getImplClass(type);
    }
    return implClass.getDeclaredConstructor().newInstance();
  }
}
