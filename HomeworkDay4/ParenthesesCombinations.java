package HomeworkDay4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParenthesesCombinations {

    // Function to generate all valid combinations of parentheses
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string's length is equal to 2 * max, it means we have a valid combination
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Try adding an open parenthesis if we haven't reached the maximum number of open parentheses
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Try adding a close parenthesis if there are more open parentheses than close ones
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        // Create a scanner to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of parentheses pairs
        System.out.print("Enter the number of parentheses pairs: ");
        int n = scanner.nextInt();

        // Generate the combinations of parentheses
        List<String> combinations = generateParentheses(n);

        // Print all the valid combinations
        System.out.println("Valid combinations of parentheses:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}

