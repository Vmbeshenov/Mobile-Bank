package com.diploma.bank;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class CardAccountActionsCardAdapter extends RecyclerView.Adapter<CardAccountActionsCardAdapter.ViewHolderPayment>{

    private int[] id_card_view_payment;
    private int[] title_card_view_payment;
    private int[] id_image_card_view_payment;
    private int[] color_card_view_payment;

    private Listener listener_payment;
    interface Listener {
        void onClick(int position);
    }

    public void setListener_payment(Listener listener_payment){
        this.listener_payment = listener_payment;
    }

    public static class ViewHolderPayment extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolderPayment(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CardAccountActionsCardAdapter(int[] id_card_view_payment, int[] title_card_view_payment, int[] id_image_card_view_payment, int[] color_card_view_payment){
        this.id_card_view_payment = id_card_view_payment;
        this.title_card_view_payment = title_card_view_payment;
        this.id_image_card_view_payment = id_image_card_view_payment;
        this.color_card_view_payment = color_card_view_payment;
    }

    @Override
    public int getItemCount(){
        return id_card_view_payment.length;
    }

    @Override
    public ViewHolderPayment onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_payment, parent, false);
        return new ViewHolderPayment(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolderPayment holder, final int position){
        CardView cardView_Payment = holder.cardView;

        ImageView imageView = (ImageView)cardView_Payment.findViewById(R.id.payment_icon);
        Drawable drawable = ContextCompat.getDrawable(cardView_Payment.getContext(), id_image_card_view_payment[position]);
        imageView.setImageDrawable(drawable);

        TextView title_payment_textView = (TextView)cardView_Payment.findViewById(R.id.payment_title);
        title_payment_textView.setText(title_card_view_payment[position]);

        //ConstraintLayout layout_background = (ConstraintLayout) cardView_Payment.findViewById(R.id.payment_background);
        //layout_background.setBackgroundColor(ContextCompat.getColor(cardView_Payment.getContext(), color_card_view_payment[position]));

        cardView_Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener_payment != null) {
                    listener_payment.onClick(position);
                }
            }
        });
    }
}