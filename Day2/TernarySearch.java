package Day2;

import java.util.Scanner;

public class TernarySearch {
    public static void main(String[] args) {

        // Implementing Scanner class for getting input form User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of an array : ");
        int n = input.nextInt(); // Length of an Array

        System.out.println("Create a required Array : ");
        int[] arr = new int[n]; // Required Array

        // Reading Array elements
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Enter the target element : ");
        int target = input.nextInt(); // Target element

        // Implementing method for Ternary Search
        int result = ternarysearch(arr, 0, arr.length - 1, target);

        // Print a result
        if (result != -1){
            System.out.println("Your required target index is : " + result);
        }else {
            System.out.println("your required target is out of bound : " + -1);
        }

    }

    private static int ternarysearch(int[] arr, int left, int right, int target) {
        // Divide into three parts
        int mid1 = 0;
        int mid2 = 0;
        if (right >= left) {
            mid1 = left + (right - left) / 3;
            mid2 = right - (right - left) / 3;

            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }

            // Search in third left
            if (target < arr[mid1]) {
                return ternarysearch(arr, left, mid1 - 1, target);
            } else if (target > arr[mid2]) {
                return ternarysearch(arr, mid2 + 1, right, target);
            } else {
                return ternarysearch(arr, mid2 + 1, mid1 + 1, target);
            }
        }
        return -1;
    }
}
