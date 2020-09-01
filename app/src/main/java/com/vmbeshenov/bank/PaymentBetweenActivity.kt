package com.vmbeshenov.bank

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.EditText
import com.vmbeshenov.bank.MainMenu.MainActivity
import com.vmbeshenov.bank.TempData.CardAccounts

class PaymentBetweenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_between)
        val toolbar = findViewById<View>(R.id.toolbar_payment_between) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun onClickPaymentBetween(view: View?) {
        val sum_text = findViewById<View>(R.id.sum_payment_between) as EditText
        val sum = sum_text.text.toString().toDouble()
        if (sum <= CardAccounts.account[0].balance) {
            CardAccounts.account[0].balance = CardAccounts.account[0].balance - sum
            CardAccounts.account[1].balance = CardAccounts.account[1].balance + sum
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}