package Day3;

import java.util.Scanner;

public class StringSpaceReplacement {
    public static void main(String[] args) {

        // Implementing Scanner class to get an input from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = input.nextLine();

        String result = spaceReplacement(str);
        System.out.println("Your replaced string is : " + result);
    }

    private static String spaceReplacement(String str) {
        if (str.isEmpty() || str == null){
            return str;
        }

        StringBuilder replace = new StringBuilder();
        for (char ch : str.toCharArray()){
            if (ch == ' '){
                replace.append("20%");
            }else {
                replace.append(ch);
            }
        }
        return replace.toString();
    }
}
