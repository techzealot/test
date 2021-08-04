package com.techzealot.test;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationTest {

    @Test
    public void testDuration(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusDays(2L);
        LocalDateTime before = now.minusDays(2);
        Duration between = Duration.between(after, now);
        System.out.println(between.getSeconds());
    }
}
