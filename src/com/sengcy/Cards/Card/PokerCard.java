package com.sengcy.Cards.Card;

import com.sengcy.Cards.CardDescriptor.*;

/**
 * Class representing PokerCard which is  a concrete implementation
 * of Card.
 *
 */
public class PokerCard extends Card {

    private CardDescriptor mSuit;
    private CardDescriptor mRank;

    PokerCard(){
        mSuit = null;
        mRank = null;
    }

    /**
     * Get poker card description
     * @return String describing the suit and rank of a poker card.
     */
    public String getDescription() {
        String descriptor = "";

        if ((mSuit == null) || (mRank == null))
            return descriptor; // poker card must have 2 descriptors. If not return empty string;

        return mRank.getDescription() + " of " + mSuit.getDescription() ;
    }

    /**
     * Add a CardDescriptor to the card
     * @param iCardDescriptor A CardDescriptor that describes the card
     * @return true if CardDescriptor is added successfully, false if not.
     */
    boolean addDescriptor(CardDescriptor iCardDescriptor) {
        if ((iCardDescriptor instanceof SuitDescriptor) && (mSuit == null)) {
            mSuit = iCardDescriptor;
            return true;
        }
        else if ((iCardDescriptor instanceof RankDescriptor) && (mRank == null)){
            mRank = iCardDescriptor;
            return true;
        }
        return false;

    }


}
