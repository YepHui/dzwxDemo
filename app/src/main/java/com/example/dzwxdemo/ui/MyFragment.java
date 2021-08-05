package com.example.dzwxdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.dzwxdemo.CollectionActivity;
import com.example.dzwxdemo.ExamActivity;
import com.example.dzwxdemo.R;
import com.example.dzwxdemo.SettingActivity;
import com.example.dzwxdemo.TransactionActivity;
import com.example.dzwxdemo.UserInfoActivity;

public class MyFragment extends BaseFragment {

    private View v;
    private RelativeLayout relativeLayout;
    private TextView nickname;
    private RelativeLayout imageButton;
    private RelativeLayout transactionBtn;
    private RelativeLayout collectionBtn;
    private RelativeLayout examBtn;
    private ImageButton settingBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my, container, false);
        init();

        relativeLayout.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), UserInfoActivity.class);
            startActivityForResult(intent, 101);

        });
        imageButton.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), UserInfoActivity.class);
            startActivityForResult(intent, 101);
        });
        transactionBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), TransactionActivity.class);
            startActivity(intent);
        });
        collectionBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), CollectionActivity.class);
            startActivity(intent);
        });
        examBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ExamActivity.class);
            startActivity(intent);
        });
        settingBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), SettingActivity.class);
            startActivity(intent);
        });
        return v;
    }

    private void init() {
        relativeLayout = v.findViewById(R.id.rl_fm_user_info);
        nickname = v.findViewById(R.id.tv_fm_nickname);
        imageButton = v.findViewById(R.id.ib_fm_user_info);
        transactionBtn = v.findViewById(R.id.btn_fm_transaction);
        collectionBtn = v.findViewById(R.id.btn_fm_collection);
        examBtn = v.findViewById(R.id.btn_fm_exam);
        settingBtn = v.findViewById(R.id.ib_fm_setting);
    }

    @Override
    public void refresh(Bundle bundle) {
        String name = bundle.getString("nickname");
        nickname.setText(name);
    }
}
