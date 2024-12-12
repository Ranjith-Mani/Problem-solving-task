package Day5;

import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {

        // Implementing scanner class to get an input from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of an array : ");
        int n = input.nextInt();

        // Implementing an array
        int[] arr = new int[n];

        // To read an elements in array
        System.out.println("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        countSort(arr);

        // To print the array elements
        System.out.println("your sorted array : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void countSort(int[] arr) {
        // To denote the maximum element
        int max = arr[0];

        // Iterate over loop
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }

        // create a count array to store the frequency of each element
        int[] count = new int[max+1];

        // To count the frequency of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }

        // To update the array
        int index = 0;

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0){
                arr[index] = i;
                index ++;
                count[i] --;
            }
        }
    }
}
