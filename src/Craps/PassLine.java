package Craps;

import java.util.Arrays;

public class PassLine extends Bet {
    String betName = "Pass Line";
    int multipier = 1;

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();

        return false;
    }
}
