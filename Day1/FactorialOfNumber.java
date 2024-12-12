package Day1;

import java.util.Scanner;

public class FactorialOfNumber {
    public static void main(String[] args) {
        // Initialization
        long fact = 1;

        // Getting An Input
        System.out.print("Enter An Integer : ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        // Logic
        if (num < 0){
            System.out.println("Negative Number Factorial Cannot be Defined....");
        }else{
            for (int i = 1; i <= num ; i++) {
                fact = fact * i;
            }
            System.out.println("Factorial Of This Number Is : " + fact);
        }
    }
}
