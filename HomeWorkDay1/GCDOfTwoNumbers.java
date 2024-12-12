package HomeWorkDay1;

import java.util.Scanner;

public class GCDOfTwoNumbers {
    public static void main(String[] args) {

        int gcd = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Two Integers : ");
        int a = input.nextInt();
        int b = input.nextInt();

        for (int i = 1; i <= a ; i++) {
            if(a%i == 0 && b%i == 0){
                gcd = i;
            }
        }
        System.out.println("GCD of the given two numbers : " + gcd);
    }
}
