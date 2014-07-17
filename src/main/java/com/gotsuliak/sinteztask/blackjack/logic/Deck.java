package com.gotsuliak.sinteztask.blackjack.logic;

import java.util.Arrays;
import java.util.Random;

public class Deck {

    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;
    public static final int DECK_SIZE = 52;
    public static final int SHUFFLE_TIMES = 10;
    private int currentCard = 0;

    private int[] cards;

    public void init() {
        cards = new int[DECK_SIZE];
        Arrays.fill(cards, 0, 4, TWO);
        Arrays.fill(cards, 4, 8, THREE);
        Arrays.fill(cards, 8, 12, FOUR);
        Arrays.fill(cards, 12, 16, FIVE);
        Arrays.fill(cards, 16, 20, SIX);
        Arrays.fill(cards, 20, 24, SEVEN);
        Arrays.fill(cards, 24, 28, EIGHT);
        Arrays.fill(cards, 28, 32, NINE);
        Arrays.fill(cards, 32, 36, TEN);
        Arrays.fill(cards, 36, 40, JACK);
        Arrays.fill(cards, 40, 44, QUEEN);
        Arrays.fill(cards, 44, 48, KING);
        Arrays.fill(cards, 48, 52, ACE);
    }

    public void shuffle() {
        for (int k = 0; k < SHUFFLE_TIMES; k++) {
            for (int i = 0; i < DECK_SIZE; i++) {
                Random random = new Random(System.nanoTime());
                int randomPosition = random.nextInt(DECK_SIZE - 1);
                int old = cards[randomPosition];
                cards[randomPosition] = cards[i];
                cards[i] = old;
            }
        }
    }

    public int getCard() {
        if (currentCard >= 52) {
            throw new RuntimeException("The deck is empty");
        }
        return cards[currentCard++];
    }

    public int getCurrentCard() {
        return currentCard;
    }

    public int[] getCards() {
        return cards;
    }
}
