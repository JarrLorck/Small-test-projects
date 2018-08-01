package com.jc;

import java.util.Arrays;

public enum AnotherTest {
    INSTANCE;

    AnotherTest() {
        System.err.println("Another test was constructed at " + System.nanoTime());
    }

    private final String[] anything = new String[] {"any1", "any2", "any3"};
    public void printAnything() {
        System.err.println(Arrays.toString(anything));
    }

}
