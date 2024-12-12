package Day1;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {

        // Initialization
        int first = 0;
        int second = 1;

        // Getting Input From User
        System.out.print("Enter An Integer : ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        // Logics
        if (num <= 0){
            System.out.println("Please Enter Positive Integer...");
        }else {
            for (int i = 0; i < num; i++) {
                System.out.print(first + " ");
                int next = first + second;
                first = second;
                second = next;
            }
        }
    }
}
