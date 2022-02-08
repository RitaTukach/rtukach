package Homework2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    public void findWordsWithA(String text) {
        String[] words = text.split(" ");
        Pattern pattern = Pattern.compile("\\b(^[аА].*[аА](?=\\W|$)\\b)");
        String result = "No result";
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            while (matcher.find()) {
                result = word;
                System.out.println(word);
            }
        }
    }
    public static void main(String[] args) {
        String text = "Антон анна текст какой-то анапа.";
        Task7 task7 = new Task7();
        task7.findWordsWithA(text);
    }
}