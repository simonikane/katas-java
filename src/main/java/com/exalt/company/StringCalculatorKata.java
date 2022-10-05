package com.exalt.company;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorKata {

    public String delimiterForAdd(String numbers) {
        String delimiter = "\\\\n";
        if (numbers.startsWith("//")) {
            delimiter = delimiter.concat("|").concat(numbers.substring(2, numbers.indexOf("\\n")));
        } else { // default delimiter being ','
            delimiter = delimiter.concat("|,");
        }
        return delimiter;
    }

    public int add(String numbers) {
        int result = 0;
        String delimiter = delimiterForAdd(numbers);
        String[] parsedString;
        List<Integer> negativeNumbers=new ArrayList<Integer>();
        if (numbers.startsWith("//")) {
            parsedString = numbers.substring(numbers.indexOf("\\n") + 2).split(delimiter);
        } else {
            parsedString = numbers.split(delimiter);
        }
        try{
            for (String s : parsedString) {
                if (Integer.parseInt(s) < 0) {
                    negativeNumbers.add(Integer.parseInt(s));
                } else {
                    result += Integer.parseInt(s);
                }
            }
            if (!negativeNumbers.isEmpty()) {
                throw new NegativeNotAllowedInAddMethodException("Negatives not allowed : " + negativeNumbers);
            }
        } catch (NumberFormatException | NegativeNotAllowedInAddMethodException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
