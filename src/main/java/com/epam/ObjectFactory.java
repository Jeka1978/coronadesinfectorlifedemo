package com.epam;

import java.util.HashMap;
import java.util.Map;

import lombok.SneakyThrows;

public class ObjectFactory {
  public static ObjectFactory getInstance() { return ourInstance; }

  private static ObjectFactory ourInstance = new ObjectFactory();
  private ObjectFactory() {
    config = new JavaConfig("com.epam", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
  }
  private Config config;


  @SneakyThrows
  public <T> T createObject(Class<T> type) {
    Class<? extends T> implClass = type;
    if (type.isInterface()) {
      implClass = config.getImplClass(type);
    }
    T t = implClass.getDeclaredConstructor().newInstance();
    return t;
  }
}
