package com.gotsuliak.sinteztask.blackjack.ws.container.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "depositRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositRequest {

    @XmlAttribute(name = "walletId")
    private int walletId;
    @XmlAttribute(name = "sum")
    private long sum;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
