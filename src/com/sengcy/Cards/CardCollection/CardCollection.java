package com.sengcy.Cards.CardCollection;

import com.sengcy.Cards.Card.*;

/**
 * Class representing a collection of cards.
 */
public abstract class CardCollection {

    /**
     * Get the number of cards in the collection
     * @return integer indicating the number of cards.
     */
    public abstract int getSize();

    /**
     * Insert a card into the collection. The order of insertion
     * is dependent on the type of CardCollection. If CardCollection
     * is full, Card will not be inserted successfully.
     * @param iCard Card to be inserted.
     * @return true if card is inserted, false if not.
     */
    public abstract boolean addCard(Card iCard);

    /**
     * Method to check for an empty CardCollection
     * @return true if CardCollection is empty. Otherwise returns false.
     */
    public abstract boolean isEmpty();


    /**
     * Method to check whether CardCollection is full.
     * @return true if CardCollection is full. Otherwise returns false.
     */
    public abstract boolean isFull();

    /**
     * Returns a card. The card is removed from the CardCollection.
     * The selection of which card to return is dependent on underlying
     * interface.
     *
     * @return Card if CardCollection is not empty. Returns null if
     * CardCollection is empty.
     */
    public abstract Card dealOneCard();

    /**
     * Reorders the card in random order.
     * @return true if shuffle is successful, false if not.
     */
    public abstract boolean shuffle();

    /**
     * Prints the descriptors of the first n cards in the
     * CardCollection. If n is greater than the number of cards
     * in the collection, the descriptors of all cards in the
     * collection will be printed.
     * The order of cards is determined by specific CardCollection.
     * @param n Integer describing the number of card descriptors
     *          to print.
     */
    public abstract void printDeck(int n);
}
