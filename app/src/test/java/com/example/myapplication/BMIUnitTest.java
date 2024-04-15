package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;


public class BMIUnitTest {
    @Test
    public void calculateBMI() {
        assertEquals(29.530996, BMI.countBMI(110, 1.93f), 0.0001);
    }
}