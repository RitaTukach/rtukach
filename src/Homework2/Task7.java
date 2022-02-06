package Homework2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    public boolean findWordsWithA(String text) {
        String[] words = text.split(" ");
        Pattern pattern = Pattern.compile("(^[а].*[а]$)");
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String text = "Антон аннаконда текст какой-то";
        Task7 task7 = new Task7();
        System.out.println(task7.findWordsWithA(text));
    }
}
