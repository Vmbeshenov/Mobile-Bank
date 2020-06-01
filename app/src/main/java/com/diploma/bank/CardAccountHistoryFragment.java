package com.diploma.bank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diploma.bank.MainMenu.MainActivity;
import com.diploma.bank.TempData.HistoryOperations;

public class CardAccountHistoryFragment extends Fragment {

    public CardAccountHistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView history_card_Recycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_card_account_history, container, false);

        double[] sum = new double[HistoryOperations.history_card.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = HistoryOperations.history_card[i].getSum();
        }

        String[] category = new String[HistoryOperations.history_card.length];
        for (int i = 0; i < category.length; i++) {
            category[i] = HistoryOperations.history_card[i].getCategory();
        }

        String[] title = new String[HistoryOperations.history_card.length];
        for (int i = 0; i < title.length; i++) {
            title[i] = HistoryOperations.history_card[i].getTitle_operation();
        }

        String[] date = new String[HistoryOperations.history_card.length];
        for (int i = 0; i < date.length; i++) {
            date[i] = HistoryOperations.history_card[i].getDate_operation();
        }

        CardAccountHistoryCardAdapter adapter_card_acc_history = new CardAccountHistoryCardAdapter(sum, category, title, date);
        history_card_Recycler.setAdapter(adapter_card_acc_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        history_card_Recycler.setLayoutManager(layoutManager);

        adapter_card_acc_history.setListener_history(new CardAccountHistoryCardAdapter.Listener(){
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return history_card_Recycler;
    }
}