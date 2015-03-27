package com.sengcy.Cards.Card;

import com.sengcy.Cards.CardDescriptor.CardDescriptor;
import com.sengcy.Cards.CardDescriptor.RankDescriptor;
import com.sengcy.Cards.CardDescriptor.SuitDescriptor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokerCardFactoryTest {


    @Test
    public void testCreateCard() throws Exception {
        CardFactory cardFactory = new PokerCardFactory();

        System.out.println("\n****Poker Card Test using factory****");

        System.out.println("Test with empty descriptors");
        ArrayList<CardDescriptor> cardDescriptors = new ArrayList<CardDescriptor>();
        Card emptyCard = cardFactory.CreateCard(cardDescriptors);
        assertTrue(emptyCard == null);

        System.out.println("Test with one descriptor");
        cardDescriptors.add(new SuitDescriptor(SuitDescriptor.SuitEnum.SPADE));
        emptyCard = cardFactory.CreateCard(cardDescriptors);
        assertTrue(emptyCard == null);

        System.out.println("Test with invalid descriptor");
        class NameDescriptor implements CardDescriptor{
            @Override
            public String getDescription() {
                return "Kate";
            }
        }

        cardDescriptors.add(new NameDescriptor());
        emptyCard = cardFactory.CreateCard(cardDescriptors);
        assertTrue(emptyCard == null);

        System.out.println ("Test with 2 ranks");
        ArrayList<CardDescriptor> twoRank = new ArrayList<CardDescriptor>();
        twoRank.add(new RankDescriptor(RankDescriptor.RankEnum.ACE));
        twoRank.add(new RankDescriptor(RankDescriptor.RankEnum.EIGHT));
        emptyCard = cardFactory.CreateCard(twoRank);
        assertTrue(emptyCard == null);

        System.out.println ("Test with 2 suits");
        ArrayList<CardDescriptor> twoSuit = new ArrayList<CardDescriptor>();
        twoRank.add(new SuitDescriptor(SuitDescriptor.SuitEnum.HEART));
        twoRank.add(new SuitDescriptor(SuitDescriptor.SuitEnum.DIAMOND));
        emptyCard = cardFactory.CreateCard(twoSuit);
        assertTrue(emptyCard == null);

        System.out.println ("Test with 7 Clubs");
        ArrayList<CardDescriptor> sevenClub = new ArrayList<CardDescriptor>();
        sevenClub.add(new RankDescriptor(RankDescriptor.RankEnum.SEVEN));
        sevenClub.add(new SuitDescriptor(SuitDescriptor.SuitEnum.CLUB));
        Card sevenClubCard = cardFactory.CreateCard(sevenClub);
        assertTrue(sevenClubCard != null);
        assertTrue(sevenClubCard.getDescription().equals("Seven of Clubs"));

        System.out.println ("Test with Clubs 7 ");
        ArrayList<CardDescriptor> clubSeven = new ArrayList<CardDescriptor>();
        clubSeven.add(new SuitDescriptor(SuitDescriptor.SuitEnum.CLUB));
        clubSeven.add(new RankDescriptor(RankDescriptor.RankEnum.SEVEN));
        Card clubSevenCard = cardFactory.CreateCard(clubSeven);
        assertTrue(clubSevenCard != null);
        assertTrue(clubSevenCard.getDescription().equals("Seven of Clubs"));

        System.out.println("Test with 3 descriptors");
        sevenClub.add(new RankDescriptor(RankDescriptor.RankEnum.QUEEN));
        Card sevenClubQueenCard = cardFactory.CreateCard(sevenClub);
        assertTrue(sevenClubQueenCard == null);


    }


}