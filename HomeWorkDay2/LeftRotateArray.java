package HomeWorkDay2;

import java.util.Scanner;

public class LeftRotateArray {

    // Method to left rotate the array by one position
    public static void leftRotateByOne(int[] arr) {
        int n = arr.length;

        // If the array is empty or has one element, no rotation is needed
        if (n <= 1) {
            return;
        }

        // Store the first element of the array
        int firstElement = arr[0];

        // Shift all elements one position to the left
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the end of the array
        arr[n - 1] = firstElement;
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

        // Perform the left rotation by one position
        leftRotateByOne(arr);

        // Display the rotated array
        System.out.println("Array after left rotating by one position:");
        displayArray(arr);
    }
}

