package HomeWorkDay6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectionOfSortedArrays {

    // Method to find the intersection of two sorted arrays
    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < arr1.length && j < arr2.length) {
            // If elements are equal, add to intersection list
            if (arr1[i] == arr2[j]) {
                // Avoid duplicates in the intersection
                if (intersection.isEmpty() || intersection.get(intersection.size() - 1) != arr1[i]) {
                    intersection.add(arr1[i]);
                }
                i++;
                j++;
            }
            // If arr1[i] is smaller, increment i
            else if (arr1[i] < arr2[j]) {
                i++;
            }
            // If arr2[j] is smaller, increment j
            else {
                j++;
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: size and elements of the first array
        System.out.println("Enter the size of the first sorted array:");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the elements of the first sorted array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }

        // Input: size and elements of the second array
        System.out.println("Enter the size of the second sorted array:");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the elements of the second sorted array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }

        // Find the intersection of the two arrays
        List<Integer> intersection = findIntersection(arr1, arr2);

        // Output the result
        if (intersection.isEmpty()) {
            System.out.println("No intersection found.");
        } else {
            System.out.println("Intersection of the two arrays: " + intersection);
        }
    }
}
