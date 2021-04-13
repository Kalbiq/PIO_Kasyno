package Craps;

import java.util.Arrays;

public class BetHardways extends Bet {
    int multiplier = 8;
    String name = "Hardways";
    String description = "Bet on 2+2, 3+3, 4+4, 5+5";

    @Override
    public boolean check(int[] dice) {
        return dice[0] == dice[1] && dice[0] != 1 && dice[0] != 6;
    }
}
