package Day7;

import java.util.Scanner;

class StackArr{
    private int[] stack;
    private int top;
    private int capacity;

    public StackArr(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    // Insert element
    public void push (int value){
        if (top == capacity-1){
            System.out.println("Overflow!");
            return;
        }
        stack[++top] = value;
        System.out.println(value);
    }

    // Remove element
    public int pop (){
        if (top == -1){
            System.out.println("Underflow!");
            return -1;
        }
        int value = stack[top--];
        System.out.println(value);
        return value;
    }

    // peek element
    public void peek (){
        if (top == -1){
            System.out.println("Underflow!...Stack is empty");
        }
        System.out.println(stack[top]);
    }

    // Displaying elements
    public void displayElements (){
        if(top == -1) {
            System.out.println("Underflow!...Stack is empty");
            return;
        }
        for(int i=0;i<=top;i++) {
            System.out.println(stack[i]);
        }
        System.out.println();
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        // Implementing scanner class to get inputs from the user
        Scanner input = new Scanner(System.in);

        // To get the size of stack
        System.out.println("Enter the size of stack : ");
        int size = input.nextInt();

        // Implementing stack array
        StackArr stArr = new StackArr(size);

        // Logic
        while (true) {
            System.out.println("""
                    Choose your required operation : \

                     1-Push\

                     2-Pop\

                     3-peek\

                     4-display\

                     5-exit""");
            int options = input.nextInt();
            switch (options) {
                case 1:
                    System.out.println("Enter the element which you want to push : ");
                    int value = input.nextInt();
                    stArr.push(value);
                    break;

                case 2:
                    System.out.println("Element successfully popped  : ");
                    stArr.pop();
                    break;

                case 3:
                    System.out.println("Your required top element : ");
                    stArr.peek();
                    break;

                case 4:
                    System.out.println("Elements in stack : ");
                    stArr.displayElements();
                    break;

                case 5:
                    System.out.println("Exiting............");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid option!....choose valid option");
            }
        }
    }
}
