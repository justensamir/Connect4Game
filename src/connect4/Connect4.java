/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;
import Game.GameBoard;
import Game.WinChecker;
import Players.Player1;
import Players.Player2;
import java.util.*;
/**
 *
 * @author Smart Lap
 */
public class Connect4 {

    public static void displayGameBoard(int board[][], int rows, int cols){
        System.out.println("  1   2   3   4   5   6   7");
        for(int i=0;i<rows;i++){
            System.out.println("-----------------------------");
            for(int j=0;j<cols;j++)
                System.out.print("| "+board[i][j]+" ");
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
    
    public static void run(){
        final int numOfPlayerOne = 1, numOfPlayerTwo = 2;
        GameBoard game = new GameBoard();
        Scanner scan = new Scanner(System.in);
        WinChecker winChecker = new WinChecker(game.getRows(), game.getCols());
        System.out.print("Player 1 Name: ");
        String player1Name = scan.nextLine();
        System.out.print("Player 2 Name: ");
        String player2Name = scan.nextLine();
        Player1 player1 = new Player1(player1Name, numOfPlayerOne);
        Player2 player2 = new Player2(player2Name, numOfPlayerTwo);
        displayGameBoard(game.getBoard(), game.getRows(), game.getCols());
        while(true){
            int whoIsPlay = game.getNextPlayer();
            switch(whoIsPlay){
                case 1:
                    System.out.printf("%s can play ^_^ Your Number is %d \n",player1Name, whoIsPlay);
                    break;
                case 2: 
                    System.out.printf("%s can play ^_^ Your Number is %d \n",player2Name, whoIsPlay);
                    break;
            }
            System.out.print("Choose Column To Play: ");
            int col = scan.nextInt();
            if(col==-1){
                if(!Player1.plays.empty()) {
                    game.undo();
                    displayGameBoard(game.getBoard(), game.getRows(), game.getCols());
                }
                else {
                    System.out.println("No Moves To Undo !!!");
                }
                continue;
            }
            game.setOnBoard(col-1);
            displayGameBoard(game.getBoard(), game.getRows(), game.getCols());
            winChecker.setBoard(game.getBoard());
            winChecker.setNextPlayer(game.getNextPlayer());
            int winner = winChecker.checkWinner();
       
            if(winner==1){
                player1.setWinner(true);
                break;
            }
            else if(winner==2){
                player2.setWinner(true);
                break;
            }
            else if(winner==-1)
                break;
        }
        if(player1.isWinner())
            player1.winnerPlayer();
        else if(player2.isWinner())
            player2.winnerPlayer();
        else
            player1.draw();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        run();
    }
    
}
