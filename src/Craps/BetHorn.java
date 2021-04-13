package Craps;

import java.util.Arrays;

public class BetHorn extends Bet{
    int multiplier = 5;
    String name = "Horn";
    String description = "Bet on 2, 3, 11 or 12";

    @Override
    boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        return sumDice == 2 || sumDice == 3 || sumDice == 11 || sumDice == 12;
    }
}
