package HomeWorkDay8;

import java.util.Scanner;

public class LinkedListIntersection {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to find the length of a linked list
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Method to find the intersection point of two linked lists
    public static ListNode getIntersection(ListNode head1, ListNode head2) {
        // Get the lengths of both linked lists
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        // Adjust the starting point for the longer list
        ListNode current1 = head1;
        ListNode current2 = head2;

        // Move the pointer of the longer list forward by the difference in lengths
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                current1 = current1.next;
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                current2 = current2.next;
            }
        }

        // Move both pointers one step at a time and check for intersection
        while (current1 != null && current2 != null) {
            if (current1 == current2) {
                return current1; // Intersection point found
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return null; // No intersection found
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

    // Method to create an intersection between two linked lists
    public static void createIntersection(ListNode head1, ListNode head2, int intersectVal) {
        // Find the intersection node in the first list
        ListNode current1 = head1;
        while (current1 != null && current1.val != intersectVal) {
            current1 = current1.next;
        }

        // Find the last node of the second list
        ListNode current2 = head2;
        while (current2 != null && current2.next != null) {
            current2 = current2.next;
        }

        // Create the intersection by connecting the last node of list2 to the intersection node in list1
        if (current1 != null && current2 != null) {
            current2.next = current1; // Make the two lists intersect
        }
    }

    public static void main(String[] args) {
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create first linked list based on user input
        System.out.println("Enter details for the first linked list:");
        ListNode head1 = createLinkedList(scanner);

        // Create second linked list based on user input
        System.out.println("Enter details for the second linked list:");
        ListNode head2 = createLinkedList(scanner);

        // Optionally create an intersection for testing purposes
        System.out.print("Enter intersection value (0 to skip): ");
        int intersectionVal = scanner.nextInt();
        if (intersectionVal != 0) {
            createIntersection(head1, head2, intersectionVal);
        }

        // Print both linked lists
        System.out.println("First linked list:");
        printList(head1);

        System.out.println("Second linked list:");
        printList(head2);

        // Get the intersection point of the two linked lists
        ListNode intersection = getIntersection(head1, head2);

        // Print the result
        if (intersection != null) {
            System.out.println("The intersection point is: " + intersection.val);
        } else {
            System.out.println("The two linked lists do not intersect.");
        }
    }
}
