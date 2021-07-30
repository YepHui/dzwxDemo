package com.example.dzwxdemo;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AuthIdentityActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText name;
    private EditText idCard;
    private Button submit;
    private ImageButton nameClean;
    private ImageButton idcardClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_identity_layout);
        init();
        initToolbar(toolbar);
        submit.setOnClickListener(view -> {
            Intent intent = new Intent(AuthIdentityActivity.this, HomeActivity.class);
            startActivity(intent);
        });
        nameClean.setOnClickListener(v -> {
            name.setText("");
        });
        idcardClean.setOnClickListener(v -> {
            idCard.setText("");
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_ai_title);
        name = findViewById(R.id.auth_form_name);
        idCard = findViewById(R.id.auth_form_idcard);
        submit = findViewById(R.id.auth_form_submit);
        nameClean = findViewById(R.id.auth_form_name_img_clean);
        idcardClean = findViewById(R.id.auth_form_idcard_img_clean);
    }
}