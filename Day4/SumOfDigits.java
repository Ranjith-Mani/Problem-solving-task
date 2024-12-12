package Day4;

import java.util.Scanner;

public class SumOfDigits {

    // Recursive method to calculate the sum of digits
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Handle negative numbers
        number = Math.abs(number);

        // Calculate and display the sum of digits
        int sum = sumOfDigits(number);
        System.out.println("The sum of the digits is: " + sum);
    }
}

