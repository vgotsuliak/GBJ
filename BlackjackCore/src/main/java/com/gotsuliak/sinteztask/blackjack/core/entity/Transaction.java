package com.gotsuliak.sinteztask.blackjack.core.entity;


import javax.persistence.*;

@Entity
public class Transaction {

    public static final int PUT_TYPE = 1;
    public static final int BET_TYPE = 2;
    public static final int WIN_TYPE = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int type;
    private long sum;
    @ManyToOne
    private Wallet wallet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
