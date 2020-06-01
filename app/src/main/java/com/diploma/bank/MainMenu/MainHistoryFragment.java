package com.diploma.bank.MainMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diploma.bank.R;

public class MainHistoryFragment extends Fragment {

    public MainHistoryFragment() {
    }

    public static MainHistoryFragment newInstance() {
        return new MainHistoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_history, container, false);
    }
}