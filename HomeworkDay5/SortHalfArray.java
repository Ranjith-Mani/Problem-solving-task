package HomeworkDay5;

import java.util.Arrays;
import java.util.Scanner;

public class SortHalfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Checking if the array size is positive
        if (n <= 0) {
            System.out.println("Please enter a positive integer for the size.");
            return;
        }

        // Creating an array to store the elements
        int[] arr = new int[n];

        // Taking input for array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculating the midpoint of the array
        int mid = n / 2;

        // Sorting the first half of the array in ascending order
        int[] firstHalf = Arrays.copyOfRange(arr, 0, mid);
        Arrays.sort(firstHalf);

        // Creating the final array with the sorted first half and the second half unchanged
        int[] sortedArray = new int[n];
        System.arraycopy(firstHalf, 0, sortedArray, 0, mid);
        System.arraycopy(arr, mid, sortedArray, mid, n - mid);

        // Printing the final result
        System.out.println("Array after sorting the first half:");
        for (int i = 0; i < n; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }
}

