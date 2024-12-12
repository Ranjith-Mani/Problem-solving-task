package Day5;

import java.util.Scanner;

public class ZerosAndOnesSort {
    public static void main(String[] args) {

        // Implementing scanner class to get input from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of an array : ");
        int n = input.nextInt();

        // Implementing array
        int[] arr = new int[n];

        // To read array elements
        System.out.println("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // Implementing method
        zerosAndOnesSort(arr);
        printSortedArray(arr);
    }

    private static void printSortedArray(int[] arr) {
        System.out.println("Your sorted array : ");
        for (int value : arr){
            System.out.print(value + " ");
        }
    }

    private static void zerosAndOnesSort(int[] arr) {
        // Logics
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            if (arr[low] == 0){
                low ++;
            } else if (arr[high] == 1) {
                high --;
            }else {
                swap(arr,low,high);
                low ++;
                high --;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // Swap logic
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
