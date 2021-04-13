package CrapsGame;

public interface Bet {
    boolean check(int[] dice);
    int multiplier();
    String name();
    String description();
}
