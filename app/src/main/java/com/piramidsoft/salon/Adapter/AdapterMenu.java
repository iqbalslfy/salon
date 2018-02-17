package com.piramidsoft.salon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piramidsoft.salon.BookingActivity;
import com.piramidsoft.salon.ItemClickListener;
import com.piramidsoft.salon.Model.ModelMenu;
import com.piramidsoft.salon.MyTransaksiActivity;
import com.piramidsoft.salon.ProfilActivity;
import com.piramidsoft.salon.PromoActivity;
import com.piramidsoft.salon.R;
import com.piramidsoft.salon.WalletActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ayo Maju on 15/02/2018.
 * Updated by Muhammad Iqbal on 15/02/2018.
 */

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.MenuHolder> {

    @BindView(R.id.card_menu)
    CardView cardMenu;
    private ArrayList<ModelMenu> arrayList = new ArrayList<>();
    private Context context;

    public AdapterMenu(ArrayList<ModelMenu> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu, parent, false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        holder.imgItemMenu.setImageResource(arrayList.get(position).getImg());
        holder.Title.setText(arrayList.get(position).getTitle());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (pos == 0) {
                    Intent i = new Intent(context, BookingActivity.class);
                    context.startActivity(i);
                }

                if (pos == 1) {
                    Intent i = new Intent(context, PromoActivity.class);
                    context.startActivity(i);
                }

                if (pos == 2) {
                    Intent i = new Intent(context, WalletActivity.class);
                    context.startActivity(i);
                }

                if (pos == 3) {
                    Intent i = new Intent(context, MyTransaksiActivity.class);
                    context.startActivity(i);
                }

                if (pos == 4) {
                    Intent i = new Intent(context, ProfilActivity.class);
                    context.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class MenuHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.img_item_menu)
        CircleImageView imgItemMenu;
        @BindView(R.id.Title)
        TextView Title;
        private ItemClickListener itemClickListener;


        public MenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }
}
