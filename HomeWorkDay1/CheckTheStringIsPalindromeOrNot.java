package HomeWorkDay1;

import java.util.Scanner;

public class CheckTheStringIsPalindromeOrNot {
    public static void main(String[] args) {
        String str;
        int isNotAPalindrome = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter A String : ");
        str = input.nextLine();

        int i = 0;
        int j = str.length() - 1;

        while ( i <= j ){
            if(str.charAt(i) != str.charAt(j)){
                isNotAPalindrome = 1;
                break;
            }
            i++;
            j--;
        }

        if(isNotAPalindrome != 1){
            System.out.println(str + " is a palindrome. ");
        }else{
            System.out.println(str + " is not a palindrome. ");
        }
    }
}
