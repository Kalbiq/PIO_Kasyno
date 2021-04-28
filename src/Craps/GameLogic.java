package Craps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    int[] dice = {0, 0};
    int score;
    int sumDice;
    int bet;
    int stake;
    List<Bet> bets = new ArrayList<>();

    public GameLogic() {
        this.score = 0;
        Bet betBoxcars = new Bet("Boxcars", new int[]{2,12}, 30);
        bets.add(betBoxcars);
        Bet betAceyDeucey = new Bet("Acey Deucey", new int[]{3}, 16 );
        bets.add(betAceyDeucey);
        Bet betCraps = new Bet("Craps", new int[]{2,3,12}, 8);
        bets.add(betCraps);
        BetHardways betHardways = new BetHardways("Hardways", 8);
        bets.add(betHardways);
        Bet betEleven = new Bet("Eleven", new int[]{11}, 6);
        bets.add(betEleven);
        Bet betHorn = new Bet("Horn", new int[]{2,3,11,12}, 5);
        bets.add(betHorn);
        Bet betSeven = new Bet("Seven", new int[]{7}, 5);
        bets.add(betSeven);
        Bet betDontPassLine = new Bet("Don't Pass Line", new int[]{7,3}, 1);
        bets.add(betDontPassLine);
        Bet betPassLine = new Bet("Pass Line", new int[]{7,11}, 1);
        bets.add(betPassLine);
    }

    public void rollDice() {
        int roll;
        this.sumDice = 0;

        for (int i = 0; i < 2; i++) {
            roll = (int) Math.floor(Math.random() * (7 - 1)) + 1;
            this.dice[i] = roll;
        }

        this.sumDice = this.dice[0] + this.dice[1];
        System.out.printf("Wyrzucono: %d, %d\n", dice[0], dice[1]);
        System.out.printf("Suma oczek: %d\n", sumDice);
    }

    public void setStake() {
        System.out.println("Podaj stawkę:");
        Scanner scanner = new Scanner(System.in);
        this.stake = scanner.nextInt();
        System.out.println("--------------------------------------------------------------------");
    }

    public void selectBet() {
        System.out.println("Wybierz zakład:");
        int i = 0;
        for (Bet bet:bets) {
            System.out.println(bet.description() + " -> naciśnij " + i);
            i += 1;
        }
        Scanner scanner = new Scanner(System.in);
        this.bet = scanner.nextInt();
        System.out.println("--------------------------------------------------------------------");
    }

    public void checkResult() {
        Bet selectedBet = bets.get(bet);
        if (selectedBet.check(dice)) {
            score += selectedBet.getMultiplier() * stake;
            System.out.println("Wygrałeś. Twoje kredyty: " + score);
        }
        else {
            score -= stake;
            System.out.println("Przegrałeś. Twoje kredyty: " + score);
        }
        System.out.println("--------------------------------------------------------------------");
    }

    public void play() {
        setStake();
        selectBet();
        rollDice();
        checkResult();
    }

}