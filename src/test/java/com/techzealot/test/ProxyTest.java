package com.techzealot.test;

import com.techzealot.test.proxy.ProxyApi;
import com.techzealot.test.proxy.ProxyApiImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.Arrays;

public class ProxyTest {

    @Test
    public void testToString() {
        //必须使用main方法运行，否则不会生成代理类文件
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyApi proxyApi=new ProxyApiImpl();
        ProxyApi proxy = (ProxyApi) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), proxyApi.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //此方法内不能调用proxy中被代理的方法否则会产生无限递归，造成堆栈溢出
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
