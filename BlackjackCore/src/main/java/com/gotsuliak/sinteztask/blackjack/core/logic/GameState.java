package com.gotsuliak.sinteztask.blackjack.core.logic;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    public static final int GAME_STATUS_PLAYING = 0;
    public static final int GAME_STATUS_PLAYER_WINS = 1;
    public static final int GAME_STATUS_PLAYER_BUST = 2;
    public static final int GAME_STATUS_PLAYER_LOOSE = 3;
    public static final int GAME_STATUS_PUSH = 4;

    private int gameStatus;
    private State player = new State();
    private State dealer = new State();

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public State getPlayer() {
        return player;
    }

    public State getDealer() {
        return dealer;
    }

    public static class State {

        private List<Card> cards = new ArrayList<>();

        public void addCard(Card card) {
            cards.add(card);
        }

        public int getPoints() {
            int points = 0;
            for (Card card : cards) {
                points += card.getValue();
            }
            return points;
        }

        public List<Card> getCards() {
            return cards;
        }
    }

}
