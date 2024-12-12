package BT1;

import java.util.Scanner;

class BinaryTree {
    // Node structure for the binary tree
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the binary tree
    Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Method to insert a node into the binary tree
    public Node insert(Node root, int data) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, insert into the left or right subtree based on value
        if (data < root.data) {
            root.left = insert(root.left, data); // Insert in left subtree
        } else {
            root.right = insert(root.right, data); // Insert in right subtree
        }

        return root;
    }

    // Method to find the height of the binary tree
    public int height(Node root) {
        // Base case: if the node is null, return -1
        if (root == null) {
            return -1; // Null node has height -1
        }

        // Recursively calculate the height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // The height of the current node is the max height of the subtrees + 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Wrapper method to find the height of the tree
    public int findHeight() {
        return height(root);
    }

    // Wrapper method for inserting an element
    public void insertElement(int data) {
        root = insert(root, data);
    }
}

public class BinaryTreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        // Taking user input for the number of elements
        System.out.println("Enter the number of elements to insert into the Binary Tree:");
        int n = scanner.nextInt();

        // Inserting elements into the binary tree
        System.out.println("Enter the elements to insert (integers):");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.insertElement(data);
        }

        // Finding and displaying the height of the binary tree
        System.out.println("\nThe height of the binary tree is: " + tree.findHeight());
    }
}

