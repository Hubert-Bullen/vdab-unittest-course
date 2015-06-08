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
        if (expression.equals("") ){
            return 0;
        }
        if (expression.contains(",")){
            String [] numbers = expression.split(",");
            int result=0;
            for (String n : numbers){
                sepnum.add(Integer.parseInt(n));
            }
            for (int number : sepnum){
                result += number;
            }
            return result;
        }
        String [] numbers = expression.split("\n");
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
