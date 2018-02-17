package com.piramidsoft.salon.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.piramidsoft.salon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FragmentTransfer extends Fragment {

    @BindView(R.id.ed_nomor)
    EditText edNomor;
    @BindView(R.id.ed_ammount)
    EditText edAmmount;
    @BindView(R.id.ed_notes)
    EditText edNotes;
    @BindView(R.id.btnConfirmation)
    Button btnConfirmation;
    Unbinder unbinder;

    private FragmentActivity mActivity;

    public FragmentTransfer() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_transfer, container, false);
        unbinder = ButterKnife.bind(this, view);
        mActivity = getActivity();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnConfirmation)
    public void onViewClicked() {
        DialogForm();
    }

    private void DialogForm() {
        final Dialog dialog = new Dialog(mActivity);
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pop_up_confirmation, null);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.corner_radius_bg_pop_up);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);

        dialog.show();
    }
}
