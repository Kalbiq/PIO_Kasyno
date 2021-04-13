
public class BlackJack {

    public static void main(String[] args)
    {
        Deck e= new Deck();
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

        TestGUI.createWindow(1200,700);
    }

}




