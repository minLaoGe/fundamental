package com.minfengyu.common;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyListNode implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin intercept");
        methodProxy.invokeSuper(o,objects);
        System.out.println("end intercept");
        return o;
    }
}
