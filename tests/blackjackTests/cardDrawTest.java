package blackjackTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import BJ.Player;
import BJ.Deck;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class cardDrawTest {

    private Player player;

    @BeforeEach
    public void SetUp() {
        player = new Player();
    }

    @Test
    public void playerDrawCard_cardsSumCheck_correctResult() {

        //given
        String card = "H9";

        //when
        player.addCard(card);
        int result = player.sum;

        //then
        assertEquals(9, result);

    }

    @Test
    public void playerDrawsSeveralCards_cardsSumCheck_correctResult() {

        //given
        String[] cards = {"H2", "C2", "S3", "D4", "H5", "D5"};

        //when
        for (String card : cards)
            player.addCard(card);

        int result = player.sum;

        //then
        assertEquals(21, result);
    }

    @Test
    public void playerDrawCard_cardsAmountCheck_correctResult() {

        //given
        String card = "H9";

        //when
        player.addCard(card);
        int result = player.cards_amount;

        //then
        assertEquals(1, result);

    }


    @Test
    public void playerDrawsSeveralCards_cardsAmountCheck_correctResult() {

        //given
        String[] cards = {"H5", "C9", "S2", "D4", "H2", "D5"};

        //when
        for (String card : cards)
            player.addCard(card);

        int result = player.cards_amount;

        //then
        assertEquals(6, result);
    }

    @Test
    public void playerDrawCard_shuffledDeckStateCheck_correctResult() {

        //given
        Deck deck = new Deck();
        deck.shuffleDeck();

        int deckIt = deck.getDeck_it();

        //when
        player.addCard(deck.drawCard());
        int resultCardsAmount = player.cards_amount;
        int resultDeckIt = deck.getDeck_it();

        //then
        assertEquals(1, resultCardsAmount);
        assertEquals(1, resultDeckIt);

    }

    @Test
    public void playerDrawsSeveralCards_shuffledDeckStateCheck_correctResult() {

        //given
        Deck deck = new Deck();
        deck.shuffleDeck();

        int deckIt = deck.getDeck_it();
        int cardsToDraw = 5;

        //when

        for (int i = 0; i < cardsToDraw; i++)
            player.addCard(deck.drawCard());

        int resultCardsAmount = player.cards_amount;
        int resultDeckIt = deck.getDeck_it();

        //then
        assertEquals(5, resultCardsAmount);
        assertEquals(5, resultDeckIt);

    }

}
