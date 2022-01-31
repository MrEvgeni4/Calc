package com.company;
import java.util.Scanner;

    public class Main {
        static Scanner scanner = new Scanner(System.in);
        static int number1, number2;
        static char operation;
        static int result;

        public static void main(String[] args) throws Exception {
            Calculated x = new Calculated();
            RomanToNumber r = new RomanToNumber();
            ConvertNumToRoman c = new ConvertNumToRoman();

            System.out.println("Введите выражение из двух арабских или римских чисел + Enter: ");
//  Считываем строку userInput которую ввёл пользователь
            String userInput = scanner.nextLine();
//  Создаём пустой символьный массив длиной 10 символов: under_char
            char[] under_char = new char[10];
            int operation_count = 0;
//  Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
            for (int i = 0; i < userInput.length(); i++) {
                under_char[i] = userInput.charAt(i);
                if (under_char[i] == '+') {
                    operation = '+';
                    operation_count++;
                }
                if (under_char[i] == '-') {
                    operation = '-';
                    operation_count++;
                }
                if (under_char[i] == '*') {
                    operation = '*';
                    operation_count++;
                }
                if (under_char[i] == '/') {
                    operation = '/';
                    operation_count++;
                }
            }
            if (operation_count == 0) {
                throw new Exception("строка не является математической операцией");
            } else if (operation_count > 1) {
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else {
                String under_charString = String.valueOf(under_char);
                String[] part = under_charString.split("[+-/*]");
                String symbol00 = part[0];
                symbol00 = symbol00.trim();
                String symbol01 = part[1];
                symbol01 = symbol01.trim();
                Boolean flag = Character.isDigit(symbol00.charAt(0));
                Boolean flag2 = Character.isDigit(symbol01.charAt(0));
                if (!flag && !flag2) {
                    number1 = r.romanToNumber(symbol00);
                    number2 = r.romanToNumber(symbol01);
                    result = x.calculated(number1, number2, operation);
                        if (result < 0) {
                            throw new Exception("в римской системе нет отрицательных чисел");
                        } else {
                            System.out.println("### Результат для римских цифр ###");
                            String resultRoman = c.convertNumToRoman(result);
                            System.out.println(resultRoman);
                        }
                } else if (flag && flag2) {
                    number1 = Integer.parseInt(symbol00);
                    number2 = Integer.parseInt(symbol01);
                    result = x.calculated(number1, number2, operation);
                    System.out.println("### Результат для арабских цифр ###");
                    if ((number1 < 0 | number1 > 10) | (number2 < 0 | number2 > 10))
                        System.out.println("Цифры должны быть от 0 до 10");
                    else
                        System.out.println(result);
                } else {
                    throw new Exception("используются одновременно разные системы счисления");
                }

            }
        }

    }