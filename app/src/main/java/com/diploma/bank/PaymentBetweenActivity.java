package com.diploma.bank;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.diploma.bank.MainMenu.MainActivity;
import com.diploma.bank.TempData.CardAccounts;

public class PaymentBetweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_between);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_payment_between);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClickPaymentBetween(View view){
        EditText sum_text = (EditText) findViewById(R.id.sum_payment_between);
        double sum = Double.parseDouble(sum_text.getText().toString());

        if (sum <= CardAccounts.account[0].getBalance()) {
            CardAccounts.account[0].setBalance(CardAccounts.account[0].getBalance() - sum);
            CardAccounts.account[1].setBalance(CardAccounts.account[1].getBalance() + sum);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
