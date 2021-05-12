package blackjackTests;

import BJ.BlackJack;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class readFundsFromFileTests {

    @Test
    public void checkStatusOfFunds() {

        //given
        File file = new File(System.getProperty("user.dir") + "/gameData/playerFunds.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int expectedValue = Objects.requireNonNull(scanner).nextInt();

        //when
        int result = BlackJack.readFile();

        //then
        assertEquals(expectedValue, result);
    }

}
