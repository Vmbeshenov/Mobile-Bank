package com.diploma.bank.MainMenu;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.diploma.bank.R;

class MainHomeListAdapter extends RecyclerView.Adapter<MainHomeListAdapter.ViewHolder>{

    private int[] id_card;
    private String[] card_name;
    private double[] balance;
    private int[] imageIds;

    private int[] id_deposit;
    private String[] deposit_name;
    private double[] deposit_balance;
    private int[] deposit_id_image;

    private int[] id_bank_account;
    private String[] bank_account_name;
    private double[] bank_account_balance;
    private int[] bank_account_id_image;

    private Listener listener_main_home_list;
    interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener_main_home_list){
        this.listener_main_home_list = listener_main_home_list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public MainHomeListAdapter(int[] id_card, String[] card_name, double[] balance, int[] imageIds,
                               int[] id_deposit, String[] deposit_name, double[] deposit_balance, int[] deposit_id_image){
        this.id_card = id_card;
        this.card_name = card_name;
        this.balance = balance;
        this.imageIds = imageIds;

        this.id_deposit = id_deposit;
        this.deposit_name = deposit_name;
        this.deposit_balance = deposit_balance;
        this.deposit_id_image = deposit_id_image;
    }

    @Override
    public int getItemCount(){
        return (id_card.length + id_deposit.length);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_main_home_list, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        CardView cardView_MainMenu = holder.cardView;

        id_bank_account = new int[id_card.length + id_deposit.length];
        bank_account_name = new String[card_name.length + deposit_name.length];
        bank_account_balance = new double[balance.length + deposit_balance.length];
        bank_account_id_image = new int[imageIds.length + deposit_id_image.length];

        for (int i = 0; i < id_card.length; i++){
            id_bank_account[i] = id_card[i];
            bank_account_name[i] = card_name[i];
            bank_account_balance[i] = balance[i];
            bank_account_id_image[i] = imageIds[i];
        }

        for (int i = 0; i < id_deposit.length; i++){
            id_bank_account[i + id_card.length] = id_deposit[i];
            bank_account_name[i + card_name.length] = deposit_name[i];
            bank_account_balance[i + balance.length] = deposit_balance[i];
            bank_account_id_image[i + imageIds.length] = deposit_id_image[i];
        }

        ImageView imageView = (ImageView)cardView_MainMenu.findViewById(R.id.card_view_card_image);
        Drawable drawable = ContextCompat.getDrawable(cardView_MainMenu.getContext(), bank_account_id_image[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(bank_account_name[position]);

        TextView cardName_textView = (TextView)cardView_MainMenu.findViewById(R.id.card_view_card_name);
        cardName_textView.setText(bank_account_name[position]);

        TextView cardBalance_textView = (TextView)cardView_MainMenu.findViewById(R.id.card_view_card_balance);
        TextView cardBalanceSmall_textView = (TextView)cardView_MainMenu.findViewById(R.id.card_view_card_balance_small);

        long balance_temp = (long) Math.floor(bank_account_balance[position]);
        cardBalance_textView.setText(String.format("%, d", balance_temp));

        balance_temp = Math.round((bank_account_balance[position] % 1) * 100);
        String balance_str = ",";
        balance_str += Long.toString(balance_temp);
        cardBalanceSmall_textView.setText(balance_str);

        cardView_MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener_main_home_list != null) {
                    listener_main_home_list.onClick(position);
                }
            }
        });
    }
}