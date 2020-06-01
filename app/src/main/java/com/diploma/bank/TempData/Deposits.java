package com.diploma.bank.TempData;

import com.diploma.bank.R;

public class Deposits {

    private int id_deposit;
    private String deposit_name;
    private double deposit_balance;
    private int deposit_id_image;

    public static Deposits[] deposits = {
            new Deposits(10, "Сберегательный вклад", 52000, R.drawable.ic_main_deposit),
            new Deposits(20, "Вклад \"Подари жизнь\"", 102750.21, R.drawable.ic_main_deposit)
    };

    private Deposits(int id_deposit, String deposit_name, double deposit_balance, int deposit_id_image){
        this.id_deposit = id_deposit;
        this.deposit_name = deposit_name;
        this.deposit_balance = deposit_balance;
        this.deposit_id_image = deposit_id_image;
    }

    public int getId_deposit() {
        return id_deposit;
    }

    public String getDeposit_name() {
        return deposit_name;
    }

    public double getDeposit_balance() {
        return deposit_balance;
    }

    public int getDeposit_id_image() {
        return deposit_id_image;
    }
}