package com.techzealot.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

@Slf4j
public class LogTest implements Serializable {

    private static final long serialVersionUID = -1278594161882645671L;

    @Test
    public void testLogError(){
        log.error("test {}","hello",new RuntimeException("test"));
        log.info("test {}","info",new RuntimeException("test"));
    }
}
