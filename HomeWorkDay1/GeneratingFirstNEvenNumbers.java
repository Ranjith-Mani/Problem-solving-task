package HomeWorkDay1;

import java.util.Scanner;

public class GeneratingFirstNEvenNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter An Integer : ");
        int num = input.nextInt();

        System.out.println("Even Numbers in the range of " + num + ".");
        for (int i = 0; i <= num ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
