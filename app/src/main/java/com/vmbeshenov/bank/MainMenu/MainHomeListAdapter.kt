package com.vmbeshenov.bank.MainMenu

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.vmbeshenov.bank.R

internal class MainHomeListAdapter(private val id_card: IntArray, private val card_name: Array<String?>, private val balance: DoubleArray, private val imageIds: IntArray,
                                   private val id_deposit: IntArray, private val deposit_name: Array<String?>, private val deposit_balance: DoubleArray, private val deposit_id_image: IntArray) : RecyclerView.Adapter<MainHomeListAdapter.ViewHolder>() {
    private lateinit var id_bank_account: IntArray
    private lateinit var bank_account_name: Array<String?>
    private lateinit var bank_account_balance: DoubleArray
    private lateinit var bank_account_id_image: IntArray
    private var listener_main_home_list: Listener? = null

    internal interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener_main_home_list: Listener?) {
        this.listener_main_home_list = listener_main_home_list
    }

    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun getItemCount(): Int {
        return id_card.size + id_deposit.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cv = LayoutInflater.from(parent.context)
                .inflate(R.layout.cardview_main_home_list, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView_MainMenu = holder.cardView
        id_bank_account = IntArray(id_card.size + id_deposit.size)
        bank_account_name = arrayOfNulls(card_name.size + deposit_name.size)
        bank_account_balance = DoubleArray(balance.size + deposit_balance.size)
        bank_account_id_image = IntArray(imageIds.size + deposit_id_image.size)
        for (i in id_card.indices) {
            id_bank_account[i] = id_card[i]
            bank_account_name[i] = card_name[i]
            bank_account_balance[i] = balance[i]
            bank_account_id_image[i] = imageIds[i]
        }
        for (i in id_deposit.indices) {
            id_bank_account[i + id_card.size] = id_deposit[i]
            bank_account_name[i + card_name.size] = deposit_name[i]
            bank_account_balance[i + balance.size] = deposit_balance[i]
            bank_account_id_image[i + imageIds.size] = deposit_id_image[i]
        }
        val imageView = cardView_MainMenu.findViewById<View>(R.id.card_view_card_image) as ImageView
        val drawable = ContextCompat.getDrawable(cardView_MainMenu.context, bank_account_id_image[position])
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = bank_account_name[position]
        val cardName_textView = cardView_MainMenu.findViewById<View>(R.id.card_view_card_name) as TextView
        cardName_textView.text = bank_account_name[position]
        val cardBalance_textView = cardView_MainMenu.findViewById<View>(R.id.card_view_card_balance) as TextView
        val cardBalanceSmall_textView = cardView_MainMenu.findViewById<View>(R.id.card_view_card_balance_small) as TextView
        var balance_temp = Math.floor(bank_account_balance[position]).toLong()
        cardBalance_textView.text = String.format("%, d", balance_temp)
        balance_temp = Math.round(bank_account_balance[position] % 1 * 100)
        var balance_str = ","
        balance_str += java.lang.Long.toString(balance_temp)
        cardBalanceSmall_textView.text = balance_str
        cardView_MainMenu.setOnClickListener {
            if (listener_main_home_list != null) {
                listener_main_home_list!!.onClick(position)
            }
        }
    }
}