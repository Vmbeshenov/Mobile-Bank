package com.diploma.bank;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class CardAccountHistoryCardAdapter extends RecyclerView.Adapter<CardAccountHistoryCardAdapter.ViewHolder_CardAccHistory> {

    private double[] sum;
    private String[] category;
    private String[] title_operation;
    private String[] date_operation;

    private Listener listener_history;
    interface Listener {
        void onClick(int position);
    }

    public void setListener_history(Listener listener_history) {
        this.listener_history = listener_history;
    }

    public static class ViewHolder_CardAccHistory extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder_CardAccHistory(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CardAccountHistoryCardAdapter(double[] sum, String[] category, String[] title_operation, String[] date_operation) {
        this.sum = sum;
        this.category = category;
        this.title_operation = title_operation;
        this.date_operation = date_operation;
    }

    @Override
    public int getItemCount() {
        return title_operation.length;
    }

    @Override
    public ViewHolder_CardAccHistory onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_card_account_history, parent, false);
        return new ViewHolder_CardAccHistory(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder_CardAccHistory holder, final int position) {
        CardView cardView_CardAccHistory = holder.cardView;

        TextView sum_textView = (TextView)cardView_CardAccHistory.findViewById(R.id.info_history_sum);
        sum_textView.setText(Double.toString(sum[position]));

        TextView category_textView = (TextView)cardView_CardAccHistory.findViewById(R.id.info_history_category);
        category_textView.setText(category[position]);

        TextView title_textView = (TextView)cardView_CardAccHistory.findViewById(R.id.info_history_title_operation);
        title_textView.setText(title_operation[position]);

        TextView date_textView = (TextView)cardView_CardAccHistory.findViewById(R.id.info_history_date);
        date_textView.setText(date_operation[position]);

        cardView_CardAccHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener_history != null) {
                    listener_history.onClick(position);
                }
            }
        });
    }
}