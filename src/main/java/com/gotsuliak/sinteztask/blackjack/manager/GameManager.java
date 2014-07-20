package com.gotsuliak.sinteztask.blackjack.manager;

import com.gotsuliak.sinteztask.blackjack.entity.Transaction;
import com.gotsuliak.sinteztask.blackjack.logic.BlackjackGame;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GameManager {

    @EJB
    private WalletManager wallet;
    @EJB
    private BlackjackGame game;

    public int startNewGame() {
        return 123;
    }

    public void putMoney(int walletId, long sum) {
        wallet.putMoney(walletId, sum);
    }

    public List<Transaction> getTransactions(int walletId) {
        return wallet.getTransactions(walletId);
    }

    public void makeBet(long betSum) {
        game.makeBet(betSum);
    }

}
