package HomeWork;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {0, 1, 1, 2, 3, 5, 8, 13, 21};
        int n = 7;
        int counter = 0;
        int sum = 0;
        while (counter < n) {
            if (array[counter] % 2 == 0) {
                sum = sum + array[counter];
            }
            counter++;
        }
            System.out.println(sum);
    }
}