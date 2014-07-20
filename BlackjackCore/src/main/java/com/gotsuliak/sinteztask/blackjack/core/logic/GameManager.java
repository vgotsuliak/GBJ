package com.gotsuliak.sinteztask.blackjack.core.logic;

import com.gotsuliak.sinteztask.blackjack.core.entity.Transaction;
import com.gotsuliak.sinteztask.blackjack.core.entity.Wallet;
import com.gotsuliak.sinteztask.blackjack.core.logic.BlackjackGame;
import com.gotsuliak.sinteztask.blackjack.core.logic.GameState;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

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
        return game.makeBet(betSum);
    }

    public GameState hit() {
        return game.hit();
    }

    public GameState stand() {
        return game.stand();
    }

}
