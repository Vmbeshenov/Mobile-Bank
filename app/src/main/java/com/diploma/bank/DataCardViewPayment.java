package com.diploma.bank;

public class DataCardViewPayment {

    private int id_card_view_payment;
    private int title_card_view_payment;
    private int id_image_card_view_payment;
    private int color_card_view_payment;

    public static final DataCardViewPayment[] payment_CardView = {
            new DataCardViewPayment(1, R.string.card_actions_send, R.drawable.ic_payment_send, R.color.dark_blue),
            new DataCardViewPayment(2, R.string.card_actions_replenish, R.drawable.ic_card_replenish, R.color.green),
            new DataCardViewPayment(3, R.string.card_actions_info, R.drawable.ic_card_info, R.color.colorPrimary),
            new DataCardViewPayment(4, R.string.card_actions_block, R.drawable.ic_card_block, R.color.gray)
    };

    public static final DataCardViewPayment[] payment_type_CardView = {
            new DataCardViewPayment(10, R.string.payment_menu_between_your_accounts, R.drawable.ic_payment_send, R.color.dark_blue),
            new DataCardViewPayment(11, R.string.payment_menu_c2c, R.drawable.ic_main_card, R.color.dark_blue)
    };

    private DataCardViewPayment(int id_card_view_payment, int title_card_view_payment, int id_image_card_view_payment, int color_card_view_payment){
        this.id_card_view_payment = id_card_view_payment;
        this.title_card_view_payment = title_card_view_payment;
        this.id_image_card_view_payment = id_image_card_view_payment;
        this.color_card_view_payment = color_card_view_payment;
    }

    public int getId_card_view_payment() {
        return id_card_view_payment;
    }

    public int getTitle_card_view_payment() {
        return title_card_view_payment;
    }

    public int getId_image_card_view_payment() {
        return id_image_card_view_payment;
    }

    public int getColor_card_view_payment() {
        return color_card_view_payment;
    }
}
