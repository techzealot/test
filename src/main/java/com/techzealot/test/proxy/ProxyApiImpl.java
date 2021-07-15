package com.techzealot.test.proxy;

public class ProxyApiImpl implements ProxyApi {
    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public String toString() {
        return "ProxyApiImpl{}";
    }
}
