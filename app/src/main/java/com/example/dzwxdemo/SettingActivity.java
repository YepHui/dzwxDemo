package com.example.dzwxdemo;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SettingActivity extends BaseActivity {

    private Toolbar toolbar;
    private RelativeLayout changePwd;
    private RelativeLayout feedback;
    private RelativeLayout aboutUs;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        init();
        initToolbar(toolbar);
        changePwd.setOnClickListener(view -> {
            Intent intent = new Intent(SettingActivity.this, ChangePwdActivity.class);
            startActivity(intent);
        });
        feedback.setOnClickListener(view -> {
            Intent intent = new Intent(SettingActivity.this, feedbackActivity.class);
            startActivity((intent));
        });
        aboutUs.setOnClickListener(view -> {
            Intent intent=new Intent(SettingActivity.this,AboutUsActivity.class);
            startActivity(intent);
        });
        logout.setOnClickListener(view -> {
            Toast.makeText(SettingActivity.this, "退出登录", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_setting_title);
        changePwd = findViewById(R.id.setting_rl_change_pwd);
        feedback = findViewById(R.id.setting_rl_feedback);
        aboutUs = findViewById(R.id.setting_rl_about_us);
        logout = findViewById(R.id.logout);
    }
}