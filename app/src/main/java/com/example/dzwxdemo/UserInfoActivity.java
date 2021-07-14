package com.example.dzwxdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UserInfoActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText name;
    private EditText nickname;
    private EditText phone;
    private EditText idcard;
    private TextView tvNickName;
    private ImageButton ibNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_layout);
        init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("nickname", nickname.getText().toString());
                intent.putExtras(bundle);
                setResult(201, intent);
                finish();
            }
        });
        nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUpdateNickname();
            }
        });
        tvNickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUpdateNickname();
            }
        });
        ibNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUpdateNickname();
            }
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_uil_title);
        name = findViewById(R.id.et_uil_name);
        nickname = findViewById(R.id.et_uil_nickname);
        phone = findViewById(R.id.et_uil_phone);
        idcard = findViewById(R.id.et_uil_idcard);
        tvNickName = findViewById(R.id.tv_uil_nickname);
        ibNickname = findViewById(R.id.ib_uil_nickname);
    }

    private void toUpdateNickname() {
        Intent intent = new Intent(UserInfoActivity.this, UpdateNicknameActivity.class);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 201:
                Bundle bundle = data.getExtras();
                nickname.setText(bundle.get("nickname").toString());
                break;
            default:
                break;
        }
    }
}