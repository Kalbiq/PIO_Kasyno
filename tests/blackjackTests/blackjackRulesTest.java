package blackjackTests;

import org.junit.jupiter.api.Test;
import BJ.BlackjackLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class blackjackRulesTest {

    @Test
    public void playerDrawsLessThen21_correctResult(){
        //given

        int handSum=20;

        //when
        boolean result=BlackjackLogic.checkPlayerSum(handSum);

        //then
        assertEquals(true,result);

    }

    @Test
    public void playerDraws21_correctResult(){
        //given
        int playerSum=21;
        int dealerSum=0;

        //when
        boolean result=BlackjackLogic.matchResult(dealerSum,playerSum);

        //then
        assertEquals(true,result);
    }

    @Test
    public void playerDrawsMoreThan21_correctResult(){
        //given
        int playerSum=22;
        int dealerSum=0;

        //when
        boolean result=BlackjackLogic.matchResult(dealerSum,playerSum);

        //then
        assertEquals(false,result);
    }

    @Test
    public void dealerDrawsMoreThan21_correctResult(){
        //given
        int playerSum=19;
        int dealerSum=22;

        //when
        boolean result=BlackjackLogic.matchResult(dealerSum,playerSum);

        //then
        assertEquals(true,result);
    }

    @Test
    public void dealerDrawsMoreThanPlayer_correctResult(){
        //given
        int playerSum=16;
        int dealerSum=19;

        //when
        boolean result=BlackjackLogic.matchResult(dealerSum,playerSum);

        //then
        assertEquals(false,result);
    }


}
