package com.example.dzwxdemo;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthIdentityActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText name;
    private EditText idCard;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_identity_layout);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthIdentityActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_ai_title);
        name = findViewById(R.id.et_ai_name);
        idCard = findViewById(R.id.et_ai_id_card);
        submit = findViewById(R.id.btn_ai_submit);
    }
}