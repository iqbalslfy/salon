package com.piramidsoft.salon;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookingActivity extends AppCompatActivity {

    @BindView(R.id.act_back)
    ImageView actBack;
    @BindView(R.id.ed_tanggal)
    EditText edTanggal;
    @BindView(R.id.ed_jam)
    EditText edJam;
    @BindView(R.id.btnBooking)
    Button btnBooking;
    @BindView(R.id.cb1)
    CheckBox cb1;
    @BindView(R.id.cb2)
    CheckBox cb2;
    @BindView(R.id.cb3)
    CheckBox cb3;
    @BindView(R.id.cb4)
    CheckBox cb4;
    @BindView(R.id.cb5)
    CheckBox cb5;
    @BindView(R.id.cb6)
    CheckBox cb6;
    @BindView(R.id.cb7)
    CheckBox cb7;
    @BindView(R.id.cb8)
    CheckBox cb8;
    @BindView(R.id.cb9)
    CheckBox cb9;
    @BindView(R.id.cb10)
    CheckBox cb10;
    @BindView(R.id.cb11)
    CheckBox cb11;
    @BindView(R.id.cb12)
    CheckBox cb12;
    @BindView(R.id.cb13)
    CheckBox cb13;
    String value = "";
    String dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        ButterKnife.bind(this);
        edJam.getText().clear();
        edTanggal.getText().clear();
    }

    @OnClick({R.id.ed_tanggal, R.id.ed_jam, R.id.btnBooking, R.id.act_back})
    public void onViewClicked(View view) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);


        switch (view.getId()) {
            case R.id.ed_tanggal:
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(new CalendarDatePickerDialogFragment.OnDateSetListener() {
                            @Override
                            public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {

                                int month = monthOfYear + 1;
                                dateString = String.format("%02d", dayOfMonth) + "-" + String.format("%02d", month) + "-" + year;
                                edTanggal.setText(dateString);
                            }
                        });
                cdp.show(getSupportFragmentManager(), null);
                break;
            case R.id.ed_jam:
                RadialTimePickerDialogFragment timePickerDialogStart = new RadialTimePickerDialogFragment().setForced24hFormat().setOnTimeSetListener(new RadialTimePickerDialogFragment.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {

                        edJam.setText(String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute));

                    }
                });

                timePickerDialogStart.show(getSupportFragmentManager(), null);
                break;

            case R.id.btnBooking:
                DialogForm();
                Toast.makeText(BookingActivity.this, "Tanggal : " + dateString + "\n" +
                        "Waktu :" + edJam.getText() + "\n" +
                        "Pilihan :" + value, Toast.LENGTH_SHORT).show();
                break;

            case R.id.act_back:
                finish();
                break;
        }
    }


    @OnClick({R.id.cb1, R.id.cb2, R.id.cb3, R.id.cb4, R.id.cb5, R.id.cb6, R.id.cb7, R.id.cb8, R.id.cb9, R.id.cb10, R.id.cb11, R.id.cb12, R.id.cb13})
    public void ClieckedCheckView(View view) {

        switch (view.getId()) {
            case R.id.cb1:
                value += "Permanent Blow Dry,";
                break;
            case R.id.cb2:
                value += "Keratin Steampod,";
                break;
            case R.id.cb3:
                value += "Keratin,";
                break;
            case R.id.cb4:
                value += "Super Soft Keratin,";
                break;
            case R.id.cb5:
                value += "Smoothing Jepang,";
                break;
            case R.id.cb6:
                value += "Airwave,";
                break;
            case R.id.cb7:
                value += "Digital Wave,";
                break;
            case R.id.cb8:
                value += "Keriting Jepang Manual,";
                break;
            case R.id.cb9:
                value += "Keriting Getar,";
                break;
            case R.id.cb10:
                value += "Clasical Style,";
                break;
            case R.id.cb11:
                value += "Color Italy,";
                break;
            case R.id.cb12:
                value += "Creative Coloring,";
                break;
            case R.id.cb13:
                value += "Glossy Spain,";
                break;
        }
    }

    private void DialogForm() {
        final Dialog dialog = new Dialog(BookingActivity.this);
        dialog.setContentView(R.layout.pop_up_sukses_booking);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.corner_radius_bg_pop_up);
        dialog.show();
    }
}
