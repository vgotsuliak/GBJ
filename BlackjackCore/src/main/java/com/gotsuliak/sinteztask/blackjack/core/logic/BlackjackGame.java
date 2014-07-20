package com.gotsuliak.sinteztask.blackjack.core.logic;


import com.gotsuliak.sinteztask.blackjack.core.entity.Card;
import com.gotsuliak.sinteztask.blackjack.core.exception.BlackjackException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class BlackjackGame implements Serializable {

    private final static int BLACKJACK = 21;
    private Deck deck;
    private GameState gameState;
    private long betSum;

    public BlackjackGame() {
        initGame();
    }

    public void initGame() {
        gameState = new GameState();
        deck = new Deck();
        deck.init();
        deck.shuffle();
    }

    public GameState newGame() {
        gameState.clear();
        initGame();
        return gameState;
    }

    public GameState makeBet(long betSum) {
        if (gameState.getGameStatus() != GameState.GAME_STATUS_WAITING_BET) {
            throw new BlackjackException(1, "Bet is already made");
        }
        this.betSum = betSum;
        gameState.setGameStatus(GameState.GAME_STATUS_PLAYING);
        for (int i = 0; i < 2; i++) {
            Card playerCard = deck.getCard();
            gameState.getPlayer().addCard(playerCard);

            Card dealerCard = deck.getCard();
            gameState.getDealer().addCard(dealerCard);
        }
        if (gameState.getPlayer().getPoints() == BLACKJACK) {
            if (gameState.getDealer().getPoints() == BLACKJACK) {
                gameState.setGameStatus(GameState.GAME_STATUS_PUSH);
                gameState.setWinSum(betSum);
                return gameState;
            }
            gameState.setGameStatus(GameState.GAME_STATUS_BLACK_JACK);
            gameState.setWinSum(betSum + betSum + betSum / 2);
        }
        return gameState;
    }

    public GameState hit() {
        if (gameState.getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            throw new BlackjackException(2, "Game state is not 'playing'");
        }
        Card playerCard = deck.getCard();
        gameState.getPlayer().addCard(playerCard);
        if (gameState.getPlayer().getPoints() > BLACKJACK) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_BUST);
            gameState.setWinSum(0l);
        }
        return gameState;
    }

    public GameState stand() {
        if (gameState.getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            throw new BlackjackException(2, "Game state is not 'playing'");
        }
        while (gameState.getDealer().getPoints() < 17) {
            Card card = deck.getCard();
            gameState.getDealer().addCard(card);
        }

        if (gameState.getDealer().getPoints() > 21) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_WINS);
            gameState.setWinSum(betSum * 2);
        } else if (gameState.getDealer().getPoints() > gameState.getPlayer().getPoints()) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_LOOSE);
            gameState.setWinSum(0l);
        } else if (gameState.getDealer().getPoints() < gameState.getPlayer().getPoints()) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_WINS);
            gameState.setWinSum(betSum * 2);
        } else if (gameState.getDealer().getPoints() == gameState.getPlayer().getPoints()) {
            gameState.setGameStatus(GameState.GAME_STATUS_PUSH);
            gameState.setWinSum(betSum);
        }
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.makeBet(100);
        game.hit();
        game.stand();
        for (Card card : game.gameState.getPlayer().getCards()) {
            System.out.println(card.toString() + " - " + card.getValue());
        }
        System.out.println("-----");
        for (Card card : game.gameState.getDealer().getCards()) {
            System.out.println(card.toString() + " - " + card.getValue());
        }
        System.out.println(game.gameState.getGameStatus());
        System.out.println(game.gameState.getWinSum());
    }

}
