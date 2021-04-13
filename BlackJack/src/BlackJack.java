
public class BlackJack {

    public static void main(String[] args)
    {
        Deck e= new Deck();
        e.shuffleDeck();
        System.out.println(e.decktoshuffle);

        Player player=new Player();
        Player enemy=new Player();



        for(int i=0;i<9;i++)
        {
            player.addCard(e.drawCard());
            enemy.addCard(e.drawCard());
        }

        System.out.println("Reka gracza:");
        System.out.println(player.player_hand);
        System.out.println("Reka krupiera:");
        System.out.println(enemy.player_hand);

    }

}




