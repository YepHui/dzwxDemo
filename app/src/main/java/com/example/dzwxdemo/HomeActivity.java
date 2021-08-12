package com.example.dzwxdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.dzwxdemo.ui.BaseFragment;
import com.example.dzwxdemo.ui.CourseFragment;
import com.example.dzwxdemo.ui.HomeFragment;
import com.example.dzwxdemo.ui.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;


public class HomeActivity extends BaseActivity {
    private BottomNavigationView bottomNavigationView;
    private BaseFragment fragment;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    public void init() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        Resources resources = getResources();
        bottomNavigationView.setItemTextColor(resources.getColorStateList(R.drawable.nav_menu_text_color, null));
        bottomNavigationView.setItemIconTintList(resources.getColorStateList(R.drawable.nav_menu_text_color, null));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}