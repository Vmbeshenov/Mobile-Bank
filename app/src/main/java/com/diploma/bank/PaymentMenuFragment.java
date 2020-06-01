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

public class PaymentMenuFragment extends Fragment {

    public PaymentMenuFragment() {
    }

    public static PaymentMenuFragment newInstance() {
        return new PaymentMenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView payment_menu_Recycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_payment_menu, container, false);

        final int[] id_card_view_payment = new int[DataCardViewPayment.payment_type_CardView.length];
        for (int i = 0; i < id_card_view_payment.length; i++) {
            id_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].getId_card_view_payment();
        }

        int[] title_card_view_payment = new int[DataCardViewPayment.payment_type_CardView.length];
        for (int i = 0; i < title_card_view_payment.length; i++) {
            title_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].getTitle_card_view_payment();
        }

        int[] id_image_card_view_payment = new int[DataCardViewPayment.payment_type_CardView.length];
        for (int i = 0; i < id_image_card_view_payment.length; i++) {
            id_image_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].getId_image_card_view_payment();
        }

        int[] background_card_view_payment = new int[DataCardViewPayment.payment_type_CardView.length];
        for (int i = 0; i < background_card_view_payment.length; i++) {
            background_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].getColor_card_view_payment();
        }

        CardAccountActionsCardAdapter adapter_payment_menu = new CardAccountActionsCardAdapter(id_card_view_payment, title_card_view_payment, id_image_card_view_payment, background_card_view_payment);
        payment_menu_Recycler.setAdapter(adapter_payment_menu);

        LinearLayoutManager layoutManager_payment = new LinearLayoutManager(getActivity());
        payment_menu_Recycler.setLayoutManager(layoutManager_payment);

        adapter_payment_menu.setListener_payment(new CardAccountActionsCardAdapter.Listener(){
            public void onClick(int position) {
                Intent intent;
                switch(id_card_view_payment[position]){
                    case 10: intent = new Intent(getActivity(), PaymentBetweenActivity.class);
                        getActivity().startActivity(intent);
                        break;
                    case 11: intent = new Intent(getActivity(), PaymentBetweenActivity.class);
                        getActivity().startActivity(intent);
                        break;
                    default: intent = new Intent(getActivity(), MainActivity.class);
                        getActivity().startActivity(intent);
                        break;
                }
            }
        });
        return payment_menu_Recycler;
    }
}
