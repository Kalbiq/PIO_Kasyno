package Craps;


public class Craps {
    int[] dice = {0, 0};
    int score;

    public Craps() {
        this.score = 0;
    }

    public void rollDices() {
        int roll;

        for(int i = 0; i < 2; i++){
            roll = (int)Math.floor(Math.random() * (7 - 1)) + 1;
            this.dice[i] = roll;
        }
    }
}