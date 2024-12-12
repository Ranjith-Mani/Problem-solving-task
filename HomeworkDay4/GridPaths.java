package HomeworkDay4;

import java.util.Scanner;

public class GridPaths {

    // Function to print all paths from top-left to bottom-right
    public static void findPaths(int m, int n, String path) {
        // Base case: if we reach bottom-right corner, print the path
        if (m == 1 && n == 1) {
            System.out.println(path);
            return;
        }

        // If moving right is possible
        if (n > 1) {
            findPaths(m, n - 1, path + "R"); // R for right move
        }

        // If moving down is possible
        if (m > 1) {
            findPaths(m - 1, n, path + "D"); // D for down move
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the grid dimensions
        System.out.print("Enter the number of rows: ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int n = scanner.nextInt();

        // Calling the findPaths function to print all paths
        System.out.println("All possible paths from top-left to bottom-right are:");
        findPaths(m, n, "");
    }
}

