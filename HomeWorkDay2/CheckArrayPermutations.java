package HomeWorkDay2;

import java.util.Arrays;
import java.util.Scanner;

public class CheckArrayPermutations {

    // Method to check if two arrays are permutations of each other using sorting
    public static boolean arePermutations(int[] arr1, int[] arr2) {
        // If the lengths are different, they can't be permutations
        if (arr1.length != arr2.length) {
            return false;
        }

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare the sorted arrays
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size and elements for the first array
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }

        // Input the size and elements for the second array
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }

        // Check if the arrays are permutations of each other
        if (arePermutations(arr1, arr2)) {
            System.out.println("The arrays are permutations of each other.");
        } else {
            System.out.println("The arrays are NOT permutations of each other.");
        }

        scanner.close();
    }
}

