package com.example.dzwxdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dzwxdemo.ui.MyFragment;

public class UserInfoActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText name;
    private EditText nickname;
    private EditText phone;
    private EditText idcard;
    private Button submit;

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
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(UserInfoActivity.this, "保存成功！", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("nickname", nickname.getText().toString());
                intent.putExtras(bundle);
                setResult(201, intent);
                finish();
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
        submit = findViewById(R.id.btn_uil_submit);
    }
}