package com.epam;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 * @author Моряк
 */
public interface ProxyConfigurator {
    <T> T replaceWithProxyIfNeeded(T t, Class<T> implClass);

    @SuppressWarnings("unchecked")
    default <T> T proxyWithLogic(Class<T> implClass, ProxyLogic proxyLogic) {
        return implClass.getInterfaces().length == 0
                ? (T) Enhancer.create(implClass, (InvocationHandler) proxyLogic::execute)
                : (T) Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), proxyLogic::execute);

    }
}
