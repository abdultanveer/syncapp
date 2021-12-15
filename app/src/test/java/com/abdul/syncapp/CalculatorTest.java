package com.abdul.syncapp;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import org.junit.Test;

public class CalculatorTest  {

    @Test
    public void testAdd() {
        int actual = Calculator.add(10,20);
        int expected = 40;
        assertEquals(expected,actual);
    }
}