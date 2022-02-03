package HomeWork;

public class Task6 {
    public static void main(String[] args) {
        int rows = 3;
        int[][] matrix1 = new int[rows][rows];
        int[][] matrix2 = new int[rows][rows];
        for (int i = 0; i <= (rows - 1); i++) {
            for (int j = 0; j <= (rows - 1); j++) {
                matrix1[j][i] = (int) (Math.random() * 10);
                matrix2[j][i] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Square Matrix #1:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Square Matrix #2:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("The sum of the given matrices is:");
        int[][] sumResult = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                sumResult[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(sumResult[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("The subtraction of the given matrices is:");
        int[][] SubtractionResult = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                SubtractionResult[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print(SubtractionResult[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

