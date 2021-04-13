package Craps;

import java.util.Arrays;

public class BetCraps extends Bet {
    int multiplier = 8;
    String name = "Craps";
    String description = "Bet on 2,3 or 12";

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();

        return sumDice == 2 || sumDice == 3 || sumDice == 12;
    }
}