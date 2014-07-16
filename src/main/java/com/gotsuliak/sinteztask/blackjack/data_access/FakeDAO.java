package com.gotsuliak.sinteztask.blackjack.data_access;

import com.gotsuliak.sinteztask.blackjack.entity.Transaction;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class FakeDAO {

    private static List<Transaction> transactions = new ArrayList<>();

    public void storeTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions(int walletId) {
        List<Transaction> walletTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            walletTransactions.add(transaction);
        }
        return walletTransactions;
    }

}
