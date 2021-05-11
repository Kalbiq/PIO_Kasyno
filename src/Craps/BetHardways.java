package Craps;

public class BetHardways extends Bet {
    public BetHardways(String name, int multiplier) {
        super(name, multiplier);
    }

    @Override
    public String getDescription() {
        return "Stawiasz na podwójne wyrzucenie:\n2 lub 3 lub 4 lub 5\nKurs = " + multiplier;
    }

    @Override
    public boolean check(int[] dice) {
        return dice[0] == dice[1] && dice[0] != 1 && dice[0] != 6;
    }
}
