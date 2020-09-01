package com.vmbeshenov.bank.TempData

import com.vmbeshenov.bank.R

class Deposits private constructor(val id_deposit: Int, val deposit_name: String, val deposit_balance: Double, val deposit_id_image: Int) {

    companion object {
        var deposits = arrayOf(
                Deposits(10, "Сберегательный вклад", 52000.00, R.drawable.ic_main_deposit),
                Deposits(20, "Вклад \"Подари жизнь\"", 102750.21, R.drawable.ic_main_deposit)
        )
    }
}