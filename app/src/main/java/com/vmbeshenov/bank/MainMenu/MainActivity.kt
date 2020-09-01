package com.vmbeshenov.bank.MainMenu

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.vmbeshenov.bank.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadFragment(MainHomeFragment.newInstance())
    }

    //Нижняя панель навигации
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_home -> {
                loadFragment(MainHomeFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_payment -> {
                loadFragment(MainPaymentFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_history -> {
                loadFragment(MainHistoryFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_more -> {
                loadFragment(MainAdditionalFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    //Загрузка фрагмента
    private fun loadFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, fragment)
        ft.commit()
    }
}