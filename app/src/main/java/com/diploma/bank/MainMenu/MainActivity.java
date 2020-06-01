package com.diploma.bank.MainMenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.diploma.bank.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(MainHomeFragment.newInstance());
    }

    //Нижняя панель навигации
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home:
                    loadFragment(MainHomeFragment.newInstance());
                    return true;
                case R.id.action_payment:
                    loadFragment(MainPaymentFragment.newInstance());
                    return true;
                case R.id.action_history:
                    loadFragment(MainHistoryFragment.newInstance());
                    return true;
                case R.id.action_more:
                    loadFragment(MainAdditionalFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    //Загрузка фрагмента
    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }
}