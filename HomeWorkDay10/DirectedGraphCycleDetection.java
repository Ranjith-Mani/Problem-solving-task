package HomeWorkDay10;

import java.util.*;

public class DirectedGraphCycleDetection {

    // Graph class using adjacency list representation
    static class Graph {
        private Map<Integer, List<Integer>> adjList;

        // Constructor
        public Graph() {
            adjList = new HashMap<>();
        }

        // Method to add a directed edge from src to dest
        public void addEdge(int src, int dest) {
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        }

        // Method to detect a cycle in the directed graph
        public boolean hasCycle() {
            Set<Integer> visited = new HashSet<>();        // Set of fully processed nodes
            Set<Integer> currentlyVisiting = new HashSet<>();  // Set of nodes in the current DFS path

            // Perform DFS on all vertices
            for (int vertex : adjList.keySet()) {
                if (!visited.contains(vertex)) {
                    if (dfs(vertex, visited, currentlyVisiting)) {
                        return true; // Cycle detected
                    }
                }
            }

            return false; // No cycle detected
        }

        // DFS method to detect cycle
        private boolean dfs(int node, Set<Integer> visited, Set<Integer> currentlyVisiting) {
            // If the node is in the recursion stack, we found a cycle
            if (currentlyVisiting.contains(node)) {
                return true;
            }

            // If the node is already fully processed, no need to explore it again
            if (visited.contains(node)) {
                return false;
            }

            // Mark the node as "currently visiting"
            currentlyVisiting.add(node);

            // Explore all the neighbors of the node
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (dfs(neighbor, visited, currentlyVisiting)) {
                    return true;
                }
            }

            // After visiting all neighbors, mark the node as fully processed
            currentlyVisiting.remove(node);
            visited.add(node);

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new graph
        Graph graph = new Graph();

        // Taking user input for the number of edges
        System.out.println("Enter the number of edges in the graph:");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.addEdge(v1, v2);
        }

        // Check if the graph contains a cycle
        if (graph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}

