package com.company;
import java.util.InputMismatchException;

public class RomanToNumber extends Main {

    public static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            } else {
                throw new InputMismatchException();
            }

        } catch (InputMismatchException e) {
            System.out.println("Неверный формат данных");
            System.exit(0);
        }
        return -1;
    }

}
