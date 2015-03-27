package com.sengcy.Cards.CardCollection;

import com.sengcy.Cards.Card.Card;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

/**
 * Concrete implementation of CardCollection.
 */
public class PokerDeckCardCollection extends CardCollection {

    private final int mCapacity = 52;
    private final Stack<Card> mDeck;

    PokerDeckCardCollection(){
        mDeck = new Stack<Card>();
        mDeck.ensureCapacity(mCapacity);
    }


    /**
     *
     * @return number of cards in the deck
     */
    @Override
    public int getSize() {
        return mDeck.size();
    }


    /**
     * @return true if deck is empty. Otherwise returns false.
     */
    @Override
    public boolean isEmpty(){
        return (mDeck.isEmpty());
    }

    /**
     * @return true if deck is full. Otherwise returns false.
     */
    @Override
    public boolean isFull(){
        return (mDeck.size() == mCapacity);
    }

    /**
     * Adds card to the top of the deck.
     * @param iCard Card to be inserted.
     * @return true if Card is inserted successfully. Otherwise return
     * false. Return false if deck is full.
     */
    @Override
    public boolean addCard(Card iCard) {
        return (!isFull()) && (mDeck.push(iCard) == iCard);

    }

    /**
     * @return Top Card of the deck, null if deck is empty.
     */
    @Override
    public Card dealOneCard() {
        if (!isEmpty()) {
            return mDeck.pop();
        } else {
            return null;
        }
    }

    /**
     * Randomly reorders the Cards in the deck, provided if the
     * deck is full.
     * @return true if reorder successfully. Otherwise returns false.
     */
    @Override
    public boolean shuffle() {
        if (!isFull()){
            return false; //only shuffle if deck is full
        }

        Random randomGenerator = new Random();

        try{
            for (int i = (mCapacity -1); i > 0; i--) {
                Card temp = mDeck.elementAt(i);
                int j = randomGenerator.nextInt(i+1); //generate random number from 0 to i (inclusive)
                if (i != j){
                    mDeck.setElementAt(mDeck.elementAt(j), i);
                    mDeck.setElementAt(temp, j);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            return false;   //shuffle failed. Ideally, I would like to log the error message and
                        // return a more meaningful error code
        }

        return true;
    }

    /**
     * Prints the card descriptor of the first n cards. If n is greater
     * than the number of the cards in the deck, the card descriptors of
     * the entire collection is printed. The order begins from the top
     * to bottom of the deck.
     * @param n Integer describing the number of card descriptors
     */
    @Override
    public void printDeck(int n){
        if (n > mDeck.size())
            n = mDeck.size();


        for (int i = mDeck.size() -1; i >= mDeck.size()-n; i--  ){
            System.out.print(mDeck.elementAt(i).getDescription());
            if (i != mDeck.size()-n)
                System.out.print(", ");
        }
        System.out.println();
    }

}
