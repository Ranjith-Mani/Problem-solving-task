package Day1;

import java.util.Scanner;

public class PrimeNumbers
{
    public static void main(String[] args) {

        // Initializing variable
        boolean isPrime = true;

        // To take an input from the user
        System.out.print("Enter an Integer : ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        // Logic
        if(num <= 1){
            isPrime = false;
        }else {
            for (int i = 2; i <= Math.sqrt(num) ; i++) {
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        if(isPrime){
            System.out.println(num + " is the Prime Number. ");
        }else {
            System.out.println(num + " is not a Prime Number. ");
        }
    }
}
