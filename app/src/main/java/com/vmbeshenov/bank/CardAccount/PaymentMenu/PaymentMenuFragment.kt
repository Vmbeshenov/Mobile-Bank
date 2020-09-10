package com.vmbeshenov.bank.CardAccount.PaymentMenu

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmbeshenov.bank.CardAccount.CardAccountActionsCardAdapter
import com.vmbeshenov.bank.CardAccount.DataCardViewPayment
import com.vmbeshenov.bank.MainMenu.MainActivity
import com.vmbeshenov.bank.R

class PaymentMenuFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val payment_menu_Recycler = inflater.inflate(
                R.layout.fragment_payment_menu, container, false) as RecyclerView
        val id_card_view_payment = IntArray(DataCardViewPayment.payment_type_CardView.size)
        for (i in id_card_view_payment.indices) {
            id_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].id_card_view_payment
        }
        val title_card_view_payment = IntArray(DataCardViewPayment.payment_type_CardView.size)
        for (i in title_card_view_payment.indices) {
            title_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].title_card_view_payment
        }
        val id_image_card_view_payment = IntArray(DataCardViewPayment.payment_type_CardView.size)
        for (i in id_image_card_view_payment.indices) {
            id_image_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].id_image_card_view_payment
        }
        val background_card_view_payment = IntArray(DataCardViewPayment.payment_type_CardView.size)
        for (i in background_card_view_payment.indices) {
            background_card_view_payment[i] = DataCardViewPayment.payment_type_CardView[i].color_card_view_payment
        }
        val adapter_payment_menu = CardAccountActionsCardAdapter(id_card_view_payment, title_card_view_payment, id_image_card_view_payment, background_card_view_payment)
        payment_menu_Recycler.adapter = adapter_payment_menu
        val layoutManager_payment = LinearLayoutManager(activity)
        payment_menu_Recycler.layoutManager = layoutManager_payment
        adapter_payment_menu.setListener_payment(object : CardAccountActionsCardAdapter.Listener {
            override fun onClick(position: Int) {
                val intent: Intent
                when (id_card_view_payment[position]) {
                    10 -> {
                        intent = Intent(activity, PaymentBetweenActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                    11 -> {
                        intent = Intent(activity, PaymentBetweenActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                    else -> {
                        intent = Intent(activity, MainActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                }
            }
        })
        return payment_menu_Recycler
    }

    companion object {
        fun newInstance(): PaymentMenuFragment {
            return PaymentMenuFragment()
        }
    }
}