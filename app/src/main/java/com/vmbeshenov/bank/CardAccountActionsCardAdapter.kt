package com.vmbeshenov.bank

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.vmbeshenov.bank.CardAccountActionsCardAdapter.ViewHolderPayment

internal class CardAccountActionsCardAdapter(private val id_card_view_payment: IntArray, private val title_card_view_payment: IntArray, private val id_image_card_view_payment: IntArray, private val color_card_view_payment: IntArray) : RecyclerView.Adapter<ViewHolderPayment>() {
    private var listener_payment: Listener? = null

    internal interface Listener {
        fun onClick(position: Int)
    }

    fun setListener_payment(listener_payment: Listener?) {
        this.listener_payment = listener_payment
    }

    class ViewHolderPayment(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun getItemCount(): Int {
        return id_card_view_payment.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPayment {
        val cv = LayoutInflater.from(parent.context)
                .inflate(R.layout.cardview_payment, parent, false) as CardView
        return ViewHolderPayment(cv)
    }

    override fun onBindViewHolder(holder: ViewHolderPayment, position: Int) {
        val cardView_Payment = holder.cardView
        val imageView = cardView_Payment.findViewById<View>(R.id.payment_icon) as ImageView
        val drawable = ContextCompat.getDrawable(cardView_Payment.context, id_image_card_view_payment[position])
        imageView.setImageDrawable(drawable)
        val title_payment_textView = cardView_Payment.findViewById<View>(R.id.payment_title) as TextView
        title_payment_textView.setText(title_card_view_payment[position])

        //ConstraintLayout layout_background = (ConstraintLayout) cardView_Payment.findViewById(R.id.payment_background);
        //layout_background.setBackgroundColor(ContextCompat.getColor(cardView_Payment.getContext(), color_card_view_payment[position]));
        cardView_Payment.setOnClickListener {
            if (listener_payment != null) {
                listener_payment!!.onClick(position)
            }
        }
    }
}