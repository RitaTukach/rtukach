package Homework2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    public void checkCardPattern(String cardPattern){
    Pattern pattern = Pattern.compile(cardPattern);
    String text = "My credit card number is 8444-4444-4444-44484";
    Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
        System.out.println("Credit card number found is: " + matcher.group(0));
    } else{
        System.out.println("Pattern does not match");
    }
}
    public static void main(String[] args) {
        String cardPattern = "(((\\d{4}[-]){3}\\d{4}(?![\\d])))";
        Task8 task8 = new Task8();
        task8.checkCardPattern(cardPattern);
    }
}
