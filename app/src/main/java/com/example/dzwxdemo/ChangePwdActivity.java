package com.example.dzwxdemo;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangePwdActivity extends BaseActivity {

    private Boolean checkFlag = false;
    private Toolbar toolbar;
    private EditText phone;
    private Button sendCaptcha;
    private EditText captcha;
    private EditText password;
    private EditText confirmPassword;
    private Button register;
    private ImageButton phoneClean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pwd_layout);
        init();
        initToolbar(toolbar);

        register.setOnClickListener(v -> {
            /*if (validateForm()) {
                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intent);
            }*/
            Intent intent = new Intent(ChangePwdActivity.this, SettingActivity.class);
            startActivity(intent);
        });
        phoneClean.setOnClickListener(v -> {
            phone.setText("");
        });
    }
    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_change_pwd_title);
        phone = findViewById(R.id.change_pwd_form_phone);
        sendCaptcha = findViewById(R.id.change_pwd_form_btn_captcha);
        captcha = findViewById(R.id.change_pwd_form_captcha);
        password = findViewById(R.id.change_pwd_form_pwd);
        confirmPassword = findViewById(R.id.change_pwd_form_repwd);
        register = findViewById(R.id.change_pwd_form_submit);
        phoneClean = findViewById(R.id.change_pwd_form_img_clean);
    }
}