package com.gotsuliak.sinteztask.blackjack.core.logic;


import com.gotsuliak.sinteztask.blackjack.core.data_access.WalletDAO;
import com.gotsuliak.sinteztask.blackjack.core.entity.Transaction;
import com.gotsuliak.sinteztask.blackjack.core.entity.Wallet;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class WalletManager {

    @EJB
    private WalletDAO walletDAO;

    public Wallet newWallet() {
        return walletDAO.newWallet();
    }

    public Wallet getWallet(int walletId) {
        Wallet wallet = new Wallet();
        wallet.setId(walletId);
        return walletDAO.getWallet(wallet);
    }

    public Wallet setMoney(Wallet wallet) {
        return walletDAO.updateSum(wallet);
    }

    public Wallet putMoney(int walletId, long sum) {
        Wallet wallet = new Wallet();
        wallet.setId(walletId);
        wallet.setSum(sum);
        Wallet storedWallet = walletDAO.getWallet(wallet);
        storedWallet.setSum(storedWallet.getSum() + sum);
        return walletDAO.updateSum(storedWallet);
    }

    public Transaction storeTransaction(Transaction transaction) {
        return walletDAO.addTransaction(transaction);
    }

    public List<Transaction> getTransactions(int walletId) {
        Transaction transaction = new Transaction();
        Wallet wallet = new Wallet();
        wallet.setId(walletId);
        transaction.setWallet(wallet);
        return walletDAO.getTransactions(transaction);
    }

}
