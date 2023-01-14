/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

/**
 *
 * @author Smart Lap
 */
public abstract class Player {
    String name;
    int color;
    boolean winner;
    
    public Player(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    
    public void draw() {
        System.out.println("Draw");
    }
    
    abstract void winnerPlayer();
}
