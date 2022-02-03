package HomeWork;

import java.util.ArrayList;

public class Task8 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
        int[] pay = new int[array.length];
        int sum = 0;
        pay[0] = 1;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] < array[i]) {
                    pay[i] = pay[i - 1] + 1;
                } else {
                    pay[i] = 1;
                }
            }
            for (int i = array.length - 1; i > 0; i--) {
                if (array[i - 1] > array[i] && pay[i - 1] <= pay[i]) {
                    pay[i - 1] = pay[i] + 1;
                }
            }
            for (int i = 0; i < pay.length; i++) {
            sum += pay[i];
            }
            System.out.println("Minimum payment sum is: " + sum);
    }
}
