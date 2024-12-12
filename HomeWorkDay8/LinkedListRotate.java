package HomeWorkDay8;

import java.util.Scanner;

public class LinkedListRotate {

    // Definition for singly linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to rotate the linked list by K nodes
    public static ListNode rotateList(ListNode head, int k) {
        // If the list is empty or only one node exists, no rotation is needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the linked list
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        // Step 2: Normalize k (in case k > length)
        k = k % length;
        if (k == 0) {
            return head; // No need to rotate
        }

        // Step 3: Find the (length - k)th node (new tail)
        current.next = head; // Connect the last node to the head to make it circular
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 4: Find the new head
        ListNode newHead = newTail.next;
        newTail.next = null; // Break the cycle

        return newHead;
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

        // Create linked list based on user input
        System.out.println("Enter details for the linked list:");
        ListNode head = createLinkedList(scanner);

        // Print the original linked list
        System.out.println("Original linked list:");
        printList(head);

        // Get the value of K (number of rotations)
        System.out.print("Enter the number of nodes to rotate by (K): ");
        int k = scanner.nextInt();

        // Rotate the linked list by K nodes
        head = rotateList(head, k);

        // Print the rotated linked list
        System.out.println("Linked list after rotating by " + k + " nodes:");
        printList(head);
    }
}

