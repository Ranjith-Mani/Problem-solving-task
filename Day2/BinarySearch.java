package Day2;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        // Implementing Scanner class to get an input from the User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of an Array : ");
        int n = input.nextInt(); // Length of an Array

        // Implementing an Array using User input
        System.out.print("Create a required Array : ");
        int[] arr = new int[n]; // Required Array

        // To read an Array
        for (int i = 0; i < n ; i++) {
            arr[i] = input.nextInt();
        }

        // Implementing a Target using User Input
        System.out.print("Enter the Target Element : ");
        int target = input.nextInt();

        // Implementing method for Binary Search
        int result = binarysearch(arr,target);

        // To print the result
        if (result != -1){
            System.out.println("Your required index value is : " + result);
        }else {
            System.out.println("Your index is out of array bound : " + -1);
        }
    }

    // Method for Binary Search
    private static int binarysearch(int[] arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        while (leftPointer <= rightPointer){
            int midValue = leftPointer + (rightPointer - leftPointer)/2; // To find a Middle value

            // Check if the target element is available in middle then,
            if (arr[midValue] == target){
                return midValue;
            }

            // Check if the target element is available in right half then ignore left half
            else if (arr[midValue] < target) {
                leftPointer = midValue + 1;
            } else {
                rightPointer = midValue - 1;
            }
        }
        return -1;
    }
}
