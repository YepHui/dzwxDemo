package com.example.dzwxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dzwxdemo.util.StringUtils;

public class LoginActivity extends BaseActivity {

    private EditText phone;
    private EditText password;
    private Button login;
    private TextView register;
    private TextView forgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        init();

        register.setOnClickListener(v -> {
            /*if (validateForm()) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }*/
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        login.setOnClickListener(v -> {
            /*if (validateForm()) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }*/
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });
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
        phone = findViewById(R.id.login_form_phone);
        password = findViewById(R.id.login_form_pwd);
        login = findViewById(R.id.login_form_submit);
        register = findViewById(R.id.login_form_register);
        forgetPwd = findViewById(R.id.login_form_forget_pwd);
    }
}