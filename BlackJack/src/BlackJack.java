import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
public class BlackJack {

    public static String[] deck = new String[] {"H2","S2","D2","C2","H3","S3","D3","C3",
            "H4","S4","D4","C4","H5","S5","D5","C5","H6","S6","D6","C6","H7","S7","D7","C7","H8","S8","D8","C8",
            "H9","S9","D9","C9","HT","ST","DT","CT","HJ","SJ","DJ","CJ","HQ","SQ","DQ","CQ","HK","SK","DK","CK",
            "HA","SA","DA","CA"};



    public static void main(String[] args)
    {
        ArrayList<String> decktoshuffle= new ArrayList<>();
        decktoshuffle.addAll(Arrays.asList(deck).subList(0, 52));
        shuffleDeck(decktoshuffle);
        System.out.println(decktoshuffle);
    }
    public static void shuffleDeck(ArrayList<String> e){
        Collections.shuffle(e);
    }
}




