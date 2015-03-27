package com.sengcy.Cards.CardDescriptor;

/**
 * SuitDescriptor describes a card's suit.
 */


public class SuitDescriptor implements CardDescriptor {

    public enum SuitEnum {
        CLUB, DIAMOND, HEART, SPADE
    }

    private final SuitEnum mSuit;

    public SuitDescriptor(SuitEnum iSuit){
        mSuit = iSuit;
    }
    /**
     * Gets a description of a card's suit. This method overrides
     * getDescription of CardDescriptor interface.
     *
     * @return String describing the suit of a card
     */
    @Override
    public String getDescription() {
        String description = "";

        switch (mSuit) {
            case CLUB:
                description = "Clubs";
                break;
            case DIAMOND:
                description = "Diamonds";
                break;
            case HEART:
                description =  "Hearts";
                break;
            case SPADE:
                description = "Spades";
                break;
        }

       return description;
    }


}
