package BJ;

import java.util.ArrayList;

public class Player {


    public ArrayList<String> player_hand;
    public int cards_amount;
    public int sum;

    public Player()
    {
        player_hand=new ArrayList<>();
        cards_amount=0;
        sum=0;
    }

    public void addCard(String card)
    {
        player_hand.add(card);
        cards_amount++;
        if(card.charAt(1)<='9'&&card.charAt(1)>='2')
        sum+=Integer.parseInt(String.valueOf(card.charAt(1)));
        else if(card.charAt(1)=='T') sum+=10;
        else if(card.charAt(1)=='J') sum+=2;
        else if(card.charAt(1)=='Q') sum+=3;
        else if(card.charAt(1)=='K') sum+=4;
        else if(card.charAt(1)=='A') sum+=11;
    }



}
