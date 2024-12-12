package HomeWorkDay9;

import java.util.Scanner;

public class SumOfBinaryTree {

    // Define the structure of the binary tree node
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

    // Constructor to initialize the tree
    public SumOfBinaryTree() {
        root = null;
    }

    // Method to insert a node into the binary tree
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Method to sum up all elements in the binary tree
    public int sumOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        // Sum the left subtree, right subtree and the current node's data
        return root.data + sumOfTree(root.left) + sumOfTree(root.right);
    }

    // Wrapper method to get the sum of the entire tree
    public int getSum() {
        return sumOfTree(root);
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SumOfBinaryTree tree = new SumOfBinaryTree();

        // Taking user input for the number of elements to insert into the tree
        System.out.println("Enter the number of elements to insert into the binary tree:");
        int n = scanner.nextInt();

        // Inserting elements into the binary tree
        System.out.println("Enter the elements to insert (integers):");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.root = tree.insert(tree.root, data);
        }

        // Print the sum of all elements in the tree
        int sum = tree.getSum();
        System.out.println("Sum of all elements in the binary tree: " + sum);
    }
}

