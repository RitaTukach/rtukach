package HomeWork;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 10, 20, 500, 1000};
        int n = 500;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
           if (array[i] == n) {
               continue;
           }
            result = result + array[i];
        }
        System.out.println(result);
    }
}
