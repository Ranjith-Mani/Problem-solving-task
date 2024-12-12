package Day4;

import java.util.Scanner;

public class RatMaze {
    //Size of a maze
    static int N;

    public static void main(String[] args) {
        // Implementing scanner class to get input from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of a maze : ");
        N = input.nextInt();

        // Implementing 2D array to create a maze
        int[][] maze  = new int[N][N];

        // To read elements in array
        System.out.println();
        System.out.println("Enter the matrics to create a maze : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = input.nextInt();
            }
        }

        // Implementing 2D array for solution matrics
        int[][] solution = new int[N][N];

        if (solutionMaze(maze,solution,0,0)){
            printSolution(solution);
        }else{
            System.out.println("No paths are available to this matrics !");
        }
    }

    private static void printSolution(int[][] solution) {
        // To print the solution
        System.out.println("Your required solution matrics : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean solutionMaze(int[][] maze, int[][] solution, int x, int y) {
        // If the rat reached the destination
        if (x == N-1 && y == N-1){
            solution[x][y] = 1;
            return true;
        }

        // Check if the rat chosen path is safe or not
        if(chosenPathIsSafe(maze, x, y)){
            // Represent safe path
            solution[x][y] = 1;

            // Move right recursively
            if (solutionMaze(maze, solution, x,y+1)){
                return true;
            }

            // Move down recursively
            if (solutionMaze(maze, solution, x+1, y)){
                return true;
            }

            // Represent blocked path
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    private static boolean chosenPathIsSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }
}
