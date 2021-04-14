package Craps;

import java.util.Arrays;

public class Bet {
    protected final String name;
    protected int[] numbers;
    protected final int multiplier;

    public Bet(String name, int multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public Bet(String name, int[] numbers, int multiplier) {
        this.name = name;
        this.numbers = numbers;
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public String description() {
        return name + " (bet on " + Arrays.toString(numbers) + ")" +
                ", multiplier = " + multiplier;
    }

    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        for (int number:numbers) {
            if(sumDice == number) return true;
        }
        return false;
    }

}
