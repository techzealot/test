package com.techzealot.test.classloader;

public class TestB {

    public void hello() {
        System.out.println("TestB: " + this.getClass().getClassLoader());
    }
}