package com.gotsuliak.sinteztask.blackjack.core.manager;

import com.gotsuliak.sinteztask.blackjack.core.entity.Transaction;
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

    public int startNewGame() {
        return 123;
    }

    public void putMoney(int walletId, long sum) {
    }

    public List<Transaction> getTransactions(int walletId) {
        return null;
    }

    public GameState newGame() {
        return game.newGame();
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
