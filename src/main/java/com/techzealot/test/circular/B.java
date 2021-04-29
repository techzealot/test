package com.techzealot.test.circular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class B {

    @Autowired
    //@Lazy
    private C c;

    @Async
    public void test(){

    }
}
