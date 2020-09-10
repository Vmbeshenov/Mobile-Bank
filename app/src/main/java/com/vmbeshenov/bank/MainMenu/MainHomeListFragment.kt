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
import com.vmbeshenov.bank.CardAccount.CardAccountActivity
import com.vmbeshenov.bank.R
import com.vmbeshenov.bank.TempData.CardAccounts
import com.vmbeshenov.bank.TempData.Deposits

class MainHomeListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val cardAccountRecycler = inflater.inflate(
                R.layout.fragment_main_home_list, container, false) as RecyclerView

        //Список карточных счетов
        val idCard = IntArray(CardAccounts.account.size)
        for (i in idCard.indices) {
            idCard[i] = CardAccounts.account[i].id_card
        }
        val cardNames = arrayOfNulls<String>(CardAccounts.account.size)
        for (i in cardNames.indices) {
            cardNames[i] = CardAccounts.account[i].name_card
        }
        val cardBalance = DoubleArray(CardAccounts.account.size)
        for (i in cardBalance.indices) {
            cardBalance[i] = CardAccounts.account[i].balance
        }
        val icImages = IntArray(CardAccounts.account.size)
        for (i in icImages.indices) {
            icImages[i] = CardAccounts.account[i].id_image
        }

        //Список вкладов
        val idDeposit = IntArray(Deposits.deposits.size)
        for (i in idDeposit.indices) {
            idDeposit[i] = Deposits.deposits[i].id_deposit
        }
        val depositName = arrayOfNulls<String>(Deposits.deposits.size)
        for (i in depositName.indices) {
            depositName[i] = Deposits.deposits[i].deposit_name
        }
        val depositBalance = DoubleArray(Deposits.deposits.size)
        for (i in depositBalance.indices) {
            depositBalance[i] = Deposits.deposits[i].deposit_balance
        }
        val depositIdImage = IntArray(Deposits.deposits.size)
        for (i in depositIdImage.indices) {
            depositIdImage[i] = Deposits.deposits[i].deposit_id_image
        }
        val adapterMainHomeList = MainHomeListAdapter(idCard, cardNames, cardBalance, icImages,
                idDeposit, depositName, depositBalance, depositIdImage)
        cardAccountRecycler.adapter = adapterMainHomeList
        val layoutManagerMainHomeList = LinearLayoutManager(activity)
        cardAccountRecycler.layoutManager = layoutManagerMainHomeList
        adapterMainHomeList.setListener(object : MainHomeListAdapter.Listener {
            override fun onClick(position: Int) {
                if (position > idCard.size) {
                    val intent = Intent(activity, LoginActivity::class.java)
                    activity!!.startActivity(intent)
                } else {
                    val intent = Intent(activity, CardAccountActivity::class.java)
                    intent.putExtra(CardAccountActivity.EXTRA_BANK_ACC_ID, position)
                    activity!!.startActivity(intent)
                }
            }
        })
        return cardAccountRecycler
    }

    companion object {
        fun newInstance(): MainHomeListFragment {
            return MainHomeListFragment()
        }
    }
}