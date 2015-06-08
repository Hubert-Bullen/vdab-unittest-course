package com.realdolmen;

import org.junit.*;
import org.junit.runners.Parameterized.*;

import static org.junit.Assert.*;

/**
 * Created by Hyuberuto on 05/06/15.
 */
public class FractionTest {
    // @Parameter (value = 0) Fraction test; TODO Parameters.

    @Test (expected = DenominatorIsZeroException.class)
    public void testZeroAsDenominatorThrowsException(){
        Fraction test = new Fraction(1,0);
    }

    @Test
    public void testDoesEqualsWork(){
        Fraction test = new Fraction(1,2);
        Fraction test2 = new Fraction(4,8);
        assertTrue(test.equals(test2));
    }

    @Test
    public void testDoesGetDenominatorAndNumeratorWork(){
        Fraction test = new Fraction(3,10);
        assertEquals(3,test.getNumerator());
        assertEquals(10,test.getDenominator());
    }

    @Test
    public void testDoesToStringWork(){
        Fraction test = new Fraction(89,100);
        assertEquals("89/100",test.toString());
    }

    @Test
    public void testDoesAutoSimplifyWork(){
        Fraction test2 = new Fraction(4,8);
        assertEquals(1,test2.getNumerator());
        assertEquals(2,test2.getDenominator());
    }

    @Test
    public void testDoesAsDoubleWorkForMoreDifficultNumbers(){
        Fraction test = new Fraction(10,3);
        assertEquals(3.333,test.asDouble(),0.001); // 0.01 is de "delta" en houd in tot hoeveel cijfers na de komma we willen vergelijken.
    }

    @Test
    public void testDoesEqualsWorkForMoreDifficultNumbers(){
        Fraction test = new Fraction(10,3);
        Fraction test2 = new Fraction(30,9);
        assertTrue(test.equals(test2));
    }

    @Test
    public void testDoesAddingPositiveFractionsWork(){
        Fraction test = new Fraction(1,2);
        Fraction test2 = new Fraction(220,480);
        Fraction expected = new Fraction (23,24);
        assertEquals(expected, test.add(test2));

    }

    @Test
    public void testDoesAddingNegativeFractionsWork(){
        Fraction test = new Fraction(-1,2);
        Fraction test2 = new Fraction(-220,480);
        Fraction expected = new Fraction (-23,24);
        assertEquals(expected, test.add(test2));
    }
    @Test
    public void testDoesSubtractingPositiveFractionsWork(){
        Fraction test = new Fraction(1,2);
        Fraction test2 = new Fraction(1,5);
        Fraction expected = new Fraction (3,10);
        assertEquals(expected, test.subtract(test2));
    }

    @Test
    public void testDoesSubtractingNegativeFractionsWork(){
        Fraction test = new Fraction(-1,2);
        Fraction test2 = new Fraction(-1,5);
        Fraction expected = new Fraction (-3,10);
        assertEquals(expected, test.subtract(test2));
    }

    @Test
    public void testDoesMultiplyingPositiveFractionsWork(){
        Fraction test = new Fraction(1,2);
        Fraction test2 = new Fraction(220,480);
        Fraction expected = new Fraction (11,48);
        assertEquals(expected, test.multiply(test2));
    }

    @Test
    public void testDoesMultiplyingNegativeFractionsWork(){
        Fraction test = new Fraction(-1,2);
        Fraction test2 = new Fraction(-220,480);
        Fraction expected = new Fraction (11,48);
        assertEquals(expected, test.multiply(test2));
    }

    @Test
    public void testDoesMultiplyingNegativeAndPositiveFractionsWork(){
        Fraction test = new Fraction(-1,2);
        Fraction test2 = new Fraction(220,480);
        Fraction expected = new Fraction (-11,48);
        assertEquals(expected, test.multiply(test2));
    }

    @Test
    public void testDoesDividingPositiveFractionsWork(){
        Fraction test = new Fraction(1,2);
        Fraction test2 = new Fraction(220,480);
        Fraction expected = new Fraction (12,11);
        assertEquals(expected, test.divide(test2));
    }

     @Test
    public void testDoesDividingNegativeFractionsWork(){
        Fraction test = new Fraction(-1,2);
        Fraction test2 = new Fraction(-220,480);
        Fraction expected = new Fraction (12,11);
        assertEquals(expected, test.divide(test2));
    }

     @Test
    public void testDoesDividingPositiveAndNegativeFractionsWork(){
        Fraction test = new Fraction(-1,2);
        Fraction test2 = new Fraction(220,480);
        Fraction expected = new Fraction (-12,11);
        assertEquals(expected, test.divide(test2));
    }





}
