package com.epam;

import java.lang.reflect.Method;

@FunctionalInterface
interface ProxyLogic {

    Object execute(Object proxy, Method method, Object[] args) throws Throwable;

}
