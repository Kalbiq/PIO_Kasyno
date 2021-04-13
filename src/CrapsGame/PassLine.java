package CrapsGame;

import java.util.Arrays;

public class PassLine implements Bet {

    @Override
    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();

        return sumDice == 7 || sumDice == 11;
    }

    @Override
    public int multiplier() {
        return 1;
    }

    @Override
    public String name() {
        return "Pass Line";
    }

    @Override
    public String description() {
        return "Bet on 7 and 11";
    }
}
