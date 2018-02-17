package com.piramidsoft.salon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btSignin)
    Button btSignin;
    @BindView(R.id.btCreateAcc)
    Button btCreateAcc;
    @BindView(R.id.btForgot)
    Button btForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btSignin, R.id.btCreateAcc, R.id.btForgot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btSignin:
                Intent in = new Intent(Login.this, MainActivity.class);
                startActivity(in);
                finish();
                break;
            case R.id.btCreateAcc:
                Intent i = new Intent(Login.this, RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.btForgot:
                break;
        }
    }
}
