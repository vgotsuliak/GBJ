package com.gotsuliak.sinteztask.blackjack.entity;

public enum TransactionType {

    PUT(1),
    ;

    private int id;

    TransactionType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
