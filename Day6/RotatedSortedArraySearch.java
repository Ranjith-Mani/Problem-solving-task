package Day6;

import java.util.Scanner;

public class RotatedSortedArraySearch {

    // Method to search for a target element in a rotated sorted array
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[left] <= arr[mid]) {
                // Target is in the left half
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // If the element is not found
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the rotated sorted array
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Take input for the target element
        System.out.println("Enter the target element to search for:");
        int target = scanner.nextInt();

        // Perform the search
        int result = search(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}

