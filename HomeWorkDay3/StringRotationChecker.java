package HomeWorkDay3;

import java.util.Scanner;

public class StringRotationChecker {
    public static void main(String[] args) {

        // Implementing Scanner class to get input form the user
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first string : ");
        String str1 = input.nextLine();

        System.out.println("Enter the second string : ");
        String str2 = input.nextLine();

        if (isRotate(str1,str2)){
            System.out.println(str2 + " is the rotation of " + str1);
        }else {
            System.out.println(str2 + " is NOT a rotation of " + str1);
        }
    }

    // Implementing isRotate method
    private static boolean isRotate(String str1, String str2) {
        if (str1.length() == str2.length() && !str1.isEmpty()){
            String concatenated = str1 + str2;
            return concatenated.contains(str2);
        }
        return false;
    }
}
