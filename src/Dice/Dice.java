package Dice;

public class Dice {
    int score;
    int[] dice = {0, 0, 0, 0, 0, 0};

    public Dice() {
        this.score = 0;
    }

    public void rollDice() {
        int roll;

        for(int i = 0; i < 6; i++){
            roll = (int)Math.floor(Math.random() * (7 - 1)) + 1;
            this.dice[i] = roll;
        }
    }

    public boolean checkIfWin() {
        return false;
    }
}