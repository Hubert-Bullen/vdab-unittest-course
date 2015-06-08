package com.realdolmen;

/**
 * Created by Hyuberuto on 04/06/15.
 */
public class Fraction {
    private int numerator; // Teller
    private int denominator; // Noemer

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new DenominatorIsZeroException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(); // Word dit altijd gedaan en hebben we er vor de rest geen last van.
    }

    public Fraction add(Fraction that){
        /*int refactorNumThis = this.getNumerator() * that.getDenominator();
        int refactorNumThat = that.getNumerator() * this.getDenominator();
        int addedNumer = refactorNumThat + refactorNumThis;
        int addedDenom = this.getDenominator() * that.getDenominator();*/
        Fraction result = new Fraction((this.getNumerator() * that.getDenominator()) + (that.getNumerator() * this.getDenominator()), this.getDenominator() * that.getDenominator());
        return result;
    }

    public Fraction subtract(Fraction that){
        Fraction negativeThat = new Fraction (- that.getNumerator(),that.getDenominator());
        return this.add(negativeThat);
    }

    public Fraction multiply(Fraction that){
        /*int multNumer = this.getNumerator() * that.getNumerator();
        int multDenom = this.getDenominator() * that.getDenominator();*/
        Fraction result = new Fraction(this.getNumerator() * that.getNumerator(),this.getDenominator() * that.getDenominator());
        return result;
    }

    public Fraction divide(Fraction that){
        Fraction thatrep = that.reciprocal();
        return this.multiply(thatrep);
    }


    private void simplify(){
        double gcf = Utilities.greatestCommonFactor(numerator,denominator);
        this.numerator /= gcf;
        this.denominator /= gcf;

    }

    public Fraction reciprocal(){
        Fraction repthis = new Fraction(this.getDenominator(),this.getNumerator());
        return repthis;
    }

    public double asDouble(){
        return numerator/(double)denominator;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Fraction)) return false;
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
