package Day10;

import java.util.*;

public class DijkstraAlgorithm {

    // Graph representation using adjacency list
    static class Graph {
        private Map<Integer, List<Edge>> adjList;

        // Constructor
        public Graph() {
            adjList = new HashMap<>();
        }

        // Method to add an edge
        public void addEdge(int src, int dest, int weight) {
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
            adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, weight)); // For undirected graph
        }

        // Method to find the shortest path using Dijkstra's algorithm
        public Map<Integer, Integer> dijkstra(int start) {
            // Priority queue to store vertices with their shortest distance
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
            Map<Integer, Integer> dist = new HashMap<>(); // To store the shortest distance to each node
            Set<Integer> visited = new HashSet<>(); // To keep track of visited nodes

            // Initialize distances with infinity and source distance as 0
            for (int node : adjList.keySet()) {
                dist.put(node, Integer.MAX_VALUE);
            }
            dist.put(start, 0);

            pq.add(new Node(start, 0)); // Add source node to the priority queue

            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();
                int current = currentNode.vertex;

                // Skip the node if it has already been visited
                if (visited.contains(current)) continue;

                visited.add(current);

                // Explore the neighbors of the current node
                for (Edge edge : adjList.get(current)) {
                    int neighbor = edge.dest;
                    int weight = edge.weight;

                    // Calculate new distance for the neighbor
                    int newDist = dist.get(current) + weight;

                    // If a shorter path is found, update the distance and add the neighbor to the queue
                    if (newDist < dist.get(neighbor)) {
                        dist.put(neighbor, newDist);
                        pq.add(new Node(neighbor, newDist));
                    }
                }
            }

            return dist;
        }
    }

    // Edge class to store the destination node and the weight
    static class Edge {
        int dest, weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Node class to store the vertex and its corresponding distance
    static class Node {
        int vertex, distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        // Taking user input for the number of edges
        System.out.println("Enter the number of edges in the graph:");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: vertex1 vertex2 weight):");
        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(v1, v2, weight);
        }

        // Taking user input for the start vertex
        System.out.println("Enter the start vertex for Dijkstra's algorithm:");
        int startVertex = scanner.nextInt();

        // Find the shortest paths using Dijkstra's algorithm
        Map<Integer, Integer> shortestPaths = graph.dijkstra(startVertex);

        // Print the shortest path to all nodes
        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> Distance: " + entry.getValue());
        }
    }
}

