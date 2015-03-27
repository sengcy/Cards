package com.sengcy.Cards.CardDescriptor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardDescriptorTest {

    private ArrayList<CardDescriptor> cardDescriptors;
    @Before
    public void setUp() throws Exception {
        cardDescriptors = new ArrayList<CardDescriptor>();
        for (SuitDescriptor.SuitEnum suit : SuitDescriptor.SuitEnum.values())
            assertTrue(cardDescriptors.add(new SuitDescriptor(suit)));
        for (RankDescriptor.RankEnum rank : RankDescriptor.RankEnum.values())
            assertTrue(cardDescriptors.add(new RankDescriptor(rank)));

        assertTrue(cardDescriptors.size() == 17);
    }

    @Test
    public void testGetDescription() throws Exception {

        System.out.println ("\n****Card descriptor test *****");
        System.out.println("Available descriptors: ");
        for (CardDescriptor cardDescriptor : cardDescriptors ){
            String descriptor = "";
            descriptor = cardDescriptor.getDescription();
            assertTrue(descriptor != "");
            System.out.print(descriptor + " ");
        }

    }
}