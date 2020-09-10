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
import kotlin.math.floor
import kotlin.math.roundToInt

internal class MainHomeListAdapter(private val id_card: IntArray, private val card_name: Array<String?>, private val balance: DoubleArray, private val imageIds: IntArray,
                                   private val id_deposit: IntArray, private val deposit_name: Array<String?>, private val deposit_balance: DoubleArray, private val deposit_id_image: IntArray) : RecyclerView.Adapter<MainHomeListAdapter.ViewHolder>() {
    private lateinit var idBankAccount: IntArray
    private lateinit var bankAccountName: Array<String?>
    private lateinit var bankAccountBalance: DoubleArray
    private lateinit var bankAccountIdImage: IntArray
    private var listenerMainHomeList: Listener? = null

    internal interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener_main_home_list: Listener?) {
        this.listenerMainHomeList = listener_main_home_list
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
        val cardViewMainMenu = holder.cardView
        idBankAccount = IntArray(id_card.size + id_deposit.size)
        bankAccountName = arrayOfNulls(card_name.size + deposit_name.size)
        bankAccountBalance = DoubleArray(balance.size + deposit_balance.size)
        bankAccountIdImage = IntArray(imageIds.size + deposit_id_image.size)
        for (i in id_card.indices) {
            idBankAccount[i] = id_card[i]
            bankAccountName[i] = card_name[i]
            bankAccountBalance[i] = balance[i]
            bankAccountIdImage[i] = imageIds[i]
        }
        for (i in id_deposit.indices) {
            idBankAccount[i + id_card.size] = id_deposit[i]
            bankAccountName[i + card_name.size] = deposit_name[i]
            bankAccountBalance[i + balance.size] = deposit_balance[i]
            bankAccountIdImage[i + imageIds.size] = deposit_id_image[i]
        }
        val imageView = cardViewMainMenu.findViewById<View>(R.id.card_view_card_image) as ImageView
        val drawable = ContextCompat.getDrawable(cardViewMainMenu.context, bankAccountIdImage[position])
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = bankAccountName[position]
        val cardNameTextView = cardViewMainMenu.findViewById<View>(R.id.card_view_card_name) as TextView
        cardNameTextView.text = bankAccountName[position]
        val cardBalanceTextView = cardViewMainMenu.findViewById<View>(R.id.card_view_card_balance) as TextView
        val cardBalanceSmallTextView = cardViewMainMenu.findViewById<View>(R.id.card_view_card_balance_small) as TextView
        var balanceTemp = floor(bankAccountBalance[position]).toLong()
        cardBalanceTextView.text = String.format("%, d", balanceTemp)
        balanceTemp = (bankAccountBalance[position] % 1 * 100).roundToInt().toLong()
        var balanceStr = ","
        balanceStr += balanceTemp.toString()
        cardBalanceSmallTextView.text = balanceStr
        cardViewMainMenu.setOnClickListener {
            if (listenerMainHomeList != null) {
                listenerMainHomeList!!.onClick(position)
            }
        }
    }
}