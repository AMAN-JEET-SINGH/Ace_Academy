import java.util.Scanner;

/**
* @filename - Main.java
* @description - Entry point for the 2048 console game.
*                Handles user inputs (W, A, S, D), updates the board using Logic class methods,
*                and manages the overall game flow until the game is over.
* @author - Aman Jeet Singh
*/

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Initialize game board
        int[][] mat = Logic.startGame();
        Logic.printMatrix(mat);

        while (true) {
            System.out.print("Press the command: ");
            String x = inputScanner.nextLine();

            boolean validMove = true;
            Object[] moveResult = null;

            // Handle movement input
            switch (x) {
                case "W":
                case "w":
                    moveResult = Logic.moveUp(mat);
                    break;
                case "S":
                case "s":
                    moveResult = Logic.moveDown(mat);
                    break;
                case "A":
                case "a":
                    moveResult = Logic.moveLeft(mat);
                    break;
                case "D":
                case "d":
                    moveResult = Logic.moveRight(mat);
                    break;
                default:
                    System.out.println("Invalid key! Use W, A, S, or D.");
                    validMove = false;
            }

            if (validMove && moveResult != null) {
                mat = (int[][]) moveResult[0];
                String status = Logic.getCurrentState(mat);
                System.out.println(status);

                if (status.equals("GAME NOT OVER")) {
                    Logic.addNew2(mat);
                } else {
                    Logic.printMatrix(mat);
                    break;
                }

                Logic.printMatrix(mat);
            }
        }

        inputScanner.close();
    }
}
