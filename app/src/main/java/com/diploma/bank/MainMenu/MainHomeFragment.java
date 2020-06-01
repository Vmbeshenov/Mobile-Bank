package com.diploma.bank.MainMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diploma.bank.R;

public class MainHomeFragment extends Fragment {

    public MainHomeFragment() {
    }

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_home_fragment = inflater.inflate(R.layout.fragment_main_home, container, false);
        Toolbar toolbar_main_home = (Toolbar) view_home_fragment.findViewById(R.id.toolbar_main_home);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_main_home);
        loadFragment(MainHomeListFragment.newInstance());
        return view_home_fragment;
    }

    //Загрузка фрагмента
    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = ((AppCompatActivity)getActivity()).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content_products, fragment);
        ft.commit();
    }
}
