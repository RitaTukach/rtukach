package Homework5;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MatricesFromFileMultiplier {

    public static String input = "";

    public static void main(String args[]) throws IOException, FileNotFoundException, NumberFormatException {

        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream("D://INPUT.txt"), StandardCharsets.UTF_8))) {
            while (true) {
                int byte_ = reader.read();
                if (byte_ == -1) {
                    break;
                }
                input += (char) byte_;
            }
        }catch (IOException e) {
                e.printStackTrace();
            }

        String lines[] = input.split("\\r?\\n");

        int size = 3;
        int[][] matrix1 = new int[size][size];
        int[][] matrix2 = new int[size][size];
        int[][] composition = new int[size][size];

        int i = 0;
        int j = 0;

        for (int s = 0; s < size; s++) {
            j = 0;

            String[] elements = lines[s].split(" ");
            for (String e : elements) {
                matrix1[i][j] = Integer.parseInt(e);
                System.out.print(matrix1[i][j] + "; ");
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println();

        i = 0;
        j = 0;

        for (int s = size + 1; s < size * 2 + 1; s++) {
            j = 0;
            String[] elements = lines[s].split(" ");
            for (String e : elements) {
                matrix2[i][j] = Integer.parseInt(e);
                System.out.print(matrix2[i][j] + "; ");
                j++;
            }
            System.out.println();
            i++;
        }

        composition = multiplyMatrix(matrix1, matrix2);
        System.out.println("Result:");
        for (i = 0; i < size; i++) {
            String str = "";

            for (j = 0; j < size; j++) {
                str += composition[i][j] + "; ";
            }
            System.out.println(str);
        }
    }

    public static int[][] multiplyMatrix(int[][] m1, int[][] m2) {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;
        if (m1ColLength != m2RowLength) {
            return null;
        }
        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        int[][] mResult = new int[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {
            for (int j = 0; j < mRColLength; j++) {
                for (int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}