package HomeworkDay4;

import java.util.Scanner;

public class NQueens {

    // Function to print the solution board
    public static void printSolution(int board[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if a queen can be placed on board[row][col]
    // This checks for conflicts in the column, upper diagonal and lower diagonal
    public static boolean isSafe(int board[][], int row, int col, int N) {
        // Check this column on upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Solves the N-Queens problem using backtracking
    public static boolean solveNQueens(int board[][], int row, int N) {
        // If all queens are placed, return true
        if (row >= N) {
            return true;
        }

        // Consider this row and try placing this queen in all columns one by one
        for (int col = 0; col < N; col++) {
            // Check if queen can be placed on board[row][col]
            if (isSafe(board, row, col, N)) {
                // Place queen
                board[row][col] = 1;

                // Recur to place the next queen
                if (solveNQueens(board, row + 1, N)) {
                    return true;
                }

                // If placing queen in board[row][col] doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        // If the queen cannot be placed in any column in this row, return false
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for N (size of the board and number of queens)
        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();

        int board[][] = new int[N][N];

        // Try to solve the N-Queens problem
        if (solveNQueens(board, 0, N)) {
            printSolution(board, N);  // Print the solution if found
        } else {
            System.out.println("Solution does not exist.");
        }

        scanner.close();
    }
}

