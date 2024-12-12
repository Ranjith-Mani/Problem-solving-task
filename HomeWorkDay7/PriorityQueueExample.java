package HomeWorkDay7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a priority queue
        // Java's PriorityQueue by default is a Min-Heap (smallest element has the highest priority)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (true) {
            // Display menu
            System.out.println("\nPriority Queue Operations:");
            System.out.println("1. Insert Element");
            System.out.println("2. Remove Element (Poll)");
            System.out.println("3. Peek at the Top Element");
            System.out.println("4. Display the Priority Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Insert element into the priority queue
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    pq.offer(element);
                    System.out.println("Element " + element + " inserted into the priority queue.");
                    break;

                case 2:
                    // Remove the element with the highest priority (smallest in this case for Min-Heap)
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is empty. Cannot remove any element.");
                    } else {
                        int removedElement = pq.poll();
                        System.out.println("Removed element: " + removedElement);
                    }
                    break;

                case 3:
                    // Peek at the top element without removing it
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is empty. Nothing to peek.");
                    } else {
                        int topElement = pq.peek();
                        System.out.println("Top element (highest priority): " + topElement);
                    }
                    break;

                case 4:
                    // Display the elements of the priority queue
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is empty.");
                    } else {
                        System.out.println("Priority Queue elements: " + pq);
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
