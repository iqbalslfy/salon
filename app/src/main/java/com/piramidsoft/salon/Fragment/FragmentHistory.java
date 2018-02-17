package com.piramidsoft.salon.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piramidsoft.salon.Adapter.AdapterHistory;
import com.piramidsoft.salon.Model.ModelHistory;
import com.piramidsoft.salon.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentHistory extends Fragment {

    @BindView(R.id.rvHistory)
    RecyclerView rvHistory;
    Unbinder unbinder;
    AdapterHistory adapterHistory;
    ArrayList<ModelHistory> arrayList = new ArrayList<>();

    public FragmentHistory() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_history, container, false);
        unbinder = ButterKnife.bind(this, view);

        datahistory();

        rvHistory.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1,
                GridLayoutManager.VERTICAL, false);

        rvHistory.setLayoutManager(layoutManager);
        adapterHistory = new AdapterHistory(arrayList, getContext());
        rvHistory.setAdapter(adapterHistory);

        return view;
    }

    private void datahistory() {
        arrayList.add(new ModelHistory("12 April 2001 10.45 WIB", "Rp55.000", "Transfer Saldo Muhammad Iqbal"));
        arrayList.add(new ModelHistory("20 Januari 2009 10.45 WIB", "Rp35.000", "Transfer Saldo Dayat"));
        arrayList.add(new ModelHistory("2 Desember 2011 10.45 WIB", "Rp70.500", "Transfer Saldo Bambang"));
        arrayList.add(new ModelHistory("12 April 2001 10.45 WIB", "Rp55.000", "Transfer Saldo Muhammad Iqbal"));
        arrayList.add(new ModelHistory("20 Januari 2009 10.45 WIB", "Rp35.000", "Transfer Saldo Dayat"));
        arrayList.add(new ModelHistory("2 Desember 2011 10.45 WIB", "Rp70.500", "Transfer Saldo Bambang"));
        arrayList.add(new ModelHistory("12 April 2001 10.45 WIB", "Rp55.000", "Transfer Saldo Muhammad Iqbal"));
        arrayList.add(new ModelHistory("20 Januari 2009 10.45 WIB", "Rp35.000", "Transfer Saldo Dayat"));
        arrayList.add(new ModelHistory("2 Desember 2011 10.45 WIB", "Rp70.500", "Transfer Saldo Bambang"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
