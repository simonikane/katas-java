package com.exalt.companytests;

import com.exalt.company.StringCalculatorKata;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorKataTest {

    private StringCalculatorKata StringCalculatorKata;
    private static Instant timerStartExecution;

    @BeforeAll
    public static void startingTimer(){
        timerStartExecution=Instant.now();
    }

    @AfterAll
    public static void endingTimer(){
        Instant timerStopExecution = Instant.now();
        System.out.println("Duration of tests : " + Duration.between(timerStartExecution,timerStopExecution).toMillis() + "ms");
    }

    @BeforeEach
    public void initStringCalculator(){
        StringCalculatorKata = new StringCalculatorKata();
    }

    @AfterEach
    public void undefStringCalculator(){
        StringCalculatorKata = null;
    }
    @ParameterizedTest (name = "{0} should return {1}")
    @CsvSource( value = {"3:3" , "1,2:3" , "1,2,3,1:7"},  delimiter = ':')
    void addPositiveIntegers(String StringToAdd, int expectedValue){
        int sum = StringCalculatorKata.add(StringToAdd);
        assertEquals(expectedValue,sum);
    }

    @ParameterizedTest (name = "{0} should return 0")
    @ValueSource (strings = {"", " "})
    void addNullString_EmptyString(String StringToAdd){
        int sum = StringCalculatorKata.add(StringToAdd);
        assertEquals(0,sum);
    }

    @ParameterizedTest (name = "{0} should return {1}")
    @CsvSource( value = {"3,8,9,4,6:30" , "1,3,5,7,9,2,4:31" , "1,2,3,4,5,1,2,3,4,5,9,8:47"},  delimiter = ':')
    void addSeveralPositiveIntegers_Five_Seven_Twelve(String StringToAdd,  int expectedValue) {
        int sum = StringCalculatorKata.add(StringToAdd);
        assertEquals(expectedValue,sum);
    }

    @ParameterizedTest (name = "{0} should return {1}")
    @CsvSource( value = {"1\\n2,3:6", "3\\n8,9\\n4,6:30"},  delimiter = ':')
    void addSeveralPositiveIntegers_NewLine(String StringToAdd,  int expectedValue) {
        int sum = StringCalculatorKata.add(StringToAdd);
        assertEquals(expectedValue,sum);
    }

    @ParameterizedTest (name = "{0} should return 3")
    @ValueSource(strings = {"//;\\n1;2"})
    void addSeveralPositiveIntegers_DefinedDelimiter(String StringToAdd) {
        int sum = StringCalculatorKata.add(StringToAdd);
        assertEquals(3, sum);
    }
}
