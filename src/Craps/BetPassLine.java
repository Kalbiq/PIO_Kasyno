package Craps;

import java.util.Arrays;

public class BetPassLine extends Bet {
    int multiplier = 1;
    String name = "Pass Line";
    String description = "Bet on 7 and 11";

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();

        return sumDice == 7 || sumDice == 11;
    }
}
