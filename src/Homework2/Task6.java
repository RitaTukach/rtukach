package Homework2;

public class Task6 {

    public static String max(String text) {
        String[] words = text.split("\\W{1,}");
        String resultString = "";
            for (String word : words) {
                if (word.length() > resultString.length())
                    resultString = word;
            }
            return resultString;
    }

    static public void main(String args[]) {
        String someString = "one two three four five";
        String maxWord = max(someString);
        System.out.println("The max word in string is: " + maxWord);
    }
}
