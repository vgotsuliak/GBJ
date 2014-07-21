package com.gotsuliak.sinteztask.blackjack.core.logic;

import com.gotsuliak.sinteztask.blackjack.core.entity.Wallet;
import com.gotsuliak.sinteztask.blackjack.core.exception.BlackjackException;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class GameManager implements Serializable {

    @Inject
    private BlackjackGame game;
    @EJB
    private WalletManager walletManager;

    public GameState newGame(int walletId) {
        Wallet wallet = walletManager.getWallet(walletId);
        return game.newGame(wallet);
    }

    public GameState makeBet(long betSum) {
        GameState state = game.makeBet(betSum);
        Wallet wallet = state.getWallet();
        if (wallet.getSum() < betSum) {
            throw BlackjackException.NOT_ENOUGH_MONEY;
        }
        wallet.setSum(wallet.getSum() - betSum);
        walletManager.setMoney(wallet);
        if (state.getGameStatus() != GameState.GAME_STATUS_PLAYING
                && state.getGameStatus() != GameState.GAME_STATUS_WAITING_BET) {
            wallet.setSum(state.getWallet().getSum() + state.getWinSum());
            walletManager.setMoney(wallet);
        }
        return state;
    }

    public GameState hit() {
        GameState gameState = game.hit();
        if (gameState.getGameStatus() != GameState.GAME_STATUS_WAITING_BET
                && gameState.getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            gameState.getWallet().setSum(gameState.getWallet().getSum() + gameState.getWinSum());
        }
        walletManager.setMoney(gameState.getWallet());
        return gameState;
    }

    public GameState stand() {
        GameState gameState = game.stand();
        gameState.getWallet().setSum(gameState.getWallet().getSum() + gameState.getWinSum());
        walletManager.setMoney(gameState.getWallet());
        return gameState;
    }

}
