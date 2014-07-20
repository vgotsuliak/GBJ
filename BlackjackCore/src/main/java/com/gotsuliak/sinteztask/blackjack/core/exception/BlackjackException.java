package com.gotsuliak.sinteztask.blackjack.core.exception;

public class BlackjackException extends RuntimeException {

    public static final BlackjackException NOT_ENOUGH_MONEY = new BlackjackException(1, "Not enough money to make bet");

    private int code;

    public BlackjackException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
