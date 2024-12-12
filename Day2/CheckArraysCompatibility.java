package Day2;

import java.util.Scanner;

public class CheckArraysCompatibility {

    // Method to check if two arrays are compatible
    public static boolean areCompatible(int[] arr1, int[] arr2) {
        // Check if the arrays have the same length
        if (arr1.length != arr2.length) {
            return false;
        }

        // Check if all corresponding elements are equal
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        // If no mismatches are found, the arrays are compatible
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the first array
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();

        // Initialize the first array
        int[] arr1 = new int[size1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }

        // Input the size of the second array
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();

        // Initialize the second array
        int[] arr2 = new int[size2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }

        // Check if the arrays are compatible
        if (areCompatible(arr1, arr2)) {
            System.out.println("The arrays are compatible.");
        } else {
            System.out.println("The arrays are not compatible.");
        }
    }
}
