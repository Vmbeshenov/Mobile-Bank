package com.vmbeshenov.bank.MainMenu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmbeshenov.bank.R

class MainHomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewHomeFragment = inflater.inflate(R.layout.fragment_main_home, container, false)
        val toolbarMainHome = viewHomeFragment.findViewById<View>(R.id.toolbar_main_home) as Toolbar
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbarMainHome)
        loadFragment(MainHomeListFragment.newInstance())
        return viewHomeFragment
    }

    //Загрузка фрагмента
    private fun loadFragment(fragment: Fragment) {
        val ft = (activity as AppCompatActivity?)!!.supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content_products, fragment)
        ft.commit()
    }

    companion object {
        fun newInstance(): MainHomeFragment {
            return MainHomeFragment()
        }
    }
}