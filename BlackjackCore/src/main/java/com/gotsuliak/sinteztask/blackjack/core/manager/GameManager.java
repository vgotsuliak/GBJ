package com.gotsuliak.sinteztask.blackjack.core.manager;

import com.gotsuliak.sinteztask.blackjack.core.entity.Transaction;
import com.gotsuliak.sinteztask.blackjack.core.logic.BlackjackGame;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GameManager {

    @EJB
    private BlackjackGame game;

    public int startNewGame() {
        return 123;
    }

    public void putMoney(int walletId, long sum) {
    }

    public List<Transaction> getTransactions(int walletId) {
        return null;
    }

    public void makeBet(long betSum) {
        game.makeBet(betSum);
    }

}
