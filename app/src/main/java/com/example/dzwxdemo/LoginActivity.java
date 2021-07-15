package com.example.dzwxdemo;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dzwxdemo.util.StringUtils;

public class LoginActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText phone;
    private EditText password;
    private Button login;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        init();
        initToolbar(toolbar);


        login.setOnClickListener(v -> {
            /*if (validateForm()) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }*/
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> finish());
    }

    private Boolean validateForm() {
        String phoneNum = phone.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        if (StringUtils.isBlank(phoneNum)) {
            Toast toast = Toast.makeText(LoginActivity.this, "请输入手机号", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        } else if (StringUtils.isBlank(pwd)) {
            Toast toast = Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }
        return true;
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_l_title);
        phone = findViewById(R.id.et_l_phone);
        password = findViewById(R.id.et_l_pwd);
        login = findViewById(R.id.btn_login);
        back = findViewById(R.id.btn_l_back);
    }
}