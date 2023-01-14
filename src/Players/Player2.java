/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Game.Cell;
import java.util.Stack;
/**
 *
 * @author Smart Lap
 */
public class Player2 extends Player{
    public static Stack<Cell> plays;

    public Player2(String name, int color) {
        super(name,color);
        plays = new Stack<Cell>();
    }
    public void winnerPlayer() {
        System.out.printf("%s is Winner !(^_^)!%n",name);
    }
}
