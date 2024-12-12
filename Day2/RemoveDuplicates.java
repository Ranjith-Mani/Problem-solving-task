package Day2;

import java.util.Scanner;

public class RemoveDuplicates {

    // Method to remove duplicates from the sorted array
    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // If the array is empty or null, return 0
        }

        int n = arr.length;
        int uniqueIndex = 1; // We start from index 1 because the first element is always unique

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                // If the current element is not the same as the previous one,
                // it's unique, so we move it to the "unique" position
                arr[uniqueIndex] = arr[i];
                uniqueIndex++;
            }
        }

        return uniqueIndex; // The length of the array with unique elements
    }

    // Method to display the array
    public static void displayArray(int[] arr, int length) {
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the sorted array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        // Input elements of the sorted array
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the method to remove duplicates
        int newLength = removeDuplicates(arr);

        // Display the array after removing duplicates
        displayArray(arr, newLength);
    }
}

