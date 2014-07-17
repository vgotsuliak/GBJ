package com.gotsuliak.sinteztask.blackjack.logic;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeckTest {

    Deck deck;

    @BeforeMethod
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testInitDeckSize() {
        deck.init();
        Assert.assertEquals(deck.getCards().length, Deck.DECK_SIZE);
    }

    @Test
    public void testInitDeck() {
        deck.init();
        int[] cards = deck.getCards();

    }
}