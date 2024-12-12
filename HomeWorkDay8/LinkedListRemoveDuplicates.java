package HomeWorkDay8;

import java.util.HashSet;
import java.util.Scanner;

public class LinkedListRemoveDuplicates {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to remove duplicates from the linked list
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;  // If the list is empty, return null
        }

        HashSet<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            // If current value is already in the HashSet, skip the current node
            if (seen.contains(current.val)) {
                prev.next = current.next;  // Remove the current node
            } else {
                // Otherwise, add the current value to the HashSet
                seen.add(current.val);
                prev = current;  // Move prev to the current node
            }
            current = current.next;  // Move to the next node
        }

        return head;  // Return the head of the modified list
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

        // Remove duplicates from the linked list
        head = removeDuplicates(head);

        // Print the modified linked list after removing duplicates
        System.out.println("Linked list after removing duplicates:");
        printList(head);
    }
}
