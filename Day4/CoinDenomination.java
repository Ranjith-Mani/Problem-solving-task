package Day4;

import java.util.Scanner;

public class CoinDenomination {
    public static void main(String[] args) {

        // To implement scanner class to get input from the user
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the required amount : ");
        int amt = input.nextInt();
        System.out.println("Enter the number of coins : ");
        int n = input.nextInt();

        // To implement coin denomination create an array
        System.out.println("Enter coin denominations : ");
        int[] coins = new int[n];

        // To traverse array
        for (int i = 0; i < n ; i++) {
            coins[i] = input.nextInt();
        }

        // Implementing method
        int result = noOfPossibleWaysToCount(amt,coins);
        System.out.println("Your number of possibilities : " + result);
    }

    private static int noOfPossibleWaysToCount(int amt, int[] coins) {
        // DP solution
        int[] dp = new int [amt + 1];
        dp[0] = 1; // only one way to make amt 0

        // Traverse to coins
        for (int coin : coins) {
            for (int i = coin; i <= amt ; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amt];
    }
}
