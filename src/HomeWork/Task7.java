package HomeWork;

public class Task7 {
    public static void main(String[] args) {
        int arrayLength = 6;
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
        int result1 = 0;
        int result2 = 0;
        int evenNumber;
        int unevenNumber;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                evenNumber = array[i];
                result1 = result1 + evenNumber;
            }
            else {
                unevenNumber = array[i];
                result2 = result2 + unevenNumber;
            }
        }
        System.out.println("Result is: " + (result1 + result2));
    }
}

