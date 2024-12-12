package BST1;

import java.util.Scanner;

class BinarySearchTree {
    // Node structure for the binary search tree
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the binary search tree
    Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a node into the BST
    public Node insert(Node root, int data) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insert(root.left, data); // Insert in the left subtree
        } else if (data > root.data) {
            root.right = insert(root.right, data); // Insert in the right subtree
        }

        // Return the unchanged root pointer
        return root;
    }

    // Method to search for an element in the BST
    public boolean search(Node root, int key) {
        // Base case: if root is null or key is present at the root
        if (root == null) {
            return false;
        }

        // If the key is smaller than root's data, it is in the left subtree
        if (key < root.data) {
            return search(root.left, key);
        }

        // If the key is greater than root's data, it is in the right subtree
        if (key > root.data) {
            return search(root.right, key);
        }

        // If key is equal to root's data, we have found the element
        return true;
    }

    // Wrapper method for insert
    public void insertElement(int data) {
        root = insert(root, data);
    }

    // Wrapper method for search
    public boolean searchElement(int key) {
        return search(root, key);
    }
}

public class BinarySearchTreeSearching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        // Taking user input for the number of elements
        System.out.println("Enter the number of elements to insert into the Binary Search Tree:");
        int n = scanner.nextInt();

        // Inserting elements into the BST
        System.out.println("Enter the elements to insert (integers):");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            bst.insertElement(data);
        }

        // Taking input for the element to search
        System.out.println("Enter the element to search in the Binary Search Tree:");
        int key = scanner.nextInt();

        // Searching for the element
        if (bst.searchElement(key)) {
            System.out.println("Element " + key + " found in the Binary Search Tree.");
        } else {
            System.out.println("Element " + key + " not found in the Binary Search Tree.");
        }
    }
}

