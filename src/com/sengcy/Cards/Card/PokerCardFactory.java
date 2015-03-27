package com.sengcy.Cards.Card;

import com.sengcy.Cards.CardCollection.CardCollection;
import com.sengcy.Cards.CardDescriptor.CardDescriptor;
import com.sengcy.Cards.CardDescriptor.RankDescriptor;
import com.sengcy.Cards.CardDescriptor.SuitDescriptor;

import java.util.ArrayList;

/**
 * Concrete implementation of CardFactory interface.
 * It creates either a single PokerCard object or
 * a CardCollection of PokerCard objects.
 */

public class PokerCardFactory implements  CardFactory {

    /**
     * Instantiates a PokerCard object.
     * @param iCardDescriptors An ArrayList of CardDescriptor that describes a Card
     * @return a PokerCard object if successful, null if not.
     */
    public Card CreateCard(ArrayList<CardDescriptor> iCardDescriptors){
        if (iCardDescriptors.size() != 2)
            return null; //poker card must have 2 descriptors

        PokerCard pokerCard = new PokerCard();

        for (CardDescriptor cardDescriptor : iCardDescriptors){
            if (!pokerCard.addDescriptor(cardDescriptor))
                return null;
        }

        return pokerCard;
    }


    /**
     * Creates a CardCollection of PokerCard objects.
     * @param iCardCollection A CardCollection to hold the card objects
     * @return true if successful, null if not.
     */
    public boolean CreateCardCollection(CardCollection iCardCollection) {
        for (SuitDescriptor.SuitEnum suit : SuitDescriptor.SuitEnum.values()){
            for (RankDescriptor.RankEnum rank : RankDescriptor.RankEnum.values()){

                ArrayList<CardDescriptor> descriptorList = new ArrayList<CardDescriptor>(2);

                SuitDescriptor suitDescriptor = new SuitDescriptor(suit);

                RankDescriptor rankDescriptor = new RankDescriptor(rank);

                if (!descriptorList.add(new SuitDescriptor(suit)))
                    return false;

                if (!descriptorList.add(new RankDescriptor(rank)))
                    return false;

                Card pokerCard = CreateCard(descriptorList);
                if (pokerCard == null)
                    return false;

                if (!iCardCollection.addCard(pokerCard))
                    return false;
            }
        }
        return true;
    }


}
