package Day7;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {

        // Implementing scanner class to get input from the user
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your parenthesis combination : ");
        String brackets = input.nextLine();

        // Implementing stack
        Stack<Character> st = new Stack<>();

        boolean isBalanced = true;

        for (char ch : brackets.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch); // Push opening brackets to stack
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // If closing bracket appears, check if stack is empty or top does not match
                if (st.isEmpty()) {
                    isBalanced = false; // Stack is empty but found closing bracket
                    break;
                }

                char top = st.pop(); // Pop the top element for comparison

                if (!((top == '(' && ch == ')') ||
                        (top == '{' && ch == '}') ||
                        (top == '[' && ch == ']'))) {
                    isBalanced = false; // Mismatched bracket pair
                    break;
                }
            }
        }

        // If stack is not empty after processing all characters, it's unbalanced
        if (!st.isEmpty()) {
            isBalanced = false;
        }

        // Output result based on balance status
        if (isBalanced) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced.");
        }
    }
}
