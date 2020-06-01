package com.diploma.bank.MainMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diploma.bank.R;

public class MainPaymentFragment extends Fragment {

    public MainPaymentFragment() {
    }

    public static MainPaymentFragment newInstance() {
        return new MainPaymentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_payment, container, false);
    }
}