package com.example.dzwxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends BaseActivity {
    private ImageButton weixinLogin;
    private ImageButton phoneLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        phoneLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void init() {
        weixinLogin = findViewById(R.id.image_button_weixin_login);
        phoneLogin = findViewById(R.id.image_button_phone_login);
    }
}