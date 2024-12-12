package Day3;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {

        // Implementing Scanner class to get an input from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first string : ");
        String str1 = input.nextLine();
        System.out.println("Enter the second string : ");
        String str2 = input.nextLine();

        // To print the result
        if(anagramChecker(str1,str2)){
            System.out.println("your string is anagram!");
        }else{
            System.out.println("your string is NOT an anagram!");
        }
    }

    private static boolean anagramChecker(String str1, String str2) {

        // To check the length of the string
        if (str1.length() != str2.length()){
            return false;
        }

        // To implement sorting of the strings
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // To sort the strings
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // To return result if the both are equals
        return Arrays.equals(arr1,arr2);
    }
}
