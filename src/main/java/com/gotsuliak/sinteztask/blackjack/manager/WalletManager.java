package com.gotsuliak.sinteztask.blackjack.manager;

import com.gotsuliak.sinteztask.blackjack.data_access.FakeDAO;
import com.gotsuliak.sinteztask.blackjack.entity.Transaction;
import com.gotsuliak.sinteztask.blackjack.entity.TransactionType;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class WalletManager {

    @EJB
    private FakeDAO dao;

    public void putMoney(int walletId, long sum) {
        Transaction transaction = new Transaction();
        transaction.setSum(sum);
        transaction.setType(TransactionType.PUT.getId());
        dao.storeTransaction(transaction);
    }

    public List<Transaction> getTransactions(int walletId) {
        return dao.getTransactions(walletId);
    }

}
