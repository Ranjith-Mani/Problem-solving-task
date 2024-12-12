package HomeWorkDay9;

import java.util.Scanner;

public class BSTToSortedLinkedList {

    // Node structure for the binary tree
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Node structure for the singly linked list
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }

    // Root of the binary tree
    Node root;

    // Constructor
    public BSTToSortedLinkedList() {
        root = null;
    }

    // Method to insert a node into the BST
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Method to perform in-order traversal and convert BST to sorted linked list
    public void inOrderTraversal(Node root, ListNode[] lastNode) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(root.left, lastNode);

        // Create a new linked list node for the current BST node
        ListNode newNode = new ListNode(root.data);
        if (lastNode[0] == null) {
            lastNode[0] = newNode; // If it's the first node, set it as the head
        } else {
            lastNode[0].next = newNode; // Otherwise, link it to the previous node
            lastNode[0] = newNode; // Move the lastNode pointer
        }

        // Traverse the right subtree
        inOrderTraversal(root.right, lastNode);
    }

    // Wrapper method to convert BST to sorted linked list
    public ListNode convertToLinkedList() {
        ListNode[] lastNode = new ListNode[1]; // An array to hold the last node reference
        inOrderTraversal(root, lastNode);
        return lastNode[0]; // Return the head of the linked list
    }

    // Wrapper method for inserting an element into the tree
    public void insertElement(int data) {
        root = insert(root, data);
    }

    // Method to print the linked list
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTToSortedLinkedList tree = new BSTToSortedLinkedList();

        // Taking user input for the number of elements
        System.out.println("Enter the number of elements to insert into the Binary Search Tree:");
        int n = scanner.nextInt();

        // Inserting elements into the binary search tree
        System.out.println("Enter the elements to insert (integers):");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.insertElement(data);
        }

        // Convert the binary search tree to a sorted linked list
        ListNode linkedListHead = tree.convertToLinkedList();

        // Print the sorted linked list
        System.out.println("\nSorted Linked List from BST:");
        tree.printLinkedList(linkedListHead);
    }
}
