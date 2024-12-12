package Day6;

import java.util.Scanner;

public class FirstOccurrenceInSortedArray {

    // Method to find the first occurrence of a target element in a sorted array
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // Default value if target is not found

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target element is found
            if (arr[mid] == target) {
                result = mid; // Record the index of the element
                right = mid - 1; // Continue searching in the left half to find the first occurrence
            }
            // If the target is smaller, search in the left half
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            // If the target is larger, search in the right half
            else {
                left = mid + 1;
            }
        }

        return result; // Return the index of the first occurrence or -1 if not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: size of the sorted array
        System.out.println("Enter the size of the sorted array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input: elements of the sorted array
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input: target element to search for
        System.out.println("Enter the target element to find the first occurrence:");
        int target = scanner.nextInt();

        // Find the first occurrence of the target
        int result = findFirstOccurrence(arr, target);

        if (result != -1) {
            System.out.println("First occurrence of " + target + " is at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
