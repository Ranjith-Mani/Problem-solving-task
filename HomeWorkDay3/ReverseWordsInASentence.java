package HomeWorkDay3;

import java.util.Scanner;

public class ReverseWordsInASentence {
    public static void main(String[] args) {

        // Implementing Scanner class to get input form the user
        Scanner input = new Scanner(System.in);

        // To create a sentence
        System.out.print("Enter the sentence : ");
        String sentence = input.nextLine();

        // To split sentence into words
        String[] words = sentence.split(" ");

        // Reverse order of words
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length-1; i >= 0 ; i--) {
            reversedSentence.append(words[i]);
            if (i > 0){
                reversedSentence.append(" ");
            }
        }
        // To print the result
        System.out.println("Your reversed sentence : " + reversedSentence.toString());
    }
}
