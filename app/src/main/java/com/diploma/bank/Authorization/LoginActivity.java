package com.diploma.bank.Authorization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.diploma.bank.MainMenu.MainActivity;
import com.diploma.bank.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickAuthorization(View view){

        EditText login_text = (EditText) findViewById(R.id.login_text);
        String login = login_text.getText().toString();

        EditText password_text = (EditText) findViewById(R.id.password_text);
        String password = password_text.getText().toString();

        if(UserAccountControl.CheckUser(login, password)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}