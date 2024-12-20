package Day5;

import java.util.Scanner;

public class BubbleSort {
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

        bubbleSort(arr);
        toPrintASortedArray(arr);
    }

    private static void toPrintASortedArray(int[] arr) {
        System.out.println("Your required sorted array elements : ");
        for (int value : arr){
            System.out.print(value+" ");
        }
        System.out.println();
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n-1; i++) {
            swapped = false;

            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
}
