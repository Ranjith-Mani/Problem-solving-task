package HomeWorkDay3;

import java.util.Scanner;

public class TitleCaseConverter {

    public static String toTitleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Split the input string into words based on spaces
        String[] words = input.split("\\s+");
        StringBuilder titleCase = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Capitalize the first letter of each word and make the rest lowercase
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        // Trim the trailing space and return the result
        return titleCase.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to convert to title case:");
        String input = scanner.nextLine();

        String titleCaseString = toTitleCase(input);
        System.out.println("Title Case: " + titleCaseString);
    }
}
