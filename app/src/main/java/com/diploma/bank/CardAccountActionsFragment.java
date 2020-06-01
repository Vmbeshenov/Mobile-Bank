package com.diploma.bank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diploma.bank.MainMenu.MainActivity;

public class CardAccountActionsFragment extends Fragment {

    public CardAccountActionsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView actions_card_Recycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_card_account_actions, container, false);

        final int[] id_card_view_payment = new int[DataCardViewPayment.payment_CardView.length];
        for (int i = 0; i < id_card_view_payment.length; i++) {
            id_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].getId_card_view_payment();
        }

        int[] title_card_view_payment = new int[DataCardViewPayment.payment_CardView.length];
        for (int i = 0; i < title_card_view_payment.length; i++) {
            title_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].getTitle_card_view_payment();
        }

        int[] id_image_card_view_payment = new int[DataCardViewPayment.payment_CardView.length];
        for (int i = 0; i < id_image_card_view_payment.length; i++) {
            id_image_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].getId_image_card_view_payment();
        }

        int[] background_card_view_payment = new int[DataCardViewPayment.payment_CardView.length];
        for (int i = 0; i < background_card_view_payment.length; i++) {
            background_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].getColor_card_view_payment();
        }

        CardAccountActionsCardAdapter adapter_payment = new CardAccountActionsCardAdapter(id_card_view_payment, title_card_view_payment, id_image_card_view_payment, background_card_view_payment);
        actions_card_Recycler.setAdapter(adapter_payment);

        GridLayoutManager layoutManager_payment = new GridLayoutManager(getActivity(), 2);
        actions_card_Recycler.setLayoutManager(layoutManager_payment);

        adapter_payment.setListener_payment(new CardAccountActionsCardAdapter.Listener(){
            public void onClick(int position) {
                Intent intent;
                switch(id_card_view_payment[position]){
                    case 1: intent = new Intent(getActivity(), PaymentMenuActivity.class);
                        getActivity().startActivity(intent);
                        break;
                    case 2: intent = new Intent(getActivity(), PaymentMenuActivity.class);
                        getActivity().startActivity(intent);
                        break;
                    case 3: intent = new Intent(getActivity(), PaymentMenuActivity.class);
                        getActivity().startActivity(intent);
                        break;
                    case 4: intent = new Intent(getActivity(), PaymentMenuActivity.class);
                        getActivity().startActivity(intent);
                        break;
                    default: intent = new Intent(getActivity(), MainActivity.class);
                        getActivity().startActivity(intent);
                        break;
                }
            }
        });
        return actions_card_Recycler;
    }
}