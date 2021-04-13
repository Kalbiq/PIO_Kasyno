package Craps;


import java.util.Scanner;

public class GameLogic {
    int[] dice = {0, 0};
    int score;
    int sumDice;
    int bet;
    int stake;

    public GameLogic() {
        this.score = 0;
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
    }

    public void selectBet() {
        System.out.println("Wybierz zakład:");
        System.out.println(("Craps (2, 3 lub 12) -> naciśnij 1\nSiódemka (7) -> naciśnij 2"));
        Scanner scanner = new Scanner(System.in);
        this.bet = scanner.nextInt();
    }

    public void checkResult() {
        switch (bet) {
            case 1:
                if (sumDice == 2 || sumDice == 3 || sumDice == 12) {
                    score += 8 * stake;
                    System.out.println("Wygrałeś. Twoje kredyty: " + score);
                } else {
                    score -= stake;
                    System.out.println("Przegrałeś. Twoje kredyty: " + score);
                }
                break;
            case 2:
                if (sumDice == 7) {
                    score += 5 * stake;
                    System.out.println("Wygrałeś. Twoje kredyty: " + score);
                } else {
                    score -= stake;
                    System.out.println("Przegrałeś. Twoje kredyty: " + score);
                }
                break;
        }
    }

    public void play() {
        int continueGame = 1;
        while (continueGame == 1) {
            setStake();
            selectBet();
            rollDice();
            checkResult();
            System.out.println("Grasz dalej?\n Tak -> naciśnij 1\tNie -> naciśnij 0");
            Scanner scanner = new Scanner(System.in);
            continueGame = scanner.nextInt();
        }
    }

}