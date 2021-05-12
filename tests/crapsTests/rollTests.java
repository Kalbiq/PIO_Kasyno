package crapsTests;

import Craps.GameLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class rollTests {
    @Test
    public void getDice_notRolled() {
        GameLogic gameLogic = new GameLogic();

        int d1 = gameLogic.getDie(0);
        int d2 = gameLogic.getDie(1);

        int[] dice = {d1, d2};
        int[] correct = {0, 0};

        assertArrayEquals(correct, dice);
    }
}
