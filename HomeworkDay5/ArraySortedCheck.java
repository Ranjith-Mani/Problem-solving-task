package HomeworkDay5;

import java.util.Scanner;

public class ArraySortedCheck {

    // Method to check if the array is sorted in ascending order
    public static boolean isSorted(int[] arr) {
        // Check if the array is sorted in ascending order
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; // If any element is greater than the next one, it's not sorted
            }
        }
        return true; // If no such pair is found, the array is sorted
    }

    public static void main(String[] args) {
        // Create a scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Ask user for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Create the array based on the input size
        int[] arr = new int[n];

        // Take array input from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Check if the array is sorted
        if (isSorted(arr)) {
            System.out.println("The array is sorted in ascending order.");
        } else {
            System.out.println("The array is not sorted in ascending order.");
        }
    }
}

