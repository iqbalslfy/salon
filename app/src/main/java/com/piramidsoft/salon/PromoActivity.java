package com.piramidsoft.salon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.piramidsoft.salon.Adapter.AdapterPromo;
import com.piramidsoft.salon.Model.ModelPromo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PromoActivity extends AppCompatActivity {

    @BindView(R.id.act_back)
    ImageView actBack;
    @BindView(R.id.rvPromo)
    RecyclerView rvPromo;

    AdapterPromo adapterPromo;
    ArrayList<ModelPromo> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        ButterKnife.bind(this);

        daftarpromo();

        rvPromo.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(PromoActivity.this, 1,
                GridLayoutManager.VERTICAL, false);

        rvPromo.setLayoutManager(layoutManager);
        adapterPromo = new AdapterPromo(arrayList, PromoActivity.this);
        rvPromo.setAdapter(adapterPromo);
    }

    private void daftarpromo() {
        arrayList.add(new ModelPromo(R.drawable.banner1, "Hair Color Salon Discount", "5.000", "19 - 20 April 2019"));
        arrayList.add(new ModelPromo(R.drawable.banner2, "Creambath Salon Discount", "50.000", "1 - 10 Januari 2019"));
        arrayList.add(new ModelPromo(R.drawable.banner3, "Hair Color Salon Discount", "500.000", "6 - 9 Desember 2019"));
    }

    @OnClick(R.id.act_back)
    public void onViewClicked() {
        finish();
    }
}
