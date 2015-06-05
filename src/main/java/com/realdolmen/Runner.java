package com.realdolmen;

/**
 * Created by Hyuberuto on 04/06/15.
 */
public class Runner {
    public static void main(String[] args) {
        Fraction test = new Fraction(1,2);
        Fraction test2 = new Fraction(220,480);
        System.out.println(test.equals(test2));

        System.out.println(test.asDouble());

        System.out.println(test2.getNumerator());
        System.out.println(test2.getDenominator());

        System.out.println(test.add(test2));
        System.out.println(test.subtract(test2));
        System.out.println(test.multiply(test2));
        System.out.println(test.divide(test2));

        Fraction test3 = new Fraction(1,5);
        System.out.println(test.subtract(test3));
    }
}
