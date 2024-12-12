package Day8;

import java.util.Scanner;

public class LinkedListMiddleElement {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to find the middle element of the linked list using the slow and fast pointer approach
    public static int findMiddle(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty.");
        }

        ListNode slow = head;  // Slow pointer
        ListNode fast = head;  // Fast pointer

        // Traverse the list: fast pointer moves two steps, slow pointer moves one step
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps
        }

        // When fast pointer reaches the end, slow pointer will be at the middle
        return slow.val;
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

        // Create a linked list based on user input
        ListNode head = createLinkedList(scanner);

        // Print the linked list
        System.out.println("The linked list:");
        printList(head);

        // Find and print the middle element of the linked list
        try {
            int middleValue = findMiddle(head);
            System.out.println("The middle element of the linked list is: " + middleValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

