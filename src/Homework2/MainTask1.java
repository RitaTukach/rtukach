package Homework2;
import static Homework2.Months.getMonthByNumber;
import static Homework2.Months.getNumberByName;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.println("The month is: " + getMonthByNumber(4));
        System.out.println("The number is: " +getNumberByName("August"));
    }
}
