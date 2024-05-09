import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

public class ticTacToe {
    String [][] gameBoard;
    static final char [][] matchBoard ={{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    static int sumX;
    static int sumY;

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

        while (true){
            //Play X turn
            ArrayList<Integer> playerInputsX = playerPrompts("X");
            inputValues(gameBoard, playerInputsX.get(0), playerInputsX.get(1), "X");
            print(gameBoard);
            int tallyX = checkAnswers(gameBoard, "X");
            System.out.println(tallyX);
            if(tallyX== 123|| tallyX==456 || tallyX == 789 || tallyX == 147|| tallyX == 258 || tallyX==369 || tallyX==159 ||tallyX==357){
                System.out.println("X has won!");
                System.out.println("<<<<<Game ended>>>>>");
                break;
            }

            //Play Y turn
            ArrayList<Integer> playerInputsY = playerPrompts("Y");
            inputValues(gameBoard, playerInputsY.get(0), playerInputsY.get(1), "Y");
            print(gameBoard);
            int tallyY = checkAnswers(gameBoard, "Y");
            System.out.println(tallyY);
            if(tallyY== 123|| tallyY==456 || tallyY == 789 || tallyY == 147|| tallyY == 258 || tallyY==369 || tallyY==159 ||tallyY==357){
                System.out.println("Y has won!");
                System.out.println("<<<<<Game ended>>>>>");
                break;
            }

        }


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

    public static int checkAnswers(String[][] gameBoard, String player){
        StringBuilder sum = new StringBuilder();
        for (int i=0; i<gameBoard.length; i++){
            for (int j=0; j<gameBoard[i].length;j++){
                int xPosiiton = j;
                int yPosition = i;
                if (gameBoard[i][j].equals(player)){
                    sum.append(matchBoard[i][j]);
                }
            }
        }
        int tally = Integer.parseInt(sum.toString());

        return tally;
    }//check answer

}
