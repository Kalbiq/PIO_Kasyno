package Craps;

import java.util.Arrays;

public class BetDontPassLine extends Bet {
    int multiplier = 1;
    String name = "Don't Pass Line";
    String description = "Bet on 7 or 3";

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        return sumDice == 7 || sumDice == 3;
    }
}
