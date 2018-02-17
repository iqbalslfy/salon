package com.piramidsoft.salon;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.piramidsoft.salon.Adapter.AdapterMenu;
import com.piramidsoft.salon.Adapter.SlidePageAdapter;
import com.piramidsoft.salon.Model.ModelMenu;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.logout)
    ImageView logout;
    @BindView(R.id.vpSlide)
    ViewPager vpSlide;
    @BindView(R.id.cpIndicator)
    CirclePageIndicator cpIndicator;
    @BindView(R.id.lyIndicator)
    LinearLayout lyIndicator;
    @BindView(R.id.rvMenu)
    RecyclerView rvMenu;

    AdapterMenu adapterMenu;
    ArrayList<ModelMenu> arrayList = new ArrayList<>();
    private Handler handler;
    private int slidePage;
    private ArrayList<Integer> slideList;
    private int SLIDE_DELAY = 5000;
    private MainActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        menus();

        mActivity = MainActivity.this;
        slidePage = 0;
        handler = new Handler();
        slideList = new ArrayList<>();
        slideList.add(R.drawable.banner1);
        slideList.add(R.drawable.banner2);
        slideList.add(R.drawable.banner3);

        SlidePageAdapter adapter = new SlidePageAdapter(mActivity, slideList);
        vpSlide.setAdapter(adapter);

        cpIndicator.setCentered(true);
        cpIndicator.setViewPager(vpSlide);
        handler.post(runnable);

        rvMenu.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 1,
                GridLayoutManager.VERTICAL, false);

        rvMenu.setLayoutManager(layoutManager);
        adapterMenu = new AdapterMenu(arrayList, MainActivity.this);
        rvMenu.setAdapter(adapterMenu);
    }

    private Runnable runnable = new Runnable() {
        public void run() {
            vpSlide.setCurrentItem(slidePage, true);

            if (slideList.size() == (slidePage + 1)) {
                slidePage = 0;
            } else {
                slidePage++;
            }
            handler.postDelayed(runnable, SLIDE_DELAY);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private void menus() {
        arrayList.add(new ModelMenu(R.drawable.booking, "Booking"));
        arrayList.add(new ModelMenu(R.drawable.promo, "Promo"));
        arrayList.add(new ModelMenu(R.drawable.wallet, "Wallet"));
        arrayList.add(new ModelMenu(R.drawable.mytransaksi, "My Transaksi"));
        arrayList.add(new ModelMenu(R.drawable.profile, "Profile"));
    }

    @OnClick(R.id.logout)
    public void onViewClicked() {
    }
}
