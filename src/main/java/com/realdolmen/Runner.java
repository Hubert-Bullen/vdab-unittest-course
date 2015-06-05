package com.realdolmen;

/**
 * Created by Hyuberuto on 04/06/15.
 */
public class Runner {
    public static void main(String[] args) {
        /*System.out.println((Utilities.greatestCommonFactor(10,3)));*/

        Fraction test = new Fraction(1,2);
        Fraction test2 = new Fraction(4,8);
        System.out.println(test.equals(test2));

        System.out.println(test.asDouble());

        test2.simplify();
        System.out.println(test2.getNumerator());
        System.out.println(test2.getDenominator());

        /*System.out.println(test);
        System.out.println(test.getNumerator());
        System.out.println(test.getDenominator());

        System.out.println(Utilities.greatestCommonFactor(3,10));*/
    }
}
