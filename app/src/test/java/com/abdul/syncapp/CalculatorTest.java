package com.abdul.syncapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        int actual = Calculator.add(10,20);
        int expected = 40;
        assertEquals(expected,actual);
    }
}