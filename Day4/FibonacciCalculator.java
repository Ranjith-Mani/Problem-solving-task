package Day4;

import java.util.Scanner;

public class FibonacciCalculator {

    // Recursive method to calculate Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of terms from the user
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int terms = scanner.nextInt();

        System.out.println("Fibonacci sequence:");
        for (int i = 0; i < terms; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}

