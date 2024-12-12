package Day8;

import java.util.Scanner;

public class LinkedListReversal {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to reverse the linked list iteratively
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        // Traverse the list and reverse the links
        while (current != null) {
            next = current.next;  // Save the next node
            current.next = prev;  // Reverse the current node's next pointer
            prev = current;       // Move prev and current one step forward
            current = next;
        }

        return prev;  // prev will be the new head of the reversed list
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

        // Print the original linked list
        System.out.println("Original linked list:");
        printList(head);

        // Reverse the linked list
        head = reverseList(head);

        // Print the reversed linked list
        System.out.println("Reversed linked list:");
        printList(head);
    }
}

