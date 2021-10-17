package com.example.demo.entities;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name="card")
public class Card {

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    @Id
    @Column(name = "card_no")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cardNo;

    private String name;

    @Override
    public String toString() {
        return "Card{" +
                "cardNo=" + cardNo +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
