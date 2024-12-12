package HomeWorkDay6;

import java.util.Scanner;

public class MaxElementInCircularSortedArray {

    // Method to find the maximum element in a circular sorted array
    public static int findMax(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            // If the array is already sorted (no rotation), the last element is the max
            if (arr[left] <= arr[right]) {
                return arr[right];
            }

            int mid = left + (right - left) / 2;

            // Check if mid is the maximum element
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }

            // Check if mid-1 is the maximum element
            if (arr[mid - 1] > arr[mid]) {
                return arr[mid - 1];
            }

            // If the element at mid is greater than the leftmost element, the max must be in the right half
            if (arr[mid] >= arr[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // In case of an error, this line should never be reached
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: size of the circular sorted array
        System.out.println("Enter the size of the circular sorted array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input: elements of the circular sorted array
        System.out.println("Enter the elements of the circular sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the maximum element
        int maxElement = findMax(arr);

        // Output the maximum element
        System.out.println("The maximum element in the circular sorted array is: " + maxElement);
    }
}

