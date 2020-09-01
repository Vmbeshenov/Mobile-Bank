package com.vmbeshenov.bank.TempData

import com.vmbeshenov.bank.R

class CardAccounts private constructor(val id_card: Int, val name_card: String, var balance: Double, val id_image: Int) {

    companion object {
        @JvmField
        var account = arrayOf(
                CardAccounts(100, "Mastercard", 12709.75, R.drawable.ic_main_card),
                CardAccounts(200, "Visa", 29305.91, R.drawable.ic_main_card))
    }
}