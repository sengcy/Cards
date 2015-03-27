package com.sengcy.Cards.CardDescriptor;


/**
 * RankDescriptor describes the rank of a card.
 */


public class RankDescriptor implements CardDescriptor {

    public enum RankEnum {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private final RankEnum mRank;

    public RankDescriptor(RankEnum iRank){
        mRank = iRank;
    }

    /**
     * Gets a description of a card's rank. This method overrides
     * getDescription of CardDescriptor interface.
     *
     * @return String describing the rank of a card
     */
    @Override
    public String getDescription() {
        String description = "";

        switch (mRank){

            case ACE:
                description = "Ace";
                break;
            case TWO:
                description = "Two";
                break;
            case THREE:
                description = "Three";
                break;
            case FOUR:
                description = "Four";
                break;
            case FIVE:
                description = "Five";
                break;
            case SIX:
                description = "Six";
                break;
            case SEVEN:
                description = "Seven";
                break;
            case EIGHT:
                description = "Eight";
                break;
            case NINE:
                description = "Nine";
                break;
            case TEN:
                description = "Ten";
                break;
            case JACK:
                description = "Jack";
                break;
            case QUEEN:
                description = "Queen";
                break;
            case KING:
                description = "King";
                break;
        }

        return description;
    }


}
