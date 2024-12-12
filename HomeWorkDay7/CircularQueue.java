package HomeWorkDay7;

import java.util.Scanner;

public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue operation (add an element to the queue)
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        System.out.println("Enqueued: " + element);
    }

    // Dequeue operation (remove an element from the queue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return -1 if queue is empty
        }
        int dequeuedElement = queue[front];
        front = (front + 1) % capacity;
        size--;
        return dequeuedElement;
    }

    // Peek operation (view the front element of the queue without removing it)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1; // Return -1 if queue is empty
        }
        return queue[front];
    }

    // Display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a circular queue of capacity 5
        CircularQueue queue = new CircularQueue(5);

        while (true) {
            // Display menu
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Enqueue operation
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;

                case 2:
                    // Dequeue operation
                    int dequeuedElement = queue.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued: " + dequeuedElement);
                    }
                    break;

                case 3:
                    // Peek operation
                    int frontElement = queue.peek();
                    if (frontElement != -1) {
                        System.out.println("Front element: " + frontElement);
                    }
                    break;

                case 4:
                    // Display the queue
                    queue.display();
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

