package com.epam;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author Evgeny Borisov
 * @author Моряк
 */
public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> T replaceWithProxyIfNeeded(T t, Class<T> implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            return proxyWithLogic(implClass, (proxy, method, args) -> {
                System.out.println("Наташ, не трогай этот " + implClass.getSimpleName() + ", он плохой!");
                return method.invoke(t, args);
            });
        }
        Set<String> deprecatedMethods = Arrays.stream(implClass.getMethods())
                .filter(m -> m.isAnnotationPresent(Deprecated.class))
                .map(Method::getName)
                .collect(toSet());
        if (deprecatedMethods.isEmpty()) {
            return t;
        }
        return proxyWithLogic(implClass, (proxy, method, args) -> {
            if (deprecatedMethods.contains(method.getName())) {
                System.out.println("Наташ, ну хватит! Этот метод " + method.getName() + " в " + implClass + " уже не тот!");
            }
            return method.invoke(t, args);
        });
    }
}
