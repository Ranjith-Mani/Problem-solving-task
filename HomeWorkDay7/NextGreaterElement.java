package HomeWorkDay7;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        // Implementing scanner class to get input from the user
        Scanner input = new Scanner(System.in);

        // Take the array size as input
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();

        // Create an array of the given size
        int[] arr = new int[n];

        // Take the array elements as input
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // Create a stack to store the indices of elements
        Stack<Integer> stack = new Stack<>();

        // Array to store the next greater elements
        int[] nextGreater = new int[n];

        // Initialize next greater elements as -1 (default value for elements without next greater)
        for (int i = 0; i < n; i++) {
            nextGreater[i] = -1;
        }

        // Iterate over the array from left to right
        for (int i = 0; i < n; i++) {
            // Check for next greater element for each element in the stack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop(); // Pop the index from stack
                nextGreater[index] = arr[i]; // Set the next greater element
            }
            stack.push(i); // Push the current index to the stack
        }

        // Print the next greater element for each element in the array
        System.out.println("Next greater element for each element: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }
}

