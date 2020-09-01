package com.vmbeshenov.bank.MainMenu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmbeshenov.bank.R

class MainAdditionalFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_additional, container, false)
    }

    companion object {
        fun newInstance(): MainAdditionalFragment {
            return MainAdditionalFragment()
        }
    }
}