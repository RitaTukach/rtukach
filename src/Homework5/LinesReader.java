package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinesReader {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(line);
    }
}
