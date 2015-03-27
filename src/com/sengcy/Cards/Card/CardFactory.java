package com.sengcy.Cards.Card;

import com.sengcy.Cards.CardCollection.CardCollection;
import com.sengcy.Cards.CardDescriptor.CardDescriptor;

import java.util.ArrayList;

/**
 * Interface for factory that creates Card object. It can either instantiate a
 * single Card object, or a CardCollection of Card objects.
 */
public interface CardFactory {
    /**
     * Method to instantiate a Card object
     * @param iCardDescriptors An ArrayList of CardDescriptor that describes a Card
     * @return Card, or null if Card cannot be created.
     */
    public Card CreateCard(ArrayList<CardDescriptor> iCardDescriptors);


    /**
     * Instantiate a collection of Card objects.
     * @param iCardCollection A CardCollection to hold the card objects
     * @return true if successful, false if not successful.
     */
    public boolean CreateCardCollection(CardCollection iCardCollection);
}
