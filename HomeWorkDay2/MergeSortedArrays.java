package HomeWorkDay2;

import java.util.Scanner;

public class MergeSortedArrays {

    // Method to merge two sorted arrays
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Create a new array to hold the merged result
        int[] mergedArray = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Merge the arrays while both have elements
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // If there are remaining elements in arr1
        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }

        // If there are remaining elements in arr2
        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    // Method to display an array
    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size and elements for the first sorted array
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Enter the elements of the first sorted array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }

        // Input the size and elements for the second sorted array
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Enter the elements of the second sorted array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }

        // Merge the two sorted arrays
        int[] mergedArray = mergeArrays(arr1, arr2);

        // Display the merged sorted array
        System.out.println("Merged sorted array:");
        displayArray(mergedArray);
    }
}

