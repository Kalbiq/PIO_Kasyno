package Craps;

import java.util.Arrays;

public class BetAceyDeucey extends Bet {
    int multiplier = 16;
    String name = "Acey Deucey";
    String description = "Bet on 3";

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        return sumDice == 3;
    }
}
