package BT;

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

    // Method to insert a node
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

    // In-order traversal (Left, Root, Right)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Wrapper methods for traversal (simplifies calling from main)
    public void inorderTraversal() {
        inorder(root);
    }

    public void preorderTraversal() {
        preorder(root);
    }

    public void postorderTraversal() {
        postorder(root);
    }
}

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        // Taking user input for tree creation
        System.out.println("Enter the number of nodes to insert into the tree:");
        int numNodes = scanner.nextInt();

        // Inserting nodes into the binary tree
        System.out.println("Enter the nodes (integers):");
        for (int i = 0; i < numNodes; i++) {
            int data = scanner.nextInt();
            tree.root = tree.insert(tree.root, data);
        }

        // Display menu for traversals
        while (true) {
            System.out.println("\nChoose a traversal method:");
            System.out.println("1. In-order Traversal");
            System.out.println("2. Pre-order Traversal");
            System.out.println("3. Post-order Traversal");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("In-order Traversal: ");
                    tree.inorderTraversal();
                    break;
                case 2:
                    System.out.println("Pre-order Traversal: ");
                    tree.preorderTraversal();
                    break;
                case 3:
                    System.out.println("Post-order Traversal: ");
                    tree.postorderTraversal();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
            System.out.println(); // Add extra space between outputs
        }
    }
}

