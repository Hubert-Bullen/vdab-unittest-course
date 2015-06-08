package com.realdolmen;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Hyuberuto on 08/06/15.
 */
public class StringCalculatorTest {

    @Test
    public void testAddTwoNumbers(){
        StringCalculator calc = new StringCalculator("4,5");
        assertEquals(9, calc.add());

    }

    @Test
    public void testAddNoNumbers(){
        StringCalculator calc = new StringCalculator("");
        assertEquals(0,calc.add());

    }

    @Test
    public void testAdd1Number(){
        StringCalculator calc = new StringCalculator("7");
        assertEquals(7,calc.add());

    }


}
