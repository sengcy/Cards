package com.sengcy.Cards.CardCollection;

import com.sengcy.Cards.Card.Card;
import com.sengcy.Cards.Card.CardFactory;
import com.sengcy.Cards.Card.PokerCard;
import com.sengcy.Cards.Card.PokerCardFactory;

/**
 * Created by sengcy on 3/26/15.
 */
public class PokerDeckCollectionFactory implements CardCollectionFactory {

        public CardCollection CreateCardCollection(CardFactory iCardFactory){

            CardCollection pokerDeck = new PokerDeckCardCollection();

            if (!iCardFactory.CreateCardCollection(pokerDeck))
                return null;

            if (pokerDeck.isFull()) {
                return pokerDeck;
            }
            else{
                //log error and return null
                return null;
            }

        }
}
