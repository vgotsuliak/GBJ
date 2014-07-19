package com.gotsuliak.sinteztask.blackjack.logic;

public enum Card {

    TWO(2,2),
    THREE(2,2),
    FOUR(2,2),
    FIVE(2,2),
    SIX(2,2),
    SEVEN(2,2),
    EIGHT(2,2),
    NINE(9,9),
    TEN(10,10),
    JACK(11,10),
    QUEEN(12,10),
    KING(13,10),
    ACE(14,1);

    private int id;
    private int value;

    private Card(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
