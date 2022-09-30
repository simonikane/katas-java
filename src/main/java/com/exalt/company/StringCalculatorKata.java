package com.exalt.company;

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
        if (numbers.startsWith("//")) {
            parsedString = numbers.substring(numbers.indexOf("\\n") + 2).split(delimiter);
        } else {
            parsedString = numbers.split(delimiter);
        }
        try {
            for (String s : parsedString) {
                if (Integer.parseInt(s) < 0) {
                    throw new NegativeNotAllowedInAddMethodException("Negatives not allowed");
                } else {
                    result += Integer.parseInt(s);
                }
            }
        } catch (NumberFormatException | NegativeNotAllowedInAddMethodException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
