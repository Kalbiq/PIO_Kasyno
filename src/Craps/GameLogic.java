package Craps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    private final int[] dice = new int[2];
    private int score;
    private int bet;
    private int stake;
    private final List<Bet> bets = new ArrayList<>();

    public GameLogic() {
        File playerFunds = new File(System.getProperty("user.dir") + "/gameData/playerFunds.txt");

        Scanner scanner;
        try {
            scanner = new Scanner(playerFunds);
            if (scanner.hasNextInt()) {
                this.score = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.bet = 0;
        this.stake = 0;

        Bet betBoxcars = new Bet("Boxcars", new int[]{2, 12}, 12);
        bets.add(betBoxcars);
        Bet betAceyDeucey = new Bet("Acey Deucey", new int[]{3}, 9);
        bets.add(betAceyDeucey);
        Bet betCraps = new Bet("Craps", new int[]{2, 3, 12}, 8);
        bets.add(betCraps);
        BetHardways betHardways = new BetHardways("Hardways", 8);
        bets.add(betHardways);
        Bet betEleven = new Bet("Eleven", new int[]{11}, 6);
        bets.add(betEleven);
        Bet betHorn = new Bet("Horn", new int[]{2, 3, 11, 12}, 5);
        bets.add(betHorn);
        Bet betSeven = new Bet("Seven", new int[]{7}, 5);
        bets.add(betSeven);
        Bet betDontPassLine = new Bet("Don't Pass Line", new int[]{7, 3}, 1);
        bets.add(betDontPassLine);
        Bet betPassLine = new Bet("Pass Line", new int[]{7, 11}, 1);
        bets.add(betPassLine);
    }

    public int getScore() {
        return this.score;
    }

    public int getDie(int i) {
        if (i == 0 || i == 1)
            return this.dice[i];
        else
            return 1;
    }

    public List<Bet> getBets() {
        return bets;
    }

    private void rollDice() {
        int roll;

        for (int i = 0; i < 2; i++) {
            roll = (int) Math.floor(Math.random() * (7 - 1)) + 1;
            this.dice[i] = roll;
        }

    }

    private void setStake(int stake) {
        this.stake = Math.min(stake, score);
    }

    private void selectBet(int bet) {
        this.bet = bet;
    }

    private void changeScore(int difference) {
        this.score += difference;

        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/gameData/playerFunds.txt");
            writer.write(Integer.toString(this.score));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkResult() {
        Bet selectedBet = bets.get(bet);
        if (selectedBet.check(dice)) {
            this.changeScore(selectedBet.getMultiplier() * stake);
            return true;
        } else {
            this.changeScore(this.stake * (-1));
            return false;
        }
    }

    public boolean play(int bet, int stake) {
        setStake(stake);
        selectBet(bet);
        rollDice();

        return checkResult();
    }
}