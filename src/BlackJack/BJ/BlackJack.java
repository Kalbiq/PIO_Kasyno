package BJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BlackJack {

    public static int FUNDS;

    static {
        FUNDS = 0;
    }

    public static void main(String[] args)
    {
        File file = new File(System.getProperty("user.dir")+"\\gameData\\playerFunds.txt");

        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(scanner.hasNextInt())
        {
            FUNDS=scanner.nextInt();
        }

        TestGUI gui=new TestGUI();

        gui.createWindow(1200,700, FUNDS);

     /*   Deck e= new Deck();
        e.shuffleDeck();
       // System.out.println(e.decktoshuffle);


        Player player=new Player();
        Player dealer=new Player();

        do
        {
            player.addCard(e.drawCard());

            System.out.println("Suma reki: "+player.sum+" | Reka gracza:");
            System.out.println(player.player_hand);

        }while(BlackjackLogic.checkPlayerSum(player.sum)&&BlackjackLogic.waitForInput());


        if(BlackjackLogic.checkPlayerSum(player.sum))
        {

            do
            {
                dealer.addCard(e.drawCard());

                System.out.println("Suma kurpiera: " + dealer.sum + " | Reka kurpiera:");
                System.out.println(dealer.player_hand);

            } while (BlackjackLogic.checkPlayerSum(dealer.sum)&&player.sum>dealer.sum);

        }

        if(BlackjackLogic.matchResult(dealer.sum,player.sum))
        {
            System.out.println("WYGRALES!");
        }
        else System.out.println("PRZEGRALES :(");
*/
    }



}




