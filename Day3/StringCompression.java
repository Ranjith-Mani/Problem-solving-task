package Day3;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {

        // Implementing Scanner class to get an input from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = input.nextLine();

        // To print the result
        String result = compressedString(str);
        System.out.println("Your compressed string is : " + result);
    }

    private static String compressedString(String str) {
        // To check if the string is empty
        if(str.isEmpty()){
            return str;
        }

        // To compress the string
        StringBuilder compress = new StringBuilder();
        int count = 1;

        // Logic
        for (int i = 1; i <= str.length() ; i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i-1)){
                count ++;
            }else {
                compress.append(str.charAt(i-1)).append(count);
                count = 1;
            }
        }
        return compress.toString();
    }
}
