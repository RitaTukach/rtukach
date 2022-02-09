package Homework2;

import java.util.ArrayList;
import java.util.Collections;

public class StoreAndCountFiveNumbers {
    public static void main(String[] args) {
        StoreAndCountFiveNumbers storeAndCountFiveNumbers = new StoreAndCountFiveNumbers();
        storeAndCountFiveNumbers.storeNumbers(1);
        storeAndCountFiveNumbers.storeNumbers(2);
        storeAndCountFiveNumbers.storeNumbers(3);
        storeAndCountFiveNumbers.storeNumbers(4);
        System.out.println(storeAndCountFiveNumbers.countAverageSum());
    }

    private ArrayList<Integer> array = new ArrayList<>();
    public final int numberOfStoredDigits = 5;

    public void storeNumbers(int number) {
        array.add(number);
    }

    public int countAverageSum() {
        int sum =  0;
        int result;
        if (array.size() > numberOfStoredDigits) {
            Collections.reverse(array);
            for (int i = 0; i < numberOfStoredDigits; i++) {
                sum += array.get(i);
            }
        } else {
            for (int value: array) {
                sum += value;
            }
        }
        if (array.size() >= numberOfStoredDigits) {
            result = sum / numberOfStoredDigits;
        } else {
            result = sum / array.size();
        }
        return result;
    }
}
