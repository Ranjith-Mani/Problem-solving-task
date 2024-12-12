package BST;

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

    // Method to perform in-order traversal (Left, Root, Right)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left); // Visit left subtree
            System.out.print(root.data + " "); // Visit root
            inorder(root.right); // Visit right subtree
        }
    }

    // Wrapper method for inorder traversal
    public void inorderTraversal() {
        inorder(root);
    }
}

public class BinarySearchTreeInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        // Taking user input for the number of elements
        System.out.println("Enter the number of elements to insert into the Binary Search Tree:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements to insert (integers):");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            bst.root = bst.insert(bst.root, data);
        }

        // Display the Binary Search Tree in In-order traversal (sorted order)
        System.out.println("\nIn-order Traversal of the Binary Search Tree:");
        bst.inorderTraversal();
    }
}

