package Day10;

import java.util.*;

public class GraphTraversal {

    // Define the graph using adjacency list
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

        // Method for Depth-First Search (DFS)
        public void dfs(int start) {
            Set<Integer> visited = new HashSet<>();
            dfsUtil(start, visited);
        }

        // Utility function for DFS traversal (recursive)
        private void dfsUtil(int v, Set<Integer> visited) {
            visited.add(v);
            System.out.print(v + " ");

            for (int neighbor : adjList.getOrDefault(v, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    dfsUtil(neighbor, visited);
                }
            }
        }

        // Method for Breadth-First Search (BFS)
        public void bfs(int start) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            visited.add(start);
            queue.offer(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");

                for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
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

        // Taking user input for the start vertex
        System.out.println("Enter the start vertex for DFS and BFS:");
        int startVertex = scanner.nextInt();

        // Perform DFS and BFS
        System.out.println("DFS traversal starting from vertex " + startVertex + ":");
        graph.dfs(startVertex);

        System.out.println("\nBFS traversal starting from vertex " + startVertex + ":");
        graph.bfs(startVertex);
    }
}

