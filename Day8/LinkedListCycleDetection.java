package Day8;

import java.util.Scanner;

public class LinkedListCycleDetection {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to detect if the linked list has a cycle using Floyd's Cycle-Finding Algorithm
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;  // An empty list has no cycle
        }

        ListNode slow = head;  // Slow pointer (tortoise)
        ListNode fast = head;  // Fast pointer (hare)

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps

            if (slow == fast) {
                return true;  // Cycle detected
            }
        }

        return false;  // No cycle found (fast pointer reached the end)
    }

    // Utility method to create a linked list from user input
    public static ListNode createLinkedList(Scanner scanner) {
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        if (n == 0) {
            return null;  // No elements, return null
        }

        System.out.println("Enter the elements of the linked list:");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        // Creating the linked list from user input
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        return head;
    }

    // Method to create a cycle in the linked list if needed
    public static void createCycle(ListNode head, Scanner scanner) {
        System.out.print("Do you want to create a cycle? (yes/no): ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter the index where the cycle should start (0-based index): ");
            int position = scanner.nextInt();
            if (position < 0) return;

            ListNode current = head;
            ListNode cycleNode = null;
            int index = 0;

            // Find the node where the cycle will start
            while (current != null && current.next != null) {
                if (index == position) {
                    cycleNode = current;
                }
                current = current.next;
                index++;
            }

            // Create the cycle by connecting the last node to the cycleNode
            if (cycleNode != null) {
                current.next = cycleNode;
            }
        }
    }

    public static void main(String[] args) {
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create a linked list based on user input
        ListNode head = createLinkedList(scanner);

        // Ask user whether to create a cycle
        createCycle(head, scanner);

        // Check if the linked list has a cycle
        boolean hasCycle = hasCycle(head);

        // Print the result
        if (hasCycle) {
            System.out.println("The linked list has a cycle.");
        } else {
            System.out.println("The linked list does not have a cycle.");
        }
    }
}

