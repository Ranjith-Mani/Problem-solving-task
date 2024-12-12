package HomeWorkDay9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RootToLeafPaths {

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
    public RootToLeafPaths() {
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

    // Method to find all root-to-leaf paths
    public void findPaths(Node root, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        // Add the current node's data to the path
        currentPath.add(root.data);

        // If it's a leaf node, add the path to the list of all paths
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath)); // Copy the current path
        } else {
            // Otherwise, explore both subtrees
            findPaths(root.left, currentPath, allPaths);
            findPaths(root.right, currentPath, allPaths);
        }

        // Backtrack: remove the current node's data from the path before returning
        currentPath.remove(currentPath.size() - 1);
    }

    // Wrapper method to print all root-to-leaf paths
    public void printRootToLeafPaths() {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, currentPath, allPaths);

        // Print all root-to-leaf paths
        System.out.println("Root-to-Leaf Paths:");
        for (List<Integer> path : allPaths) {
            for (Integer node : path) {
                System.out.print(node + " -> ");
            }
            System.out.println("null");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RootToLeafPaths tree = new RootToLeafPaths();

        // Taking user input for the number of elements to insert into the tree
        System.out.println("Enter the number of elements to insert into the binary tree:");
        int n = scanner.nextInt();

        // Inserting elements into the binary tree
        System.out.println("Enter the elements to insert (integers):");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.root = tree.insert(tree.root, data);
        }

        // Print all root-to-leaf paths
        tree.printRootToLeafPaths();
    }
}

