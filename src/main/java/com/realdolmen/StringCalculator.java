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
        if (expression.equals("") ){
            return 0;
        }
        String [] numbers = expression.split(",");
        ArrayList<Integer> sepnum = new ArrayList<>();
        int result=0;
        for (String n : numbers){
            sepnum.add(Integer.parseInt(n));
        }
        for (int number : sepnum){
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
