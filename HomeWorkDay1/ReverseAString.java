package HomeWorkDay1;

import java.util.Scanner;

public class ReverseAString {
    public static void main(String[] args) {

        // Initializing Variables
        String original;
        String rev = " ";

        // Implementing Scanner Class To Take An Input From User
        System.out.print("Enter A String : ");
        Scanner input = new Scanner(System.in);
        original = input.nextLine();

        // Logics
       /* // Customized one
        int len = original.length();
        for (int i = len - 1; i >= 0 ; i--) {
            rev = rev + original.charAt(i);
        }*/

        // Inbuilt one
        StringBuilder sb = new StringBuilder(original);
        rev = sb.reverse().toString();

        System.out.println("Original String : " + original);
        System.out.println("Reversed String : " + rev);
    }
}
