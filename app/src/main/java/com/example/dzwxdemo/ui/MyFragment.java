package com.example.dzwxdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dzwxdemo.R;
import com.example.dzwxdemo.UserInfoActivity;

public class MyFragment extends BaseFragment {

    private View v;
    private RelativeLayout relativeLayout;
    private TextView nickname;
    private ImageButton imageButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my, container, false);
        init();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                startActivityForResult(intent, 101);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                startActivityForResult(intent, 101);
            }
        });
        return v;
    }

    private void init() {
        relativeLayout = v.findViewById(R.id.rl_fm_user_info);
        nickname = v.findViewById(R.id.tv_fm_nickname);
        imageButton=v.findViewById(R.id.ib_fm_user_info);
    }

    @Override
    public void refresh(Bundle bundle) {
        String name = bundle.getString("nickname");
        nickname.setText(name);
    }
}
