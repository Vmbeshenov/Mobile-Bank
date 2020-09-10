package com.vmbeshenov.bank.CardAccount

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vmbeshenov.bank.CardAccount.CardAccountHistoryCardAdapter.ViewHolder_CardAccHistory
import com.vmbeshenov.bank.R

internal class CardAccountHistoryCardAdapter(private val sum: DoubleArray, private val category: Array<String?>, private val title_operation: Array<String?>, private val date_operation: Array<String?>) : RecyclerView.Adapter<ViewHolder_CardAccHistory>() {
    private var listener_history: Listener? = null

    internal interface Listener {
        fun onClick(position: Int)
    }

    fun setListener_history(listener_history: Listener?) {
        this.listener_history = listener_history
    }

    class ViewHolder_CardAccHistory(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun getItemCount(): Int {
        return title_operation.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_CardAccHistory {
        val cv = LayoutInflater.from(parent.context)
                .inflate(R.layout.cardview_card_account_history, parent, false) as CardView
        return ViewHolder_CardAccHistory(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder_CardAccHistory, position: Int) {
        val cardView_CardAccHistory = holder.cardView
        val sum_textView = cardView_CardAccHistory.findViewById<View>(R.id.info_history_sum) as TextView
        sum_textView.text = java.lang.Double.toString(sum[position])
        val category_textView = cardView_CardAccHistory.findViewById<View>(R.id.info_history_category) as TextView
        category_textView.text = category[position]
        val title_textView = cardView_CardAccHistory.findViewById<View>(R.id.info_history_title_operation) as TextView
        title_textView.text = title_operation[position]
        val date_textView = cardView_CardAccHistory.findViewById<View>(R.id.info_history_date) as TextView
        date_textView.text = date_operation[position]
        cardView_CardAccHistory.setOnClickListener {
            if (listener_history != null) {
                listener_history!!.onClick(position)
            }
        }
    }
}