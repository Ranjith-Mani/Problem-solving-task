package Day6;

import java.util.Scanner;

public class CountOccurrencesInSortedArray {

    // Method to find the first occurrence of a target element in the sorted array
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // Default value if target is not found

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching in the left half
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Method to find the last occurrence of a target element in the sorted array
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // Default value if target is not found

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching in the right half
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Method to count occurrences of the target element
    public static int countOccurrences(int[] arr, int target) {
        int firstIndex = findFirstOccurrence(arr, target);
        if (firstIndex == -1) {
            return 0; // Element not found
        }

        int lastIndex = findLastOccurrence(arr, target);
        return lastIndex - firstIndex + 1; // Count occurrences
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
        System.out.println("Enter the target element to count occurrences:");
        int target = scanner.nextInt();

        // Count the occurrences of the target element
        int occurrences = countOccurrences(arr, target);

        System.out.println("Element " + target + " appears " + occurrences + " time(s) in the array.");
    }
}

