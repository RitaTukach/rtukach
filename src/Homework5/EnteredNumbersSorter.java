package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnteredNumbersSorter {

    public static void main(String[] args) throws IOException {

        List<Integer> listOfNumbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            try {
                if (line.trim().equalsIgnoreCase("STOP")) {
                    break;
                } else if (line.trim().equalsIgnoreCase("STATUS")){
                    Collections.sort(listOfNumbers);
                    System.out.println(listOfNumbers);
                }
                int number = Integer.parseInt(line);
                listOfNumbers.add(number);
            } catch (NumberFormatException | ArithmeticException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
