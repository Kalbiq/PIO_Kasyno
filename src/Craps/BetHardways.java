package Craps;

public class BetHardways extends Bet{
    public BetHardways(String name, int multiplier) {
        super(name, multiplier);
    }

    @Override
    public String description() {
        return name + " (bet on [2+2, 3+3, 4+4, 5+5]" + ")" +
                    ", multiplier = " + multiplier;
    }

    @Override
    public boolean check(int[] dice) {
        return dice[0] == dice[1] && dice[0] != 1 && dice[0] != 6;
    }
}
