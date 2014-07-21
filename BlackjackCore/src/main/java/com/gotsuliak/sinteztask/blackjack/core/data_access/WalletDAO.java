package com.gotsuliak.sinteztask.blackjack.core.data_access;

import com.gotsuliak.sinteztask.blackjack.core.entity.Wallet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
