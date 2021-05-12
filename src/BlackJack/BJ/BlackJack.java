package BJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BlackJack {

    public static int FUNDS;

    static {
        FUNDS = 0;
    }

    public static int readFile() {
        File file = new File(System.getProperty("user.dir") + "/gameData/playerFunds.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (scanner.hasNextInt()) {
            FUNDS = scanner.nextInt();
        }

        return FUNDS;
    }


}




