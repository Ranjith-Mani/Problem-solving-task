package Day2;

import java.util.Scanner;

public class RotateArray {

    // Method to rotate the array to the right by 'k' positions
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is larger than the length of the array
        reverse(arr, 0, n - 1); // Reverse the entire array
        reverse(arr, 0, k - 1); // Reverse the first 'k' elements
        reverse(arr, k, n - 1); // Reverse the remaining elements
    }

    // Method to rotate the array to the left by 'k' positions
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is larger than the length of the array
        reverse(arr, 0, k - 1); // Reverse the first 'k' elements
        reverse(arr, k, n - 1); // Reverse the remaining elements
        reverse(arr, 0, n - 1); // Reverse the entire array
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements at 'start' and 'end'
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Method to display the array
    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input the number of positions to rotate
        System.out.print("Enter the number of positions to rotate: ");
        int k = scanner.nextInt();

        // Input direction for rotation
        System.out.print("Enter the direction of rotation (1 for right, 2 for left): ");
        int direction = scanner.nextInt();

        // Perform the rotation based on user input
        if (direction == 1) {
            rotateRight(arr, k);
            System.out.println("Array after rotating right:");
        } else if (direction == 2) {
            rotateLeft(arr, k);
            System.out.println("Array after rotating left:");
        } else {
            System.out.println("Invalid direction. Exiting...");
            return;
        }

        // Display the rotated array
        displayArray(arr);
    }
}

