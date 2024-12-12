package HomeworkDay5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortStringsByLength {

    public static void main(String[] args) {
        // Create a scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of strings
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();

        // Consume the leftover newline
        scanner.nextLine();

        // Create an array to store the strings
        String[] strings = new String[n];

        // Take the strings as input from the user
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        // Sort the array of strings by their length using a custom comparator
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // Compare the lengths of two strings
                return Integer.compare(str1.length(), str2.length());
            }
        });

        // Print the sorted array of strings
        System.out.println("Strings sorted by length:");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}

