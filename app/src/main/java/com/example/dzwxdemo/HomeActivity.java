package com.example.dzwxdemo;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.dzwxdemo.ui.BaseFragment;
import com.example.dzwxdemo.ui.CourseFragment;
import com.example.dzwxdemo.ui.HomeFragment;
import com.example.dzwxdemo.ui.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends BaseActivity {
    private BottomNavigationView bottomNavigationView;
    private BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
        init();
    }

    public void init() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            String tag = null;
            switch (item.getItemId()) {
                case R.id.myhome:
                    fragment = new HomeFragment();
                    tag = "home_fragment";
                    break;
                case R.id.course:
                    fragment = new CourseFragment();
                    tag = "course_fragment";
                    break;
                case R.id.my:
                    fragment = new MyFragment();
                    tag = "my_fragment";
                    break;
                default:
                    break;
            }
            HomeActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, tag).commit();
            return true;
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 201:
                Bundle bundle = data.getExtras();
                Log.d("onActivityResult", "...");
                fragment.refresh(bundle);
                break;
            default:
                break;
        }
    }
}