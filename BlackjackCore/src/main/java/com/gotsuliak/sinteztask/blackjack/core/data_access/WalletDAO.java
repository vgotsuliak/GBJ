package com.gotsuliak.sinteztask.blackjack.core.data_access;

import com.gotsuliak.sinteztask.blackjack.core.entity.Transaction;
import com.gotsuliak.sinteztask.blackjack.core.entity.Wallet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class WalletDAO {

    @PersistenceContext(unitName = "GBJ")
    private EntityManager entityManager;

    public Wallet newWallet() {
        return entityManager.merge(new Wallet());
    }

    public Wallet updateSum(Wallet wallet) {
        return entityManager.merge(wallet);
    }

    public Wallet getWallet(Wallet wallet) {
        return entityManager.find(Wallet.class, wallet.getId());
    }

    public Transaction addTransaction(Transaction transaction) {
        return entityManager.merge(transaction);
    }

    public List<Transaction> getTransactions(Transaction transaction) {
        TypedQuery<Transaction> query = entityManager.createQuery("select t from Transaction t where t.wallet = :walletId", Transaction.class);
        query.setParameter("walletId", transaction.getWallet());
        List<Transaction> resultList = query.getResultList();
        return resultList;
    }

}
