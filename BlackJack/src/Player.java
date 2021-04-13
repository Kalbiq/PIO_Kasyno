import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Player {


    public ArrayList<String> player_hand;
    public int cards_amount;

    public Player()
    {
        player_hand=new ArrayList<>();
        cards_amount=0;
    }

    public void addCard(String card)
    {
        player_hand.add(card);
        cards_amount++;
    }



}
