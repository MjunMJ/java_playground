import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ticTacToe {
    String [][] gameBoard;

    public ticTacToe(){
        this.gameBoard = new String[3][3];
        for (String[] row:gameBoard){
            for (int i=0; i< row.length;i++) {
                row[i] = "\s";
            }
        }
    }//end constructBoard

    public static void main(String[] args){
        ticTacToe newGame = new ticTacToe();
        String[][] gameBoard = newGame.gameBoard;

        //game starts
        System.out.println("Welcome to the game of tic tat toe!");
        print(gameBoard);

        boolean winnerFound;
        StringBuilder winner = new StringBuilder();

        do {
            //Play X turn
            playerPrompts("X", gameBoard);
            print(gameBoard);
            winnerFound = checkAnswers(gameBoard, "X");
            if (winnerFound) {
                winner.replace(0, winner.length(),"X");
                System.out.println("winner is X");
                break;
            }

            //Play Y turn
            playerPrompts("Y", gameBoard);
            print(gameBoard);
            winnerFound = checkAnswers(gameBoard, "Y");
            if (winnerFound) {
                winner.replace(0, winner.length(),"Y");
                System.out.println("winner is Y");
                break;
            }

        } while (!winnerFound);


    }//end main

    public static void print(String[][] gameBoard){
        String divider = "\s".repeat(4)+"|";
        for (int j=0; j<gameBoard.length;j++){
            if (j<2) {
                for (int i = 0; i < gameBoard[j].length; i++) {
                    if (i < 2) {
                        System.out.print(gameBoard[j][i]);
                        System.out.print(divider);
                    } else {
                        System.out.println(gameBoard[j][i]);
                    }
                }
                System.out.println("-".repeat(18));
            }//end of row 1 and 2
            else {
                for (int i = 0; i < gameBoard[j].length; i++) {
                    if (i < 2) {
                        System.out.print(gameBoard[j][i]);
                        System.out.print(divider);
                    } else {
                        System.out.println(gameBoard[j][i]);
                    }
                }
            } //end of rwo 3 with no bottom border
        }
        System.out.println();
    }//end print

    public static String[][] playerPrompts(String playerName, String[][] gameBoard){
        Scanner keyboard = new Scanner(System.in);
        int cellFull = 0;
        do {
            System.out.print("Player " + playerName + "row: ");
            int xPosition = keyboard.nextInt();
            System.out.print("Player " + playerName + "col: ");
            int yPosition = keyboard.nextInt();

            if (gameBoard[yPosition - 1][xPosition - 1].isBlank()) {
                gameBoard[yPosition - 1][xPosition - 1] = playerName;
                cellFull=1;
            } else {
                System.out.println("cell already occupied");
            }
        }while (cellFull==0);

        return gameBoard;
    }//end player prompts

    public static boolean checkAnswers(String[][] gameBoard, String player){
        boolean winnerFound = false;

        //horizontal rows
        if (gameBoard[0][0].equals(player) && gameBoard[0][1].equals(player) && gameBoard[0][2].equals(player)) {
            winnerFound = true;
        } else if (gameBoard[1][0].equals(player) && gameBoard[1][1].equals(player) && gameBoard[1][2].equals(player)) {
            winnerFound = true;
        } else if (gameBoard[2][0].equals(player) && gameBoard[2][1].equals(player) && gameBoard[2][2].equals(player)) {
            winnerFound = true;

        //verticla columns
        } else if (gameBoard[0][0].equals(player) && gameBoard[1][0].equals(player) && gameBoard[2][0].equals(player)) {
            winnerFound = true;
        } else if (gameBoard[0][1].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][1].equals(player)) {
            winnerFound = true;
        } else if (gameBoard[0][2].equals(player) && gameBoard[1][2].equals(player) && gameBoard[2][2].equals(player)) {
            winnerFound = true;

        //diagonal cells
        } else if (gameBoard[0][0].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][2].equals(player)) {
            winnerFound = true;
        } else if (gameBoard[0][2].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][0].equals(player)) {
            winnerFound = true;
        }
        return winnerFound;
    }//check answer

}
