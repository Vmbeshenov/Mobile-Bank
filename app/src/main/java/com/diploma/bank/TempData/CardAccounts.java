package com.diploma.bank.TempData;

import com.diploma.bank.R;

public class CardAccounts {

    private int id_card;
    private String name_card;
    private double balance;
    private int id_image;

    public static CardAccounts[] account = {
            new CardAccounts(100, "Mastercard", 12709.75, R.drawable.ic_main_card),
            new CardAccounts(200, "Visa", 29305.91, R.drawable.ic_main_card)};

    private CardAccounts(int id_card, String name_card, double balance, int id_image){
        this.id_card = id_card;
        this.name_card = name_card;
        this.balance = balance;
        this.id_image = id_image;
    }

    public int getId_card() {
        return id_card;
    }

    public String getName_card() {
        return name_card;
    }

    public double getBalance() {
        return balance;
    }

    public int getId_image() {
        return id_image;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
