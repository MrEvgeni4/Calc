package com.company;
import java.util.InputMismatchException;


public class Calculated extends Main {

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("На ноль делить нельзя!");
                    System.exit(0);
                }
                break;
        }
         return result;
    }

}
