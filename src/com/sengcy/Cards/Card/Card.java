package com.sengcy.Cards.Card;

import com.sengcy.Cards.CardDescriptor.CardDescriptor;

/**
 * Abstract class that represents a card. Card implements
 * CardDescriptor, which describes the card.
 */
public abstract class Card implements CardDescriptor {


    /**
     * Get the card description.
     * @return A string describing the Card.
     */
    public abstract String getDescription();

}
