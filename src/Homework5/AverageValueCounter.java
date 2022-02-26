package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageValueCounter {

    public static void main(String[] args) {

        double sum = 0;
        int counter = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while (true) {
        try {
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line.trim().equalsIgnoreCase("STOP")) {
                System.out.println(sum / counter);
                break;
            }
            int number = Integer.parseInt(line);
            sum = sum + number;
            counter++;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        }
    }
}
