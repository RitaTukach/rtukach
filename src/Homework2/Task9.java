package Homework2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task9 {
    public void printIndex(String text, String word) {
        Pattern pattern = Pattern.compile(("\\b" + word + "\\b"), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            int start = matcher.start();
            System.out.println(String.format("The index number of the first letter of \"%s\" in String is: %d", word, start));
        } else {
            System.out.println("There is no such word");
        }
    }
    public static void main(String[] args) {
        String word = "my";
        String text = "My word is";
        Task9 task9 = new Task9();
        task9.printIndex(text, word);
    }
}
