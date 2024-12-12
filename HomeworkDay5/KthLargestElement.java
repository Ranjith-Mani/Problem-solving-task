package HomeworkDay5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {

    // Method to find the k-th largest element in an array
    public static int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the array
        for (int num : nums) {
            minHeap.add(num);
            // If the heap size exceeds k, remove the smallest element (root of the min-heap)
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // Create a scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Ask user for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Create the array based on the user's input size
        int[] nums = new int[n];

        // Take array input from user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Ask user for the value of k (the k-th largest element)
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Find the k-th largest element
        int result = findKthLargest(nums, k);

        // Print the result
        System.out.println("The " + k + "-th largest element is: " + result);
    }
}

