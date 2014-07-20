package com.gotsuliak.sinteztask.blackjack.core.logic;


import com.gotsuliak.sinteztask.blackjack.core.entity.Transaction;
import com.gotsuliak.sinteztask.blackjack.core.entity.Wallet;

public class WalletManager {

    public Wallet newWallet() {
        Wallet wallet = new Wallet();
        wallet.setId(12345);
        wallet.setSum(0);
        return wallet;
    }

    public Wallet getWallet(int walletId) {
        Wallet wallet = new Wallet();
        wallet.setId(123);
        wallet.setSum(2000);
        return wallet;
    }

    public void putMoney(int walletId, long sum) {
    }

    public void storeTransaction(Transaction transaction) {
    }

    public void getTransactions(int walletId) {
    }

}
