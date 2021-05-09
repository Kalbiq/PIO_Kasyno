package BJ;

import java.util.Scanner;

public class BlackjackLogic {

    public static boolean checkPlayerSum(int sum)
    {
        return sum < 21;
    }

    public static boolean waitForInput()
    {
        Scanner scanner=new Scanner(System.in);
        char c='x';

        while(c!='P')
        {
            System.out.println("D - graj dalej | P - pass");
            c = scanner.next().charAt(0);
            if(c=='D') return true;
        }

        return false;
    }

    public static boolean matchResult(int dealer_sum, int player_sum)
    {
        if (dealer_sum>21) return true;
        if (player_sum>21) return false;
        else if(dealer_sum>=player_sum) return false;
        else return true;
    }


}
