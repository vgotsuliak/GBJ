package com.gotsuliak.sinteztask.blackjack.core.logic;

import com.gotsuliak.sinteztask.blackjack.core.entity.Transaction;
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
        if (game.getGameState().getGameStatus() != GameState.GAME_STATUS_WAITING_BET) {
            throw BlackjackException.BET_IS_ALREADY_MADE;
        } else if (game.getGameState().getWallet().getSum() < betSum) {
            throw BlackjackException.NOT_ENOUGH_MONEY;
        }
        GameState state = game.makeBet(betSum);
        Wallet wallet = state.getWallet();
        wallet.setSum(wallet.getSum() - betSum);
        walletManager.setMoney(wallet);
        storeTransaction(wallet, betSum, Transaction.BET_TYPE);
        if (state.getGameStatus() != GameState.GAME_STATUS_PLAYING
                && state.getGameStatus() != GameState.GAME_STATUS_WAITING_BET) {
            wallet.setSum(state.getWallet().getSum() + state.getWinSum());
            walletManager.setMoney(wallet);
        }
        return state;
    }

    public GameState hit() {
        if (game.getGameState().getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            throw BlackjackException.WRONG_GAME_STATE;
        }
        GameState gameState = game.hit();
        if (gameState.getGameStatus() != GameState.GAME_STATUS_WAITING_BET
                && gameState.getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            gameState.getWallet().setSum(gameState.getWallet().getSum() + gameState.getWinSum());
            storeTransaction(gameState.getWallet(), gameState.getWinSum(), Transaction.WIN_TYPE);
        }
        walletManager.setMoney(gameState.getWallet());
        return gameState;
    }

    public GameState stand() {
        if (game.getGameState().getGameStatus() != GameState.GAME_STATUS_PLAYING) {
            throw BlackjackException.WRONG_GAME_STATE;
        }
        GameState gameState = game.stand();
        gameState.getWallet().setSum(gameState.getWallet().getSum() + gameState.getWinSum());
        walletManager.setMoney(gameState.getWallet());
        storeTransaction(gameState.getWallet(), gameState.getWinSum(), Transaction.WIN_TYPE);
        return gameState;
    }

    public void storeTransaction(Wallet wallet, long transactionSum, int transactionType) {
        Transaction transaction = new Transaction();
        transaction.setWallet(wallet);
        transaction.setSum(transactionSum);
        transaction.setType(transactionType);
        walletManager.storeTransaction(transaction);
    }

}
