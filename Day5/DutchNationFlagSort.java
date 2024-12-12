package Day5;

import java.util.Scanner;

public class DutchNationFlagSort {
    public static void main(String[] args) {

        // Implementing scanner class to get an input from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of an array : ");
        int n = input.nextInt();

        // Implementing an array
        int[] arr = new int[n];

        // To read the array elements
        System.out.println("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // Implementing methods
        dutchNationalFlagSort(arr);
        printSortedArray(arr);
    }

    private static void printSortedArray(int[] arr) {
        System.out.println("Your sorted array : ");
        for (int value : arr){
            System.out.print(value + " ");
        }
    }

    private static void dutchNationalFlagSort(int[] arr) {
        // Logics
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high){
            if (arr[mid] == 0) {
                swap(arr,low,mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid ++;
            }else {
                swap(arr,mid,high);
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
