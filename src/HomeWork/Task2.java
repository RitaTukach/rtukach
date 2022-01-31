package HomeWork;

public class Task2 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        int res = 0;
        for (int i = 2; i < n; ++i) {
            array[i] = array[i - 1] + array[i - 2];
            if (array[i] % 2 == 0) {
                res = array[i] + res;
            }
        }
        System.out.println(res);
    }
}
