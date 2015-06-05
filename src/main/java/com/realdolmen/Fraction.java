package com.realdolmen;

/**
 * Created by Hyuberuto on 04/06/15.
 */
public class Fraction {
    private int numerator; // Teller
    private int denominator; // Noemer

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public void simplify(){
        double gcf = Utilities.greatestCommonFactor(numerator,denominator);
        numerator /= gcf;
        denominator /= gcf;

    }

    public double asDouble(){
        return numerator/(double)denominator;
    }

    public boolean equalsFraction(Fraction f){
        if (this.asDouble() == f.asDouble()){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean equals(Object o){
        Fraction f = (Fraction) o;
        if (this.asDouble() == f.asDouble()){
            return true;
        }
        else{
            return false;
        }

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" +  denominator;
    }
}
