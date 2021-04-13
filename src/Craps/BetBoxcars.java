package Craps;

import java.util.Arrays;

public class BetBoxcars extends Bet{
    int multiplier = 30;
    String name = "Boxcars";
    String description = "Bet on 12 or 2";

    @Override
    boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        return sumDice == 2 || sumDice == 12;
    }
}
