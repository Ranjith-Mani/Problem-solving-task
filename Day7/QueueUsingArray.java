package Day7;

import java.util.Scanner;

// Implementing Queue class to perform all the functionalities
class Queue{

    // Assigning variables
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Implementing parameterized constructor
    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        // To denote both front and rear ends are initially empty
        this.front = -1;
        this.rear = -1;
    }

    // Implementing enqueue method for inserting value to queue
    public void enqueue(int value) {
        // Logics
        if (rear == size-1){
            System.out.println("Queue is full.....");
            return;
        }
        if (front == -1){
            front = 0;
        }
        rear++;
        queue[rear] = value;
        System.out.println(value + " inserted to queue successfully....");
    }

    // Implementing dequeue method for removing value from queue
    public int dequeue() {
        // Logics
        if (front == -1 || front > rear){
            System.out.println("Queue is empty....cannot perform dequeue operation");
            return -1;
        }
        int value = queue[front];
        front ++;
        if (front > rear){
            front=rear= -1;
        }
        System.out.println(value + " dequeued successfully.....");
        return value;
    }

    // Implementing displayElements method for displaying all the elements in queue
    public void displayElements() {
        // Logics
        if (front == -1 || front > rear){
            System.out.println("Queue is empty......");
            return;
        }
        for (int i = front; i <= rear ; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {

        // Implementing scanner class to get an input from the user
        Scanner input = new Scanner(System.in);

        // size of a queue
        System.out.print("Enter the size of a queue : ");
        int size = input.nextInt();

        // Implementing object for Queue class in QueueUsingArray class (main class)
        Queue queue = new Queue(size);

        // Implementing menu-driven program to show the number of operations to user
        while (true){
            System.out.println("Choose your required operation.....");
            System.out.println("""
                    1. Enqueue
                    2. Dequeue
                    3. Display elements in queue
                    4. Exit
                    """);

            // Implemented for user to select the choice
            System.out.println("Enter your choice of operations from 1 to 4 : ");
            int choice = input.nextInt();

            // Menu-driven program
            switch (choice){
                case 1:
                    System.out.println("Enter the value which you want to insert to queue... ");
                    int value = input.nextInt();
                    queue.enqueue(value);
                    break;

                case 2:
                    System.out.println("The element which you want to remove from the queue dequeued successfully...");
                    queue.dequeue();
                    break;

                case 3:
                    System.out.println("Elements in the queue... ");
                    queue.displayElements();
                    break;

                case 4:
                    System.out.println("Exiting........");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid.....Choose the valid operations");
            }
        }
    }
}
