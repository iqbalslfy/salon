package com.piramidsoft.salon.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.piramidsoft.salon.Model.ModelPromo;
import com.piramidsoft.salon.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ayo Maju on 17/02/2018.
 * Updated by Muhammad Iqbal on 17/02/2018.
 */

public class AdapterPromo extends RecyclerView.Adapter<AdapterPromo.PromoHolder> {

    private ArrayList<ModelPromo> arrayList = new ArrayList<>();
    private Context context;

    public AdapterPromo(ArrayList<ModelPromo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public PromoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu_promo, parent, false);
        return new PromoHolder(view);
    }

    @Override
    public void onBindViewHolder(PromoHolder holder, int position) {
        holder.imgPromo.setImageResource(arrayList.get(position).getImage());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.angka.setText(arrayList.get(position).getAngka());
        holder.tanggal.setText(arrayList.get(position).getTanggal());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PromoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_promo)
        ImageView imgPromo;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.angka)
        TextView angka;
        @BindView(R.id.tanggal)
        TextView tanggal;

        public PromoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
