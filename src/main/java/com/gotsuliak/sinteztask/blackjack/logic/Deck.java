package com.gotsuliak.sinteztask.blackjack.logic;

import java.util.Arrays;
import java.util.Random;

public class Deck {

    public static final int DECK_SIZE = 52;
    public static final int SHUFFLE_TIMES = 10;
    private int currentCard = 0;

    private Card[] cards;

    public void init() {
        cards = new Card[DECK_SIZE];
        Arrays.fill(cards, 0, 4, Card.TWO);
        Arrays.fill(cards, 4, 8, Card.THREE);
        Arrays.fill(cards, 8, 12, Card.FOUR);
        Arrays.fill(cards, 12, 16, Card.FIVE);
        Arrays.fill(cards, 16, 20, Card.SIX);
        Arrays.fill(cards, 20, 24, Card.SEVEN);
        Arrays.fill(cards, 24, 28, Card.EIGHT);
        Arrays.fill(cards, 28, 32, Card.NINE);
        Arrays.fill(cards, 32, 36, Card.TEN);
        Arrays.fill(cards, 36, 40, Card.JACK);
        Arrays.fill(cards, 40, 44, Card.QUEEN);
        Arrays.fill(cards, 44, 48, Card.KING);
        Arrays.fill(cards, 48, 52, Card.ACE);
    }

    public void shuffle() {
        for (int k = 0; k < SHUFFLE_TIMES; k++) {
            for (int i = 0; i < DECK_SIZE; i++) {
                Random random = new Random(System.nanoTime());
                int randomPosition = random.nextInt(DECK_SIZE - 1);
                Card old = cards[randomPosition];
                cards[randomPosition] = cards[i];
                cards[i] = old;
            }
        }
    }

    public Card getCard() {
        if (currentCard >= 52) {
            throw new RuntimeException("The deck is empty");
        }
        return cards[currentCard++];
    }

    public int getCurrentCard() {
        return currentCard;
    }

    public Card[] getCards() {
        return cards;
    }
}
