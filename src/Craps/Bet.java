package Craps;

public abstract class Bet {
    int multiplier;
    String description;
    String name;

    abstract boolean check(int[] dice);

    public int getMultiplier() {
        return multiplier;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
