package com.exalt.companytests;

import com.exalt.company.StringCalculatorKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorKataTest {
    @Test
    void addPositiveInteger(){
        String StringToAdd = "2";
        StringCalculatorKata StringCalculatorKata = new StringCalculatorKata();

        int sum = StringCalculatorKata.add(StringToAdd);

        assertEquals(2,sum);
    }

    @Test
    void addTwoPositiveIntegers(){
        String StringToAdd = "2,3";
        StringCalculatorKata StringCalculatorKata = new StringCalculatorKata();

        int sum = StringCalculatorKata.add(StringToAdd);

        assertEquals(5,sum);
    }

    @Test
    void addNullString(){
        String StringToAdd = " ";
        StringCalculatorKata StringCalculatorKata = new StringCalculatorKata();

        int sum = StringCalculatorKata.add(StringToAdd);

        assertEquals(0,sum);
    }

    @Test
    void addEmptyString(){
        String StringToAdd = "";
        StringCalculatorKata StringCalculatorKata = new StringCalculatorKata();

        int sum = StringCalculatorKata.add(StringToAdd);

        assertEquals(0,sum);
    }
}
