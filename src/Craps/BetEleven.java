package Craps;

import java.util.Arrays;

public class BetEleven extends Bet {
    int multiplier = 6;
    String name = "Eleven";
    String description = "Bet on 11";

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        return sumDice == 11;
    }
}
