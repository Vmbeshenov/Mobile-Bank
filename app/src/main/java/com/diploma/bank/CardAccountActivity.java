package com.diploma.bank;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.design.widget.TabLayout;
import android.widget.TextView;

import com.diploma.bank.TempData.CardAccounts;

public class CardAccountActivity extends AppCompatActivity {

    public static final String EXTRA_BANK_ACC_ID = "bankAccId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int bank_acc_Id = (Integer)getIntent().getExtras().get(EXTRA_BANK_ACC_ID);
        TextView textView_title_sum = (TextView)findViewById(R.id.card_sum_text);
        TextView textView_title_sum_small = (TextView)findViewById(R.id.card_sum_small_text);

        long balance_temp = (long) Math.floor(CardAccounts.account[bank_acc_Id].getBalance());
        textView_title_sum.setText(String.format("%, d", balance_temp));

        balance_temp = Math.round((CardAccounts.account[bank_acc_Id].getBalance() % 1) * 100);
        String balance_str = ",";
        balance_str += Long.toString(balance_temp);
        textView_title_sum_small.setText(balance_str);

        TextView textView_toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        textView_toolbar_title.setText(CardAccounts.account[bank_acc_Id].getName_card());

        //Связывание SectionsPagerAdapter с ViewPager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        //Связывание ViewPager с TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CardAccountActionsFragment();
                case 1:
                    return new CardAccountHistoryFragment();
                case 2:
                    return new CardAccountSettingsFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.card_actions);
                case 1:
                    return getResources().getText(R.string.card_history);
                case 2:
                    return getResources().getText(R.string.card_settings);
            }
            return null;
        }
    }
}
