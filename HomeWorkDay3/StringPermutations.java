package HomeWorkDay3;

import java.util.Scanner;

public class StringPermutations {
    public static void main(String[] args) {

        // Implementing Scanner class to get input form the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the String which you want to permutate : ");
        String input = scanner.nextLine();

        System.out.println("All the permutations of string are : ");
        generatePermutations(input, " ");
    }

    private static void generatePermutations(String input, String space) {
        // Check if the string is empty
        if (input.isEmpty()){
            System.out.println(space);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            // Extract the character at position 'i'
            char currentChar = input.charAt(i);
            // Create a new string without the current character
            String remainingString = input.substring(0, i) + input.substring(i + 1);
            // Recursive call with the remaining string and updated permutation
            generatePermutations(remainingString, space + currentChar);
        }
    }
}
