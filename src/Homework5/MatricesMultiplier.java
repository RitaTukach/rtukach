package Homework5;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MatricesMultiplier {

    public static void main(String[] args) throws IOException, InputMismatchException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество строк первой матрицы");
        int n = scanner.nextInt();
        System.out.println("Количество столбцов в первой матрице и количество строк во второй матрице");
        int m = scanner.nextInt();
        System.out.println("Количество столбцов во второй матрице");
        int k = scanner.nextInt();

        int Maze[][] = new int[n][m];
        int Maze1[][] = new int[m][k];
        int Maze2[][] = new int[n][k];

        System.out.println("Значения матрицы 1");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Maze[i][j] = scanner.nextInt();

            }
        }

        System.out.println("Значения матрицы 2");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                Maze1[i][j] = scanner.nextInt();

            }
        }

        for (int i = 0; i < n; i++) {
            for (int u = 0; u < k; u++) {
                for (int j = 0; j < m; j++) {

                    Maze2[i][u] += Maze[i][j] * Maze1[j][u];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(Maze2[i][j] + " ");

            }
            System.out.println();
        }
    }
}