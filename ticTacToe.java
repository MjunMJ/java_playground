//need to change way to calculate win. using numbers leads to wrong checks like when there are 4 numbers

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
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
            ArrayList<Integer> playerInputsX = playerPrompts("X");
            inputValues(gameBoard, playerInputsX.get(0), playerInputsX.get(1), "X");
            print(gameBoard);
            winnerFound = checkAnswers(gameBoard, "X");
            if (winnerFound) {
                winner.replace(0, winner.length(),"X");
                System.out.println("winner is X");
                break;
            }

            //Play Y turn
            ArrayList<Integer> playerInputsY = playerPrompts("Y");
            inputValues(gameBoard, playerInputsY.get(0), playerInputsY.get(1), "Y");
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
        String divider = "\s".repeat(5)+"|";
        for (String[] row:gameBoard){
            for (String square:row){
                System.out.print(square);
                System.out.print(divider);
            }
            System.out.println(" ");
            System.out.println("-".repeat(18));
        }
        System.out.println();//add line spacing
    }//end print

    public static ArrayList<Integer> playerPrompts(String playerName){
        ArrayList<Integer> playerInputs = new ArrayList<>(Collections.nCopies(2,0));
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Player "+playerName+ "row: ");
        int xPosition = keyboard.nextInt();
        playerInputs.set(0, xPosition);
        System.out.print("Player "+playerName+ "col: ");
        int yPosition = keyboard.nextInt();
        playerInputs.set(1,yPosition);

        return playerInputs;
    }//end player prompts

    public static String[][] inputValues(String[][] gameBoard, int xPosition, int yPostition, String userInput){
        gameBoard[yPostition-1][xPosition-1]=userInput;

        return gameBoard;
    }//end input Values

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
