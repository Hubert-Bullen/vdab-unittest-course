package com.realdolmen;

import java.util.ArrayList;

/**
 * Created by Hyuberuto on 08/06/15.
 */
public class StringCalculator {
    private String expression;

    public StringCalculator(String expression) {
        this.expression = expression;
    }

    public int add(){
        ArrayList<Integer> sepnum = new ArrayList<>();
        int result = 0;
        if (expression.equals("") ){
            return 0;
        }

        String[] numbers = expression.split("\n|,"); //replaceAll werkte niet omdat je hem ook nog aan zichzelf meot toewijzen aka expression = expression.replaceAll()nlanl)
        for (String n : numbers) {
            sepnum.add(Integer.parseInt(n));
        }
        for (int number : sepnum) {
                result += number;
        }
        return result;

    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
 // mvn cobertura:cobertura Dan bij target -> site -> right click index open in browser