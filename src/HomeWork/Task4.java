package HomeWork;

public class Task4 {
    public static void main(String[] args) {
        int [][] twoDimArray = {{-5,-7,-3,17}, {7,0,1,-12}, {8,0,2,3}};
        int positiveNumberCounter = 0;
        int negativeNumberCounter = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                if (twoDimArray[i][j] == 0){
                    continue;
                }
                if (twoDimArray[i][j] > 0){
                    positiveNumberCounter++;
                } else {
                    negativeNumberCounter++;
                }
            }
        }
        if (positiveNumberCounter > negativeNumberCounter) {
            System.out.println("The amount of positive numbers is bigger");
        }
        else if (positiveNumberCounter < negativeNumberCounter) {
            System.out.println("The amount of negative numbers is bigger");
        }
        else if (positiveNumberCounter == negativeNumberCounter) {
            System.out.println("The amount of positive and negative numbers is equal");
        } else {
            System.out.println("The amount of positive and negative numbers cannot be defined");
        }
    }
}
