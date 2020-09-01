package com.vmbeshenov.bank.MainMenu

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmbeshenov.bank.Authorization.LoginActivity
import com.vmbeshenov.bank.CardAccountActivity
import com.vmbeshenov.bank.R
import com.vmbeshenov.bank.TempData.CardAccounts
import com.vmbeshenov.bank.TempData.Deposits

class MainHomeListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val card_account_Recycler = inflater.inflate(
                R.layout.fragment_main_home_list, container, false) as RecyclerView

        //Список карточных счетов
        val id_card = IntArray(CardAccounts.account.size)
        for (i in id_card.indices) {
            id_card[i] = CardAccounts.account[i].id_card
        }
        val card_names = arrayOfNulls<String>(CardAccounts.account.size)
        for (i in card_names.indices) {
            card_names[i] = CardAccounts.account[i].name_card
        }
        val card_balance = DoubleArray(CardAccounts.account.size)
        for (i in card_balance.indices) {
            card_balance[i] = CardAccounts.account[i].balance
        }
        val ic_images = IntArray(CardAccounts.account.size)
        for (i in ic_images.indices) {
            ic_images[i] = CardAccounts.account[i].id_image
        }

        //Список вкладов
        val id_deposit = IntArray(Deposits.deposits.size)
        for (i in id_deposit.indices) {
            id_deposit[i] = Deposits.deposits[i].id_deposit
        }
        val deposit_name = arrayOfNulls<String>(Deposits.deposits.size)
        for (i in deposit_name.indices) {
            deposit_name[i] = Deposits.deposits[i].deposit_name
        }
        val deposit_balance = DoubleArray(Deposits.deposits.size)
        for (i in deposit_balance.indices) {
            deposit_balance[i] = Deposits.deposits[i].deposit_balance
        }
        val deposit_id_image = IntArray(Deposits.deposits.size)
        for (i in deposit_id_image.indices) {
            deposit_id_image[i] = Deposits.deposits[i].deposit_id_image
        }
        val adapter_main_home_list = MainHomeListAdapter(id_card, card_names, card_balance, ic_images,
                id_deposit, deposit_name, deposit_balance, deposit_id_image)
        card_account_Recycler.adapter = adapter_main_home_list
        val layoutManager_main_home_list = LinearLayoutManager(activity)
        card_account_Recycler.layoutManager = layoutManager_main_home_list
        adapter_main_home_list.setListener(object : MainHomeListAdapter.Listener {
            override fun onClick(position: Int) {
                if (position > id_card.size) {
                    val intent = Intent(activity, LoginActivity::class.java)
                    activity!!.startActivity(intent)
                } else {
                    val intent = Intent(activity, CardAccountActivity::class.java)
                    intent.putExtra(CardAccountActivity.EXTRA_BANK_ACC_ID, position)
                    activity!!.startActivity(intent)
                }
            }
        })
        return card_account_Recycler
    }

    companion object {
        fun newInstance(): MainHomeListFragment {
            return MainHomeListFragment()
        }
    }
}