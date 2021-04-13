// zasady jbc to Yahtzee
// np. https://www.dicegamedepot.com/yahtzee-rules/

package Dice;


public class Dice {
    int[] dice = {0, 0, 0, 0, 0, 0};
    int reroll;

    // Yahtzee goals as on a standard score sheet (13)
    int[] goals;
    int score;

    public Dice() {
        this.score = 0;
        this.reroll = 2;
        this.goals = new int[13];
        for(int i = 0; i < 13; i++){
            this.goals[i] = -1;
        }
    }

    public void rollDice() {
        int roll;

        for(int i = 0; i < 6; i++){
            roll = (int)Math.floor(Math.random() * (7 - 1)) + 1;
            this.dice[i] = roll;
        }
        this.reroll = 2;
    }

    public void rollOneDice(int dice_num) {
        if(dice_num > 0 && dice_num < 7 && this.reroll > 0){
            this.dice[dice_num] = (int)Math.floor(Math.random() * (7 - 1)) + 1;
            this.reroll--;
        }
    }
}