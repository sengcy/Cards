package com.sengcy.Cards.CardCollection;


import com.sengcy.Cards.Card.CardFactory;

/**
 * Created by sengcy on 3/25/15.
 */

public interface CardCollectionFactory{
    public CardCollection CreateCardCollection(CardFactory iCardFactory);
}


