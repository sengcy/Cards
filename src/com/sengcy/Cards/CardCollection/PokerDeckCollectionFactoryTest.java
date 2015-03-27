package com.sengcy.Cards.CardCollection;

import com.sengcy.Cards.Card.Card;
import com.sengcy.Cards.Card.CardFactory;
import com.sengcy.Cards.Card.PokerCardFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerDeckCollectionFactoryTest {

    @Test
    public void testCreateCardCollection() throws Exception {
        System.out.println("\n**** Test Poker Deck ****");

        System.out.println("Create deck....");
        CardCollectionFactory pokerDeckFactory = new PokerDeckCollectionFactory();
        CardFactory pokerCardFactory = new PokerCardFactory();
        CardCollection deck = pokerDeckFactory.CreateCardCollection(pokerCardFactory);
        assertTrue(deck.isFull());

        System.out.println("Check if size is 52");
        assertTrue(deck.getSize() == 52);

        System.out.println("Before shuffle... contents of deck:");
        deck.printDeck(deck.getSize());

        System.out.println("After shuffle... contents of deck:");
        deck.shuffle();
        deck.printDeck(deck.getSize());

        System.out.println("Shuffle again... contents of deck:");
        deck.shuffle();
        deck.printDeck(deck.getSize());

        System.out.println("First 5 cards: ");
        deck.printDeck(5);

        System.out.println("First 5 cards after dealing one card: ");
        Card card = deck.dealOneCard();
        deck.printDeck(5);

        System.out.println("Card dealt:" + card.getDescription());

        assertTrue(!deck.isFull());

        System.out.println("Try shuffling deck that is not full");
        assertTrue(deck.shuffle() == false);

        System.out.println("Emptying deck");
        int count = 0;
        while (!deck.isEmpty()){
            deck.dealOneCard();
            count++;
        }

        assertTrue(count == 51);


    }
}