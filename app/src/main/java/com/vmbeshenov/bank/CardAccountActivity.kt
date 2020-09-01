package com.vmbeshenov.bank

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.vmbeshenov.bank.TempData.CardAccounts

class CardAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_account)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        val bank_acc_Id = intent.extras!![EXTRA_BANK_ACC_ID] as Int
        val textView_title_sum = findViewById<View>(R.id.card_sum_text) as TextView
        val textView_title_sum_small = findViewById<View>(R.id.card_sum_small_text) as TextView
        var balance_temp = Math.floor(CardAccounts.account[bank_acc_Id].balance).toLong()
        textView_title_sum.text = String.format("%, d", balance_temp)
        balance_temp = Math.round(CardAccounts.account[bank_acc_Id].balance % 1 * 100)
        var balance_str = ","
        balance_str += java.lang.Long.toString(balance_temp)
        textView_title_sum_small.text = balance_str
        val textView_toolbar_title = findViewById<View>(R.id.toolbar_title) as TextView
        textView_toolbar_title.text = CardAccounts.account[bank_acc_Id].name_card

        //Связывание SectionsPagerAdapter с ViewPager
        val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val pager = findViewById<View>(R.id.pager) as ViewPager
        pager.adapter = pagerAdapter

        //Связывание ViewPager с TabLayout
        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(pager)
    }

    private inner class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return CardAccountActionsFragment()
                1 -> return CardAccountHistoryFragment()
                2 -> return CardAccountSettingsFragment()
            }
            return null
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return resources.getText(R.string.card_actions)
                1 -> return resources.getText(R.string.card_history)
                2 -> return resources.getText(R.string.card_settings)
            }
            return null
        }
    }

    companion object {
        const val EXTRA_BANK_ACC_ID = "bankAccId"
    }
}