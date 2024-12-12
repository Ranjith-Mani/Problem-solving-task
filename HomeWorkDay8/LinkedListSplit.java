package HomeWorkDay8;

import java.util.Scanner;

public class LinkedListSplit {

    // Definition for singly linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to split the linked list into two halves
    public static void splitList(ListNode head) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (head.next == null) {
            System.out.println("The list has only one element. No split required.");
            System.out.println("First Half: " + head.val);
            System.out.println("Second Half: ");
            return;
        }

        // Step 1: Use slow and fast pointers to find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list into two halves
        ListNode secondHalf = slow.next;
        slow.next = null; // End the first half

        // Print the two halves
        System.out.println("First Half:");
        printList(head);

        System.out.println("Second Half:");
        printList(secondHalf);
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

    // Utility method to print the linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create linked list based on user input
        System.out.println("Enter details for the linked list:");
        ListNode head = createLinkedList(scanner);

        // Check for empty list
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            // Print the original linked list
            System.out.println("Original linked list:");
            printList(head);

            // Split the linked list into two halves
            splitList(head);
        }
    }
}
