package Day8;

import java.util.Scanner;

// Implementing Node class to perform all the node functionalities
class Node{
    // Assigning variables
    private int data;
    Node next;

    // Implementing parameterized constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Implementing LinkedListFunction class to perform all the linked list functionalities
class LinkedListFunction{
    // Assigning variables
    private Node head = null;

    // Implementing addNode method for adding value to linked List
    public void addNode(int value) {
    }

    // Implementing removeNode method for remove value from linked List
    public void removeNode(int valueToRemove) {
    }

    // Implementing displayElements method for to display all elements linked List
    public void displayElements() {
    }
}

public class LinkedList {
    public static void main(String[] args) {

        // Implementing scanner class to get an input from the user
        Scanner input = new Scanner(System.in);

        // Implementing object for LinkedListFunction class in LinkedList class (main class)
        LinkedListFunction LLF = new LinkedListFunction();

        // Implementing menu-driven program to show the number of operations to user
        while (true){
            System.out.println("""
                    1. Add element
                    2. Remove element
                    3. Display element
                    4. Exit""");

            // Implemented for user to select the choice
            System.out.println("Enter your choice of operations from 1 to 4 : ");
            int choice = input.nextInt();

            // Menu-driven program
            switch (choice){
                case 1:
                    System.out.println("Enter the element which you want to ADD.....");
                    int value = input.nextInt();
                    LLF.addNode(value);
                    break;

                case 2:
                    System.out.println("Element removed successfully.....");
                    int valueToRemove = input.nextInt();
                    LLF.removeNode(valueToRemove);
                    break;

                case 3:
                    System.out.println("Elements in linked list.....");
                    LLF.displayElements();
                    break;

                case 4:
                    System.out.println("Exiting.....");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid.....choose a valid operation");
            }
        }
    }
}
