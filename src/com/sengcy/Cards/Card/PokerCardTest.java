package com.sengcy.Cards.Card;

import com.sengcy.Cards.CardDescriptor.CardDescriptor;
import com.sengcy.Cards.CardDescriptor.RankDescriptor;
import com.sengcy.Cards.CardDescriptor.SuitDescriptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerCardTest {

    private PokerCard emptyCard;
    private PokerCard heartCard;
    private PokerCard twoCard;
    private PokerCard kingKingCard;
    private PokerCard diamondSpadeCard;
    private PokerCard fiveClubCard;
    private PokerCard kateSpadeCard;

    @Before
    public void setUp() throws Exception {

        emptyCard = new PokerCard();
        heartCard = new PokerCard();
        twoCard = new PokerCard();
        kingKingCard = new PokerCard();
        diamondSpadeCard = new PokerCard();
        fiveClubCard = new PokerCard();
        kateSpadeCard = new PokerCard();

    }


    public void testGetDescriptionBeforeInit() throws Exception {
        String description = emptyCard.getDescription() + heartCard.getDescription() + twoCard.getDescription() +
                                kingKingCard.getDescription() + diamondSpadeCard.getDescription() +
                                fiveClubCard.getDescription() + kateSpadeCard.getDescription();

        System.out.println("Before initialization.... description = " + description);
        assertTrue(fiveClubCard.getDescription().equals(""));
    }


    public void testAddDescriptor() throws Exception {
            assertTrue(heartCard.addDescriptor(new SuitDescriptor(SuitDescriptor.SuitEnum.HEART)));
            assertTrue(twoCard.addDescriptor(new RankDescriptor(RankDescriptor.RankEnum.TWO)));

            assertTrue(kingKingCard.addDescriptor(new RankDescriptor(RankDescriptor.RankEnum.KING)));
            assertFalse(kingKingCard.addDescriptor(new RankDescriptor(RankDescriptor.RankEnum.KING)));

            assertTrue(diamondSpadeCard.addDescriptor(new SuitDescriptor(SuitDescriptor.SuitEnum.DIAMOND)));
            assertFalse(diamondSpadeCard.addDescriptor(new SuitDescriptor(SuitDescriptor.SuitEnum.SPADE)));

            assertTrue(fiveClubCard.addDescriptor(new SuitDescriptor(SuitDescriptor.SuitEnum.CLUB)));
            assertTrue(fiveClubCard.addDescriptor(new RankDescriptor(RankDescriptor.RankEnum.FIVE)));
            assertFalse(fiveClubCard.addDescriptor(new RankDescriptor(RankDescriptor.RankEnum.FIVE)));

            class NameDescriptor implements CardDescriptor {
                public String getDescription() {
                    return "Kate";
                }
            }

            assertTrue(kateSpadeCard.addDescriptor(new SuitDescriptor(SuitDescriptor.SuitEnum.SPADE)));
            assertFalse(kateSpadeCard.addDescriptor(new NameDescriptor()));

    }

    public void testGetDescriptionAfterInit() throws Exception {
        System.out.print("After initialization.... description =");
        String description = heartCard.getDescription() + twoCard.getDescription() +
                                kingKingCard.getDescription() + diamondSpadeCard.getDescription() +
                                fiveClubCard.getDescription() + kingKingCard.getDescription();
        System.out.println(description);
        assertTrue(description.equals("Five of Clubs"));
    }

    @Test
    public void testAll() throws  Exception{
        System.out.println("\n****Poker Card Test with new ****");
        testGetDescriptionBeforeInit();
        testAddDescriptor();
        testGetDescriptionAfterInit();
    }
}