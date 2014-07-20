package com.gotsuliak.sinteztask.blackjack.core.exception;

public class BlackjackException extends RuntimeException {

    public static final BlackjackException NOT_ENOUGH_MONEY = new BlackjackException(1, "Not enough money to make bet");
    public static final BlackjackException BET_IS_ALREADY_MADE = new BlackjackException(2, "Bet is already made");
    public static final BlackjackException WRONG_GAME_STATE = new BlackjackException(2, "Wrong game state");
    public static final BlackjackException DECK_IS_EMPTY = new BlackjackException(2, "Deck is empty");

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
