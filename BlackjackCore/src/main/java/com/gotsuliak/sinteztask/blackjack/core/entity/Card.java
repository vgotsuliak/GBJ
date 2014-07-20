package com.gotsuliak.sinteztask.blackjack.core.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "card")
@XmlAccessorType(XmlAccessType.FIELD)
public class Card {

    private int id;
    private int value;
    private String name;

    public Card(int id, int value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
