package HomeworkDay4;

import java.util.Scanner;

public class StringPermutations {

    // Recursive method to generate permutations
    public static void generatePermutations(String str, String result) {
        // Base case: if the input string is empty, print the result
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }

        // Recursively generate permutations
        for (int i = 0; i < str.length(); i++) {
            // Choose the current character
            char currentChar = str.charAt(i);

            // Create a new string by excluding the chosen character
            String remainingString = str.substring(0, i) + str.substring(i + 1);

            // Recursive call with the chosen character added to the result
            generatePermutations(remainingString, result + currentChar);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input string from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Generate and print all permutations
        System.out.println("Permutations of the string:");
        generatePermutations(input, "");
    }
}

