package HomeWork;

public class Task5 {
    public static void main(String[] args) {
        int rowsAndColumns = 4;
        int startingNumber = 1;
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];
        for (int i = 0; i <= (rowsAndColumns - 1); i++) {
            for (int j = i; j <= (rowsAndColumns - 1); j++) {
                matrix[j][i] = startingNumber;
                startingNumber++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        boolean flag = false;
        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = i + 1; j < rowsAndColumns; j++) {
                if (matrix[i][j] == 0) {
                    flag = true;
                } else {
                    flag = false;
                }
                if (flag == false) {
                    System.out.println("Matrix is not a Lower Triangle");
                    return;
                }
            }
        }
        if (flag == true) {
            System.out.println("Matrix is a Lower Triangle");
        }
    }
}




