package Day4;

import java.util.Scanner;

public class StairsClimbUsingDp {
    public static void main(String[] args) {

        // To implement Scanner class for getting input from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of steps in staircase : ");
        int n = input.nextInt();

        // Implementing method
        int result = noOfPossibilitiesToClimbStairs(n);
        System.out.print("Your no.of.possibilities to climb the stairs : " + result);
    }

    private static int noOfPossibilitiesToClimbStairs(int n) {

        // checking n
        if (n == 0 || n== 1){
            return 1;
        }

        // to store the number of ways
        int[] ways = new int [n + 1];

        // fixed ways
        ways[0] = 1;
        ways[1] = 1;

        // logic
        for (int i = 2; i <= n ; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
}
