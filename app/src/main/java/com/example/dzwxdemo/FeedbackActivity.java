package com.example.dzwxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

public class FeedbackActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText title;
    private EditText content;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_layout);
        init();
        initToolbar(toolbar);
        submit.setOnClickListener(view -> {
            Intent intent = new Intent(FeedbackActivity.this, SettingActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_feedback_title);
        title = findViewById(R.id.feedback_form_title);
        content = findViewById(R.id.feedback_form_content);
        submit = findViewById(R.id.feedback_form_submit);
    }
}