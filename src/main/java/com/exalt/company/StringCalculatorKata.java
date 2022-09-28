package com.exalt.company;

public class StringCalculatorKata {

    public int add(String numbers) {
        int result = 0;
        String[] parsedString = numbers.split(",");
        try{
            for (String s : parsedString) {
                result += Integer.parseInt(s);
            }
        }catch(NumberFormatException e){System.out.println("Not a number");}
        return result;
    }
}
