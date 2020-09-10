package com.vmbeshenov.bank.CardAccount

import com.vmbeshenov.bank.R

class DataCardViewPayment private constructor(val id_card_view_payment: Int, val title_card_view_payment: Int, val id_image_card_view_payment: Int, val color_card_view_payment: Int) {

    companion object {
        val payment_CardView = arrayOf(
                DataCardViewPayment(1, R.string.card_actions_send, R.drawable.ic_payment_send, R.color.dark_blue),
                DataCardViewPayment(2, R.string.card_actions_replenish, R.drawable.ic_card_replenish, R.color.green),
                DataCardViewPayment(3, R.string.card_actions_info, R.drawable.ic_card_info, R.color.colorPrimary),
                DataCardViewPayment(4, R.string.card_actions_block, R.drawable.ic_card_block, R.color.gray)
        )
        @JvmField
        val payment_type_CardView = arrayOf(
                DataCardViewPayment(10, R.string.payment_menu_between_your_accounts, R.drawable.ic_payment_send, R.color.dark_blue),
                DataCardViewPayment(11, R.string.payment_menu_c2c, R.drawable.ic_main_card, R.color.dark_blue)
        )
    }
}