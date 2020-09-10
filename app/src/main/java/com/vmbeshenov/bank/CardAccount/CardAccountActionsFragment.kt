package com.vmbeshenov.bank.CardAccount

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmbeshenov.bank.CardAccount.PaymentMenu.PaymentMenuActivity
import com.vmbeshenov.bank.MainMenu.MainActivity
import com.vmbeshenov.bank.R

class CardAccountActionsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val actions_card_Recycler = inflater.inflate(
                R.layout.fragment_card_account_actions, container, false) as RecyclerView
        val id_card_view_payment = IntArray(DataCardViewPayment.payment_CardView.size)
        for (i in id_card_view_payment.indices) {
            id_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].id_card_view_payment
        }
        val title_card_view_payment = IntArray(DataCardViewPayment.payment_CardView.size)
        for (i in title_card_view_payment.indices) {
            title_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].title_card_view_payment
        }
        val id_image_card_view_payment = IntArray(DataCardViewPayment.payment_CardView.size)
        for (i in id_image_card_view_payment.indices) {
            id_image_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].id_image_card_view_payment
        }
        val background_card_view_payment = IntArray(DataCardViewPayment.payment_CardView.size)
        for (i in background_card_view_payment.indices) {
            background_card_view_payment[i] = DataCardViewPayment.payment_CardView[i].color_card_view_payment
        }
        val adapter_payment = CardAccountActionsCardAdapter(id_card_view_payment, title_card_view_payment, id_image_card_view_payment, background_card_view_payment)
        actions_card_Recycler.adapter = adapter_payment
        val layoutManager_payment = GridLayoutManager(activity, 2)
        actions_card_Recycler.layoutManager = layoutManager_payment
        adapter_payment.setListener_payment(object : CardAccountActionsCardAdapter.Listener {
            override fun onClick(position: Int) {
                val intent: Intent
                when (id_card_view_payment[position]) {
                    1 -> {
                        intent = Intent(activity, PaymentMenuActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                    2 -> {
                        intent = Intent(activity, PaymentMenuActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                    3 -> {
                        intent = Intent(activity, PaymentMenuActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                    4 -> {
                        intent = Intent(activity, PaymentMenuActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                    else -> {
                        intent = Intent(activity, MainActivity::class.java)
                        activity!!.startActivity(intent)
                    }
                }
            }
        })
        return actions_card_Recycler
    }
}