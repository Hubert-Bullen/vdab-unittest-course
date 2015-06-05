package com.realdolmen;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Hyuberuto on 05/06/15.
 */
public class FractionTest {

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
    public void testDoesSimplifyWork(){
        Fraction test2 = new Fraction(4,8);
        test2.simplify();
        assertEquals(1,test2.getNumerator());
        assertEquals(2, test2.getDenominator());
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
}
