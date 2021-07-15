package com.example.dzwxdemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class UpdateNicknameActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText nickname;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_nickname_layout);
        init();
        initToolbar(toolbar);
        submit.setOnClickListener(view -> {
            Toast toast = Toast.makeText(UpdateNicknameActivity.this, "保存成功！", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("nickname", nickname.getText().toString());
            intent.putExtras(bundle);
            setResult(201, intent);
            finish();
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_unl_title);
        nickname = findViewById(R.id.et_unl_nickname);
        submit = findViewById(R.id.btn_unl_submit);
    }
}