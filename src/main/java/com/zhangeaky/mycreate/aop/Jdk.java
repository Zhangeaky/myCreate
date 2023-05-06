package com.zhangeaky.mycreate.aop;

import com.zhangeaky.mycreate.service.CommonService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Jdk {

    public static void main(String[] args) {
        Proxy.newProxyInstance(Jdk.class.getClassLoader(),
                new Class[]{CommonService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                });
    }
}
