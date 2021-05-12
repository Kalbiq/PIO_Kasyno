package crapsTests;

import Craps.Bet;
import Craps.BetHardways;
import Craps.GameLogic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class betTests {
    @Test
    public void getBets_correct() {
        GameLogic gameLogic = new GameLogic();
        boolean fault = false;
        List<Bet> betsRead;
        List<Bet> betsGiven = new ArrayList<>();

        Bet betBoxcars = new Bet("Boxcars", new int[]{2, 12}, 12);
        betsGiven.add(betBoxcars);
        Bet betAceyDeucey = new Bet("Acey Deucey", new int[]{3}, 9);
        betsGiven.add(betAceyDeucey);
        Bet betCraps = new Bet("Craps", new int[]{2, 3, 12}, 8);
        betsGiven.add(betCraps);
        BetHardways betHardways = new BetHardways("Hardways", 8);
        betsGiven.add(betHardways);
        Bet betEleven = new Bet("Eleven", new int[]{11}, 6);
        betsGiven.add(betEleven);
        Bet betHorn = new Bet("Horn", new int[]{2, 3, 11, 12}, 5);
        betsGiven.add(betHorn);
        Bet betSeven = new Bet("Seven", new int[]{7}, 5);
        betsGiven.add(betSeven);
        Bet betDontPassLine = new Bet("Don't Pass Line", new int[]{7, 3}, 1);
        betsGiven.add(betDontPassLine);
        Bet betPassLine = new Bet("Pass Line", new int[]{7, 11}, 1);
        betsGiven.add(betPassLine);

        betsRead = gameLogic.getBets();

        int i = 0;
        for (Bet bet : betsRead) {
            Bet betGiven = betsGiven.get(i);

            if (bet.getMultiplier() != betGiven.getMultiplier())
                fault = true;
            if (!bet.getDescription().equals(betGiven.getDescription()))
                fault = true;
            if (!bet.getName().equals(betGiven.getName()))
                fault = true;

            i += 1;
        }

        assertFalse(fault);
    }

    @Test
    public void betCheckSeven_true() {
        Bet betSeven = new Bet("Seven", new int[]{7}, 5);
        int[] dice = {3, 4};
        boolean result;

        result = betSeven.check(dice);

        assertTrue(result);
    }

    @Test
    public void betCheckSeven_false() {
        Bet betSeven = new Bet("Seven", new int[]{7}, 5);
        int[] dice = {1, 1};
        boolean result;

        result = betSeven.check(dice);

        assertFalse(result);
    }

    @Test
    public void betCheckHardways_true() {
        BetHardways betHardways = new BetHardways("Hardways", 8);
        int[] dice = {4, 4};
        boolean result;

        result = betHardways.check(dice);

        assertTrue(result);
    }

    @Test
    public void betCheckHardways_false() {
        BetHardways betHardways = new BetHardways("Hardways", 8);
        int[] dice = {4, 2};
        boolean result;

        result = betHardways.check(dice);

        assertFalse(result);
    }

    @Test
    public void toStringHorn() {
        Bet betHorn = new Bet("Horn", new int[]{2, 3, 11, 12}, 5);
        String correctName = "Horn";

        assertEquals(betHorn.toString(), correctName);
    }
}
