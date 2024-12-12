package Day10;

import java.util.*;

public class GraphCycleDetection {

    // Define the graph using an adjacency list
    static class Graph {
        private Map<Integer, List<Integer>> adjList;

        // Constructor
        public Graph() {
            adjList = new HashMap<>();
        }

        // Method to add an edge to the graph (undirected)
        public void addEdge(int v, int w) {
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
            adjList.computeIfAbsent(w, k -> new ArrayList<>()).add(v);
        }

        // Method to detect a cycle in the graph
        public boolean hasCycle() {
            Set<Integer> visited = new HashSet<>();
            for (int vertex : adjList.keySet()) {
                if (!visited.contains(vertex)) {
                    if (dfsCycleDetection(vertex, visited, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        // DFS method to detect a cycle
        private boolean dfsCycleDetection(int current, Set<Integer> visited, int parent) {
            visited.add(current);

            // Explore all adjacent vertices
            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                // If the neighbor is not visited, recursively perform DFS
                if (!visited.contains(neighbor)) {
                    if (dfsCycleDetection(neighbor, visited, current)) {
                        return true;
                    }
                }
                // If the neighbor is already visited and is not the parent, a cycle is found
                else if (neighbor != parent) {
                    return true;
                }
            }
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

        // Detect if the graph has a cycle
        if (graph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}

