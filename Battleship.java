package arrays;

import java.util.*;

public class Battleship {

    private static final char EMPTY = '.';
    private static final char SHIP = 'S';
    private static final char HIT = '*';
    private static final char MISS = '0';

    private static final String[] PLAYER_NAMES = { "Player 1", "Player 2" };
    private static int numberOfRow;  // Number of rows on the board
    private static int numberOfCol;  // Number of columns on the board

    public static void main(String[] args) {
        // Implementing the Battleship game

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Battleship game!");

        do {
            // Get the number of rows and columns from the user.
            System.out.print("Enter the number of rows: ");
            numberOfRow = scan.nextInt();

            System.out.print("Enter the number of columns: ");
            numberOfCol = scan.nextInt();

            if (numberOfRow <= 0 || numberOfCol <= 0) {
                System.out.println("Please enter positive values.");
            }
        } while (numberOfRow <= 0 || numberOfCol <= 0);

        char[][] playerBoards[] = new char[2][numberOfRow][numberOfCol];

        // Initialize player boards with empty cells
        for (char[][] board : playerBoards) {
            for (char[] row : board) {
                Arrays.fill(row, EMPTY);
            }
        }

        // Show the initial boards
        showPlayerBoards(playerBoards);

        // Place ships for each player
        for (int player = 0; player < 2; player++) {
            placeShips(playerBoards[player], scan, player);
        }

        // Determine which player will start the game.
        int currentPlayer = new Random().nextInt(2);

        boolean theGameContinues = true;

        while (theGameContinues) {
            System.out.println("Next player: " + PLAYER_NAMES[currentPlayer]);
            showPlayerBoards(playerBoards);

            int[] guess = getGuess(scan);

            boolean hit = evaluateTheGuess(playerBoards[(currentPlayer + 1) % 2], guess[0], guess[1]);

            if (hit) {
                System.out.println("You hit!");
            } else {
                System.out.println("You missed!");
            }

            if (gameOver(playerBoards)) {
                theGameContinues = false;
                System.out.println(PLAYER_NAMES[currentPlayer] + " won the game!");
                showPlayerBoards(playerBoards);
            }
            currentPlayer = (currentPlayer + 1) % 2;
        }
        scan.close();
    }

    private static boolean gameOver(char[][][] playerBoards) {
        return playerLost(playerBoards[0]) || playerLost(playerBoards[1]);
    }

    private static boolean playerLost(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean evaluateTheGuess(char[][] opponentBoard, int row, int col) {
        if (opponentBoard[row - 1][col - 1] == SHIP) {
            opponentBoard[row - 1][col - 1] = HIT;
            return true; // The ship was hit.
        } else {
            opponentBoard[row - 1][col - 1] = MISS;
            return false; // The ship was not hit.
        }
    }

    private static int[] getGuess(Scanner scan) {
        int[] guess = new int[2];

        System.out.print("Enter row (A-" + (char)('A' + numberOfRow - 1) + "): ");
        String rowInput = scan.next().toLowerCase(); // Convert to lowercase
        guess[0] = rowInput.charAt(0) - 'a' + 1;

        System.out.print("Enter column (1-" + numberOfCol + "): ");
        guess[1] = scan.nextInt();

        return guess;
    }

    private static void placeShips(char[][] board, Scanner scan, int player) {
        System.out.println(PLAYER_NAMES[player] + ", place your ships");

        for (int ship = 0; ship < 2; ship++) {
            System.out.println("Ship " + (ship + 1));
            int row, col;
            do {
                System.out.print("Enter row (A-" + (char)('A' + numberOfRow - 1) + "): ");
                String rowInput = scan.next().toLowerCase(); // Convert to lowercase
                row = rowInput.charAt(0) - 'a' + 1;

                System.out.print("Enter column (1-" + numberOfCol + "): ");
                col = scan.nextInt();

                if (row < 1 || row > numberOfRow || col < 1 || col > numberOfCol) {
                    System.out.println("Invalid row or column. Please try again.");
                } else if (board[row - 1][col - 1] == SHIP) {
                    System.out.println("You can't place two ships in the same location. Try again.");
                }
            } while (row < 1 || row > numberOfRow || col < 1 || col > numberOfCol || board[row - 1][col - 1] == SHIP);

            // Use the letter 'S' to represent ships on the board.
            board[row - 1][col - 1] = SHIP;
        }
    }

    private static void showPlayerBoards(char[][][] playerBoards) {
        System.out.println("   Player 1's Board     Player 2's Board");

        int numberOfRow = playerBoards[0].length;
        int numberOfCol = playerBoards[0][0].length;

        // Print the header row
        System.out.print("   ");
        for (int i = 1; i <= numberOfCol; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print("      ");
        for (int i = 1; i <= numberOfCol; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int i = 0; i < numberOfRow; i++) {
            char letter = (char) ('A' + i); // Convert row letter to uppercase
            System.out.print(" " + letter + " ");
            for (char[][] board : playerBoards) {
                for (int j = 0; j < numberOfCol; j++) {
                    System.out.print(" " + board[i][j] + " ");
                }
                System.out.print("      ");
            }
            System.out.println();
        }
    }
}