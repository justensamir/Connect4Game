/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import java.util.*;
import Game.Cell;
import Players.*;

/**
 *
 * @author Smart Lap
 */
public class GameBoard {
    Stack<Cell> plays[];
    final int rows, cols;
    final int color1,color2,empty;
    int nextPlayer;
    int [][] board;
    
    public GameBoard() {
        rows=6; 
        cols=7;
        empty=0;
        color1=1; 
        color2=2; 
        nextPlayer = color1;
        board = new int[rows][cols];
        plays = new Stack[cols];
        initialize();
    }
    
    void initialize() {
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                board[i][j] = 0;
        
        for(int i=0;i<cols;i++)
            plays[i] = new Stack<Cell>();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
    
    Cell getLastPlayInCol(int col) {
        if(plays[col].empty()) {
            Cell cell = new Cell(rows,col);
            return cell;
        }
        return plays[col].lastElement();
    }
    
    public void setOnBoard(int col) {
        Cell fullCell = new Cell();
        fullCell = getLastPlayInCol(col);
        Cell currentCell = new Cell();
        if (!canSetInCol(fullCell))
            return;
        
        if(getNextPlayer()==color1){
            currentCell.x = fullCell.x-1;
            currentCell.y = fullCell.y;
            board[currentCell.x][currentCell.y] = color1;
            Player1.plays.add(currentCell);
            plays[col].add(currentCell);
            setNextPlayer(color2);
        }
        else{
            currentCell.x = fullCell.x-1;
            currentCell.y = fullCell.y;
            board[currentCell.x][currentCell.y] = color2;
            Player2.plays.add(currentCell);
            plays[col].add(currentCell);
            setNextPlayer(color1);
        }
    }
    
    boolean canSetInCol(Cell lastCell) {
        if(lastCell.x == 0){
            System.out.println("Column is full !!");
            return false;
        }
        return true;
    }
    
    public void undo() {
        if (getNextPlayer()==color2 && !Player1.plays.empty()) {
            Cell cell = Player1.plays.lastElement();
            plays[cell.y].pop();
            Player1.plays.pop();
            board[cell.x][cell.y] = empty;
            setNextPlayer(color1);
        }
        else if (getNextPlayer()==color1 && !Player2.plays.empty()) {
            Cell cell = Player2.plays.lastElement();
            plays[cell.y].pop();
            Player2.plays.pop();
            board[cell.x][cell.y] = empty;
            setNextPlayer(color2);
        }
    }
      
}
