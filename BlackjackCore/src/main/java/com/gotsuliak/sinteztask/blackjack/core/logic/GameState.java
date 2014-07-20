package com.gotsuliak.sinteztask.blackjack.core.logic;

import com.gotsuliak.sinteztask.blackjack.core.entity.Card;

import javax.enterprise.context.SessionScoped;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameState {

    public static final int GAME_STATUS_WAITING_BET = -1;
    public static final int GAME_STATUS_PLAYING = 0;
    public static final int GAME_STATUS_PLAYER_WINS = 1;
    public static final int GAME_STATUS_PLAYER_BUST = 2;
    public static final int GAME_STATUS_PLAYER_LOOSE = 3;
    public static final int GAME_STATUS_PUSH = 4;
    public static final int GAME_STATUS_BLACK_JACK = 5;

    private int gameStatus = GAME_STATUS_WAITING_BET;
    @XmlElement(name = "player")
    private State player = new State();
    @XmlElement(name = "dealer")
    private State dealer = new State();
    private long winSum;

    public void clear() {
        gameStatus = GAME_STATUS_WAITING_BET;
        player = new State();
        dealer = new State();
        winSum = 0l;
    }

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

    public long getWinSum() {
        return winSum;
    }

    public void setWinSum(long winSum) {
        this.winSum = winSum;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class State {

        @XmlElement(name = "card")
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
