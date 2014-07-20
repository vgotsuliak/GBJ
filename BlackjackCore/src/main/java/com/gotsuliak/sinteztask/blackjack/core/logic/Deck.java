package com.gotsuliak.sinteztask.blackjack.core.logic;

import com.gotsuliak.sinteztask.blackjack.core.entity.Card;

import java.util.Arrays;
import java.util.Random;

public class Deck {

    public static final Card TWO = new Card(2, 2, "two");
    public static final Card THREE = new Card(3, 3, "three");
    public static final Card FOUR = new Card(4, 4, "four");
    public static final Card FIVE = new Card(5, 5, "five");
    public static final Card SIX = new Card(6, 6, "six");
    public static final Card SEVEN = new Card(7, 7, "seven");
    public static final Card EIGHT = new Card(8, 8, "eight");
    public static final Card NINE = new Card(9, 9, "nine");
    public static final Card TEN = new Card(10, 10, "ten");
    public static final Card JACK = new Card(11, 10, "jack");
    public static final Card QUEEN = new Card(12, 10, "queen");
    public static final Card KING = new Card(13, 10, "king");
    public static final Card ACE = new Card(14, 11, "ace");
    public static final int DECK_SIZE = 52;
    public static final int SHUFFLE_TIMES = 10;
    private int currentCard = 0;

    private Card[] cards;

    public void init() {
        cards = new Card[DECK_SIZE];
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
