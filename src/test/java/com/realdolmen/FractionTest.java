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
        Fraction test2 = new Fraction(4, 8);
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
}
