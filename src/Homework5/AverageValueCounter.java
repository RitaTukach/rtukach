package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageValueCounter {

    public static void main(String[] args) throws IOException {

        double sum = 0;
        int counter = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
        try {
            if (line.trim().equalsIgnoreCase("STOP")) {
                System.out.println(sum / counter);
                break;
            }
            int number = Integer.parseInt(line);
            sum = sum + number;
            counter++;
        } catch (NumberFormatException | ArithmeticException e) {
            e.printStackTrace();
            System.out.println(sum / counter);
        }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
