package com.vmbeshenov.bank.CardAccount

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmbeshenov.bank.MainMenu.MainActivity
import com.vmbeshenov.bank.R
import com.vmbeshenov.bank.TempData.HistoryOperations

class CardAccountHistoryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val history_card_Recycler = inflater.inflate(
                R.layout.fragment_card_account_history, container, false) as RecyclerView
        val sum = DoubleArray(HistoryOperations.history_card.size)
        for (i in sum.indices) {
            sum[i] = HistoryOperations.history_card[i].sum
        }
        val category = arrayOfNulls<String>(HistoryOperations.history_card.size)
        for (i in category.indices) {
            category[i] = HistoryOperations.history_card[i].category
        }
        val title = arrayOfNulls<String>(HistoryOperations.history_card.size)
        for (i in title.indices) {
            title[i] = HistoryOperations.history_card[i].title_operation
        }
        val date = arrayOfNulls<String>(HistoryOperations.history_card.size)
        for (i in date.indices) {
            date[i] = HistoryOperations.history_card[i].date_operation
        }
        val adapter_card_acc_history = CardAccountHistoryCardAdapter(sum, category, title, date)
        history_card_Recycler.adapter = adapter_card_acc_history
        val layoutManager = LinearLayoutManager(activity)
        history_card_Recycler.layoutManager = layoutManager
        adapter_card_acc_history.setListener_history(object : CardAccountHistoryCardAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, MainActivity::class.java)
                activity!!.startActivity(intent)
            }
        })
        return history_card_Recycler
    }
}