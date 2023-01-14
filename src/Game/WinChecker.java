/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Smart Lap
 */
public class WinChecker{
    final int player1, player2, empty;
    final int rows, cols;
    final int gameWinning, drowing;
    int checkWin;
    int nextPlayer;
    int [][]board;
    
    public WinChecker(int rows,int cols){
        player1=1;
        player2=2;
        empty=0;
        gameWinning = 4;
        drowing = -1;
        checkWin=0;
        this.rows=rows;
        this.cols=cols;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    
    public int checkWinner() {
        if ( nextPlayer==player2 && (checkHorizontal(player1) || checkVertical(player1) || checkDiagonal(player1)) ) 
            return player1;
        else if ( nextPlayer==player1 && (checkHorizontal(player2) || checkVertical(player2) || checkDiagonal(player2)) ) 
            return player2;
        else if(draw())
            return drowing;
        
        return 0;
    }
    
    boolean draw(){
        int firstRow = 0; 
        for(int i=0;i<cols;i++)
            if(board[firstRow][i] == empty)
                return false;
        return true;
    } 
     
    boolean checkHorizontal(int player) {
        
        for(int i=rows-1;i>=0;i--){
            for(int j=0;j<cols;j++){
                if(board[i][j]==player) {
                    checkWin++;
                    if(checkWin==gameWinning)
                        return true;
                }
                else
                    checkWin=empty;
            }
        }
        return false;
    }
    
    boolean checkVertical(int player) {
        for(int j=cols-1;j>=0;j--){
            for(int i=0;i<rows;i++){
                if(board[i][j]==player) {
                    checkWin++;
                    if(checkWin==gameWinning)
                        return true;
                }
                else
                    checkWin=empty;
            }
        }
        return false;
    }
    
    boolean checkDiagonal(int player) {
        
        if(leftDiagonals(player))
            return true;
        else if(rightDiagonals(player))
            return true;
        return false;
    }
    
    boolean leftDiagonals(int player){
        if( leftUpDiagonal(0,player)||
            leftUpDiagonal(1,player)||
            leftUpDiagonal(2,player)||
            leftUpDiagonal(3,player)||
            leftDownDiagonal(1,player)||
            leftDownDiagonal(2,player))
            return true;
        return false;
    }
    
    boolean leftUpDiagonal(int j, int player){
        for(int i=0;i<rows;i++){
            if(i+j >= cols)
                break;
            if(board[i][i+j]==player) {
                checkWin++;
                if(checkWin==gameWinning)
                    return true;
            }
            else
                checkWin=empty;
        }
        return false;
    }
    
    boolean leftDownDiagonal(int j, int player){
        for(int i=0;i<rows;i++){
            if(i+j >= rows)
                break;
            if(board[i+j][i]==player) {
                    checkWin++;
                    if(checkWin==gameWinning)
                        return true;
                }
                else
                    checkWin=empty;
        }
        return false;
    }
    
    boolean rightDiagonals(int player){
        if( rightUpDiagonal(3,player)||
            rightUpDiagonal(4,player)||
            rightUpDiagonal(5,player)||
            rightUpDiagonal(6,player)||
            rightDownDiagonal(7,player)||
            rightDownDiagonal(8,player))
            return true;
        return false;
    }
    
    boolean rightUpDiagonal(int j, int player){
        for(int i=0;i<rows;i++){
            if(j-i<0)
                break;
            if(board[i][j-i]==player) {
                    checkWin++;
                    if(checkWin==gameWinning)
                        return true;
                }
                else
                    checkWin=empty;
        }
        return false;
    }
    
    boolean rightDownDiagonal(int j, int player){
        int initi;
        if(j==7)
            initi = 1;
        else
            initi = 2;
        
        for(int i=initi;i<rows;i++){
            if(j-i<0)
                break;
            if(board[i][j-i]==player) {
                    checkWin++;
                    if(checkWin==gameWinning)
                        return true;
                }
                else
                    checkWin=empty;
        }
        return false;
    }
    
}
