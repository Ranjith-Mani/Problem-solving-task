package HomeWorkDay8;

import java.util.Scanner;

public class StackUsingLinkedList {

    // Definition of the node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Stack implementation using a linked list
    static class Stack {
        private ListNode top; // Points to the top of the stack
        private int size;     // Keep track of the stack size

        // Constructor to initialize an empty stack
        public Stack() {
            top = null;
            size = 0;
        }

        // Push an element onto the stack
        public void push(int value) {
            ListNode newNode = new ListNode(value);
            newNode.next = top; // Link the new node to the previous top
            top = newNode;      // Update the top to the new node
            size++;             // Increase size
            System.out.println(value + " pushed onto the stack.");
        }

        // Pop an element from the stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1; // Return -1 if stack is empty
            }
            int poppedValue = top.val; // Get the value to pop
            top = top.next;            // Move the top to the next node
            size--;                    // Decrease size
            return poppedValue;
        }

        // Peek at the top element of the stack
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot peek.");
                return -1; // Return -1 if stack is empty
            }
            return top.val; // Return the value at the top of the stack
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return top == null; // Stack is empty if top is null
        }

        // Return the size of the stack
        public int size() {
            return size;
        }

        // Utility method to print the stack (for debugging purposes)
        public void printStack() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            ListNode current = top;
            System.out.print("Stack: ");
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a stack object
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        while (true) {
            // Menu for user interaction
            System.out.println("Stack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Stack is Empty");
            System.out.println("5. Get Stack Size");
            System.out.println("6. Print Stack");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Push operation
                    System.out.print("Enter the value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    // Pop operation
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped value: " + poppedValue);
                    }
                    break;

                case 3:
                    // Peek operation
                    int peekValue = stack.peek();
                    if (peekValue != -1) {
                        System.out.println("Top value: " + peekValue);
                    }
                    break;

                case 4:
                    // Check if stack is empty
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;

                case 5:
                    // Get stack size
                    System.out.println("Stack size: " + stack.size());
                    break;

                case 6:
                    // Print stack contents
                    stack.printStack();
                    break;

                case 7:
                    // Exit program
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

