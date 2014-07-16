package com.gotsuliak.sinteztask.blackjack.manager;

import com.gotsuliak.sinteztask.blackjack.entity.Transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GameManager {

    @EJB
    private WalletManager wallet;

    public String startNewGame() {
        return "someWalletId";
    }

    public void putMoney(int walletId, long sum) {
        wallet.putMoney(walletId, sum);
    }

    public List<Transaction> getTransactions(int walletId) {
        return wallet.getTransactions(walletId);
    }

}
