package Craps;

import java.util.Arrays;

public class BetSeven extends Bet {
    int multiplier = 5;
    String name = "Seven";
    String description = "Bet on 7";

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        return sumDice == 7;
    }
}
