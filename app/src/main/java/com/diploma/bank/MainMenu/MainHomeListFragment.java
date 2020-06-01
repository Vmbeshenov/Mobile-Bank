package com.diploma.bank.MainMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;

import com.diploma.bank.Authorization.LoginActivity;
import com.diploma.bank.CardAccountActivity;
import com.diploma.bank.R;
import com.diploma.bank.TempData.CardAccounts;
import com.diploma.bank.TempData.Deposits;

public class MainHomeListFragment extends Fragment {

    public MainHomeListFragment() {
    }

    public static MainHomeListFragment newInstance() {
        return new MainHomeListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView card_account_Recycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_main_home_list, container, false);

        //Список карточных счетов
        final int[] id_card = new int[CardAccounts.account.length];
        for(int i = 0; i < id_card.length; i++){
            id_card[i] = CardAccounts.account[i].getId_card();
        }

        String[] card_names = new String[CardAccounts.account.length];
        for (int i = 0; i < card_names.length; i++) {
            card_names[i] = CardAccounts.account[i].getName_card();
        }

        double[] card_balance = new double[CardAccounts.account.length];
        for (int i = 0; i < card_balance.length; i++) {
            card_balance[i] = CardAccounts.account[i].getBalance();
        }

        int[] ic_images = new int[CardAccounts.account.length];
        for (int i = 0; i < ic_images.length; i++) {
            ic_images[i] = CardAccounts.account[i].getId_image();
        }

        //Список вкладов
        int[] id_deposit = new int[Deposits.deposits.length];
        for(int i = 0; i < id_deposit.length; i++){
            id_deposit[i] = Deposits.deposits[i].getId_deposit();
        }

        String[] deposit_name = new String[Deposits.deposits.length];
        for (int i = 0; i < deposit_name.length; i++) {
            deposit_name[i] = Deposits.deposits[i].getDeposit_name();
        }

        double[] deposit_balance = new double[Deposits.deposits.length];
        for (int i = 0; i < deposit_balance.length; i++) {
            deposit_balance[i] = Deposits.deposits[i].getDeposit_balance();
        }

        int[] deposit_id_image = new int[Deposits.deposits.length];
        for (int i = 0; i < deposit_id_image.length; i++) {
            deposit_id_image[i] = Deposits.deposits[i].getDeposit_id_image();
        }

        MainHomeListAdapter adapter_main_home_list = new MainHomeListAdapter(id_card, card_names, card_balance, ic_images,
                id_deposit, deposit_name, deposit_balance, deposit_id_image);
        card_account_Recycler.setAdapter(adapter_main_home_list);
        LinearLayoutManager layoutManager_main_home_list = new LinearLayoutManager(getActivity());
        card_account_Recycler.setLayoutManager(layoutManager_main_home_list);

        adapter_main_home_list.setListener(new MainHomeListAdapter.Listener(){
            public void onClick(int position) {
                if (position > id_card.length){
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getActivity(), CardAccountActivity.class);
                    intent.putExtra(CardAccountActivity.EXTRA_BANK_ACC_ID, position);
                    getActivity().startActivity(intent);
                }
            }
        });

        return card_account_Recycler;
    }
}