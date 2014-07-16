package com.gotsuliak.sinteztask.blackjack.data_access;

import com.gotsuliak.sinteztask.blackjack.entity.Transaction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DAO {

    @PersistenceContext(unitName = "GBJ")
    private EntityManager entityManager;

    public void storeTransaction(Transaction transaction) {
        entityManager.persist(transaction);
    }

}
