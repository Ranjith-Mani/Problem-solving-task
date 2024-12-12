package Day1;

import java.util.Scanner;

public class SumOfDigitsIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Convert the number to positive if it's negative
        number = Math.abs(number);

        // Calculate the sum of digits
        int sum = 0;
        while (number > 0) {
            sum += number % 10;  // Add the last digit to sum
            number /= 10;        // Remove the last digit
        }

        // Display the result
        System.out.println("The sum of the digits is: " + sum);
    }
}

