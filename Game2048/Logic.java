import java.util.*;

/*
* @filename - Logic.java
* @description - Core logic for the 2048 console game.
*    This class contains the core logic for the 2048 game.
*    
*    How movement works:
*     - The game grid is a 4x4 matrix. All moves (up, down, left, right)
*       are built from the basic "move left" operation.
*    
*     - Moving left:
*         1. All non-zero tiles are compressed to the left (using compress()).
*         2. Adjacent tiles with the same value are merged (using merge()).
*         3. The result is compressed again to fill any new gaps.
*    
*     - Moving right:
*         We reverse the grid, perform a left move, then reverse back.
*    
*     - Moving up:
*         We transpose the grid (rows ↔ columns), perform a left move,
*         then transpose back.
*    
*     - Moving down:
*         We transpose, perform a right move, and transpose back.
*    
*    This way, we only implement the "move left" logic once and reuse it
*    to handle all directions.
* @author - Aman Jeet Singh
*/

public class Logic {
    // as the methord name suggests, it starts the game and returns the initial game board
    public static int[][] startGame() {
        int[][] mat = new int[4][4];

        System.out.println("Commands:");
        System.out.println("W / w → Up");
        System.out.println("S / s → Down");
        System.out.println("A / a → Left");
        System.out.println("D / d → Right");

        addNew2(mat);
        return mat;
    }

    // this methord is used to find an empty cell in the game board
    private static int[] findEmpty(int[][] mat) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mat[i][j] == 0) return new int[]{i, j};
            }
        }
        return null;
    }

    // this methord adds a new '2' tile to a random empty cell in the game board
    public static void addNew2(int[][] mat) {
        Random rand = new Random();

        boolean full = true;
        for (int[] row : mat) {
            for (int val : row) {
                if (val == 0) full = false;
            }
        }
        if (full) return;

        // Try up to 30 times to find a random empty cell
        int tries = 0;
        while (tries < 30) {
            int r = rand.nextInt(4);
            int c = rand.nextInt(4);
            if (mat[r][c] == 0) {
                mat[r][c] = 2;
                return;
            }
            tries++;
        }

        // If no empty cell found, use the first available empty cell
        int[] empty = findEmpty(mat);
        if (empty != null) mat[empty[0]][empty[1]] = 2;
    }

    // this methord checks the current state of the game: WON, LOST, or GAME NOT OVER
    public static String getCurrentState(int[][] mat) {
        // Check win
        for (int[] row : mat) {
            for (int val : row) {
                if (val == 2048) return "WON";
            }
        }

        // Check any empty cell
        for (int[] row : mat) {
            for (int val : row) {
                if (val == 0) return "GAME NOT OVER";
            }
        }

        // Check possible merges
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[i][j] == mat[i + 1][j] || mat[i][j] == mat[i][j + 1])
                    return "GAME NOT OVER";
            }
        }
        for (int j = 0; j < 3; j++) {
            if (mat[3][j] == mat[3][j + 1]) return "GAME NOT OVER";
        }
        for (int i = 0; i < 3; i++) {
            if (mat[i][3] == mat[i + 1][3]) return "GAME NOT OVER";
        }

        return "LOST";
    }

    // the following methods are helper methods for moving and merging tiles on the game board

    public static Object[] compress(int[][] mat) {
        int[][] newMat = new int[4][4];
        boolean changed = false;

        for (int i = 0; i < 4; i++) {
            int pos = 0;
            for (int j = 0; j < 4; j++) {
                if (mat[i][j] != 0) {
                    newMat[i][pos] = mat[i][j];
                    if (j != pos) changed = true;
                    pos++;
                }
            }
        }
        return new Object[]{newMat, changed};
    }

    // merges adjacent tiles with the same value
    public static Object[] merge(int[][] mat) {
        boolean changed = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[i][j] == mat[i][j + 1] && mat[i][j] != 0) {
                    mat[i][j] *= 2;
                    mat[i][j + 1] = 0;
                    changed = true;
                }
            }
        }
        return new Object[]{mat, changed};
    }

    // reverses the order of elements in each row of the matrix
    public static int[][] reverse(int[][] mat) {
        int[][] newMat = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newMat[i][j] = mat[i][3 - j];
            }
        }
        return newMat;
    }

    // transposes the matrix (rows become columns and vice versa)
    public static int[][] transpose(int[][] mat) {
        int[][] newMat = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newMat[i][j] = mat[j][i];
            }
        }
        return newMat;
    }

    // --- Movement logic ---
    // Each move method returns an Object array containing the new grid and a boolean indicating if any changes were made
    public static Object[] moveLeft(int[][] grid) {
        Object[] comp = compress(grid);
        int[][] newGrid = (int[][]) comp[0];
        boolean changed1 = (boolean) comp[1];

        Object[] mergeResult = merge(newGrid);
        newGrid = (int[][]) mergeResult[0];
        boolean changed2 = (boolean) mergeResult[1];

        Object[] comp2 = compress(newGrid);
        newGrid = (int[][]) comp2[0];

        boolean changed = changed1 || changed2;
        return new Object[]{newGrid, changed};
    }

    // Move right by reversing, moving left, and reversing again
    public static Object[] moveRight(int[][] grid) {
        int[][] newGrid = reverse(grid);
        Object[] move = moveLeft(newGrid);
        newGrid = reverse((int[][]) move[0]);
        return new Object[]{newGrid, (boolean) move[1]};
    }

    // Move up by transposing, moving left, and transposing again
    public static Object[] moveUp(int[][] grid) {
        int[][] newGrid = transpose(grid);
        Object[] move = moveLeft(newGrid);
        newGrid = transpose((int[][]) move[0]);
        return new Object[]{newGrid, (boolean) move[1]};
    }

    // Move down by transposing, moving right, and transposing again
    public static Object[] moveDown(int[][] grid) {
        int[][] newGrid = transpose(grid);
        Object[] move = moveRight(newGrid);
        newGrid = transpose((int[][]) move[0]);
        return new Object[]{newGrid, (boolean) move[1]};
    }

    // prints the current state of the game board
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}
