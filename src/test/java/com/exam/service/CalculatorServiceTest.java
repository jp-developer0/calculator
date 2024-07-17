package com.exam.service;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
public class CalculatorServiceTest {

    CalculatorService calculatorService;

    @Before
    public void setUp(){
        calculatorService = new CalculatorServiceImpl();
    }
    @Test
    public void testGetRootSquare() {
        Double[] inputData = new Double[]{5.0,4.0,6.0,1.0};
        assertEquals(Double.valueOf(8.77),calculatorService.getRootSquare(inputData));
    }
    @Test
    public void testGetRootSquare_NullInput() {
        assertNull(calculatorService.getRootSquare(null));
    }
    @Test
    public void testGetRootSquare_EmptyInput() {
        assertEquals(Double.valueOf(0.0),calculatorService.getRootSquare(new Double[]{}));
    }
}
