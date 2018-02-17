package com.piramidsoft.salon.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piramidsoft.salon.Model.ModelHistory;
import com.piramidsoft.salon.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ayo Maju on 17/02/2018.
 * Updated by Muhammad Iqbal on 17/02/2018.
 */

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.HistoryHolder> {

    private ArrayList<ModelHistory> arrayList = new ArrayList<>();
    private Context context;

    public AdapterHistory(ArrayList<ModelHistory> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_history, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, int position) {
        holder.txtWaktu.setText(arrayList.get(position).getWaktu());
        holder.txtJumlah.setText(arrayList.get(position).getJumlah());
        holder.txtKeterangan.setText(arrayList.get(position).getKeterangan());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtWaktu)
        TextView txtWaktu;
        @BindView(R.id.txtJumlah)
        TextView txtJumlah;
        @BindView(R.id.txtKeterangan)
        TextView txtKeterangan;

        public HistoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
