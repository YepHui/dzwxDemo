package com.example.dzwxdemo;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

public class UserAgreementActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_agreement_layout);
        toolbar = findViewById(R.id.t_ua_toolbar);
        initToolbar(toolbar);
    }
}