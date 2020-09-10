package com.vmbeshenov.bank.Authorization

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import com.vmbeshenov.bank.MainMenu.MainActivity
import com.vmbeshenov.bank.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickAuthorization(view: View?) {
        val loginText = findViewById<View>(R.id.login_text) as EditText
        val login = loginText.text.toString()
        val passwordText = findViewById<View>(R.id.password_text) as EditText
        val password = passwordText.text.toString()
        if (UserAccountControl.checkUser(login, password)) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}