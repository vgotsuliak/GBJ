package com.gotsuliak.sinteztask.blackjack.logic;

import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateless
public class BlackjackGame {

    private final static int BLACKJACK = 21;
    private Deck deck;
    private GameState gameState;
    private long betSum;

    private void initDeck() {
        deck = new Deck();
        deck.init();
        deck.shuffle();
    }

    public GameState makeBet(long betSum) {
        initDeck();
        this.betSum = betSum;
        gameState = new GameState();
        for (int i = 0; i < 2; i++) {
            Card playerCard = deck.getCard();
            gameState.getPlayer().addCard(playerCard);

            Card dealerCard = deck.getCard();
            gameState.getDealer().addCard(dealerCard);
        }
        return gameState;
    }

    public GameState hit() {
        if (gameState.getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            throw new IllegalStateException("Illegal state of the game");
        }
        Card playerCard = deck.getCard();
        gameState.getPlayer().addCard(playerCard);
        if (gameState.getPlayer().getPoints() > BLACKJACK) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_BUST);
        }
        return gameState;
    }

    public GameState stand() {
        if (gameState.getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            throw new IllegalStateException("Illegal state of the game");
        }
        while (gameState.getDealer().getPoints() < 17) {
            Card card = deck.getCard();
            gameState.getDealer().addCard(card);
        }

        if (gameState.getDealer().getPoints() > 21) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_WINS);
        } else if (gameState.getDealer().getPoints() > gameState.getPlayer().getPoints()) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_LOOSE);
        } else if (gameState.getDealer().getPoints() < gameState.getPlayer().getPoints()) {
            gameState.setGameStatus(GameState.GAME_STATUS_PLAYER_WINS);
        } else if (gameState.getDealer().getPoints() == gameState.getPlayer().getPoints()) {
            gameState.setGameStatus(GameState.GAME_STATUS_PUSH);
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
    }

}
