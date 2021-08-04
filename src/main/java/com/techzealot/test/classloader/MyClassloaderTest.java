package com.techzealot.test.classloader;

import java.lang.reflect.Method;

public class MyClassloaderTest {
    public static void main(String[] args) throws Exception {
        //这里取AppClassLoader的父加载器也就是ExtClassLoader作为MyClassLoaderCustom的jdkClassLoader
        MyClassLoaderCustom myClassLoaderCustom = new MyClassLoaderCustom(Thread.currentThread().getContextClassLoader().getParent());
        Class testAClass = myClassLoaderCustom.loadClass("com.techzealot.test.classloader.TestA");
        Method mainMethod = testAClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, new Object[]{args});
        //AppClassLoader
        TestA.main(null);
    }
}
