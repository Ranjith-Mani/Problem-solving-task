package Day5;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        // Implementing scanner class to get input from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of an array : ");
        int n = input.nextInt();
        System.out.println();

        // Implementing an array
        int[] arr = new int[n];

        // To read array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        selectionSort(arr);
        toPrintASortedArray(arr);
    }

    // Implementing methods
    private static void toPrintASortedArray(int[] arr) {
        System.out.println("Your required sorted array elements : ");
        for (int value : arr ){
            System.out.print(value+" ");
        }
        System.out.println();
    }

    private static void selectionSort(int[] arr) {
        // Length of an array
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < n ; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // For swapping elements
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
