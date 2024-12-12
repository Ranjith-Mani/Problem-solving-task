package Day3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingCharacter(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count the frequency of each character in the string
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with a frequency of 1
        for (char c : str.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c;
            }
        }

        // Return a placeholder if no non-repeating character is found
        return '\0';  // '\0' indicates no non-repeating character found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingCharacter(input);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}

