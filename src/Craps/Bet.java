package Craps;

import java.util.Arrays;

public class Bet {
    private final String name;
    private int[] numbers;
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

    public String getDescription() {
        return "Stawiasz na sumę oczek:\n" + Arrays.toString(numbers).replace("[", "")
                .replace("]", "").replace(",", " lub") +
                "\nKurs = " + multiplier;
    }

    public boolean check(int[] dice) {
        int sumDice = Arrays.stream(dice).sum();
        for (int number : numbers) {
            if (sumDice == number) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
