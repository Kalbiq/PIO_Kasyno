

import java.util.*;

public class Deck {

    private int deck_it;
    private ArrayList<String> decktoshuffle;
    public Deck() {
        deck_it=0;
        decktoshuffle = new ArrayList<>();
        decktoshuffle.addAll(Arrays.asList("C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9",
                "CA", "CJ", "CK", "CQ", "CT", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DJ", "DK", "DQ", "DT", "H2", "H3",
                "H4", "H5", "H6", "H7", "H8", "H9", "HA", "HJ", "HK", "HQ", "HT", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "SA",
                "SJ", "SK", "SQ", "ST"));
    }

    public void shuffleDeck(){
        Collections.shuffle(decktoshuffle);
    }

    public String drawCard()
    {
        deck_it++;
        return decktoshuffle.get(deck_it-1);
    }

}
