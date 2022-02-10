package Homework2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    public void findWordsWithA(String text) {
        Pattern pattern = Pattern.compile("\\b([аА]\\S*[аА]|[аА]/?)\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start, end));
        }
    }

    public static void main(String[] args) {
        final String text = "Роман, а, Антон, Анна, астана.";
        Task7 task7 = new Task7();
        task7.findWordsWithA(text);
    }
}

