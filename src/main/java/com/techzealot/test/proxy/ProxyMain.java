package com.techzealot.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.Arrays;

public class ProxyMain {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyApi proxyApi=new ProxyApiImpl();
        ProxyApi proxy = (ProxyApi) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), proxyApi.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(MessageFormat.format("target:{0},method:{1},args:{2}", Arrays.toString(proxy.getClass().getInterfaces()),method.getName(),args));
                System.out.println("before");
                Object result = method.invoke(proxyApi, args);
                System.out.println("after");
                return result;
            }
        });
        System.out.println(proxy.toString());
        System.out.println(proxy.hashCode());
        System.out.println(proxyApi.toString());
    }
}
