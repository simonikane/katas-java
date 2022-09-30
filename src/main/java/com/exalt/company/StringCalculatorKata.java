package com.exalt.company;

public class StringCalculatorKata {

    public int add(String numbers) {
        int result = 0;
        String delimiter = "\\\\n";
        String[] parsedString;
        if (numbers.startsWith("//")) {
            delimiter = delimiter.concat("|").concat(String.valueOf(numbers.charAt(2)));
            parsedString = numbers.substring(5).split(delimiter);
        }else{
              delimiter = delimiter.concat("|,");
              parsedString = numbers.split(delimiter);
              System.out.println(delimiter);
        }

        for (String s : parsedString) {
            System.out.println(" Lou String ici : " + s);
        }
        try{
            for (String s : parsedString) {
                result += Integer.parseInt(s);
            }
        }catch(NumberFormatException e){
            System.out.println("Not a number ");
        }
            return result;
        }
    }
