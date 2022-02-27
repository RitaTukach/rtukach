package Homework5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static Scanner scanner = new Scanner(System.in);
    public static int first, second;
    public static char sign;

    public static void main(String[] args) throws IOException, InputMismatchException {

    System.out.print("Please enter the first number: ");
    first = scanner.nextInt();

    System.out.print("Please enter the second number: ");
    second = scanner.nextInt();

    System.out.print("Please enter the sign: ");
    sign = (char) System.in.read();

    makeOperation(sign);
    }

    public static void makeOperation(char sign) {

        int result = 0;

        if (sign == '+') {
           result = plus(first, second);
        }
        else if (sign == '-') {
            result = minus(first, second);
        }
        else if (sign == '*') {
            result = multiply(first, second);
        }
        else if (sign == '/') {
            result = divide(first, second);
        }
        resultPrint(result);
    }

    public static int plus(int first, int second) {
        int sum;
        sum = first + second;
        return sum;
    }

    public static int minus(int first, int second) {
        return first - second;
    }

    public static int multiply(int first, int second) {
        return first * second;
    }

    public static int divide(int first, int second) throws ArithmeticException {
        return first / second;
    }

    public static void resultPrint(int result) {

        System.out.println(result);
    }
}

