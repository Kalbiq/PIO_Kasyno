package Dice;

import Dice.Dice;

public class TestDice {
    public static void main(String[] args){
        Dice dice_game = new Dice();
        int winc = 0;
        for(int i = 0; i < 10000; i++){
            dice_game.rollDice();
            if(dice_game.checkIfWin())
                winc++;
        }
        System.out.printf("%d\n", winc);
    }
}
