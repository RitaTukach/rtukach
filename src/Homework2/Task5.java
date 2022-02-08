package Homework2;

public class Task5{

    static int countOccurrences(String str) {
        String words[] = str.split(" ");
        int countCharC = 0;
        int countWordsWithC = 0;
        char c = 'c';
        for (String word: words) {
            char charArray[] = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (word.charAt(i) == c) {
                    countCharC++;
                }
                    if (i == charArray.length - 1 && countCharC == 3) {
                        countWordsWithC++;
                    }
                    if (i == charArray.length - 1) {
                        countCharC = 0;
                    }
               }
            }
        return countWordsWithC;
    }
    public static void main(String args[])
    {
        String str = "One two three occurrence four five";
        System.out.println(countOccurrences(str));
    }
}
