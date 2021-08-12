package com.example.dzwxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.dzwxdemo.adapter.TransactionAdapter;
import com.example.dzwxdemo.dto.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionActivity extends BaseActivity {

    private Toolbar toolbar;
    private ListView listView;
    private RelativeLayout all;
    private RelativeLayout pending;
    private RelativeLayout paid;
    private TextView tvAll;
    private TextView tvPending;
    private TextView tvPaid;
    private RelativeLayout blank;
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_layout);
        init();
        initToolbar(toolbar);
        initTransactions();
        blank.setVisibility(View.INVISIBLE);
        TransactionAdapter adapter = new TransactionAdapter(TransactionActivity.this, R.layout.transaction_item, transactions);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Transaction transaction = transactions.get(i);
                Toast.makeText(TransactionActivity.this, transaction.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        all.setOnClickListener(view -> {
            resetStyle();
            tvAll.setTextColor(this.getResources().getColor(R.color.text_blue));
            tvAll.setBackgroundResource(R.drawable.bottom_blue_border);
            listView.setVisibility(View.VISIBLE);
        });
        pending.setOnClickListener(view -> {
            resetStyle();
            tvPending.setTextColor(this.getResources().getColor(R.color.text_blue));
            tvPending.setBackgroundResource(R.drawable.bottom_blue_border);
            blank.setVisibility(View.VISIBLE);
        });
        paid.setOnClickListener(view -> {
            resetStyle();
            tvPaid.setTextColor(this.getResources().getColor(R.color.text_blue));
            tvPaid.setBackgroundResource(R.drawable.bottom_blue_border);
            listView.setVisibility(View.VISIBLE);
        });
    }

    private void resetStyle() {
        listView.setVisibility(View.INVISIBLE);
        blank.setVisibility(View.INVISIBLE);
        tvAll.setTextColor(this.getResources().getColor(R.color.black));
        tvPending.setTextColor(this.getResources().getColor(R.color.black));
        tvPaid.setTextColor(this.getResources().getColor(R.color.black));
        tvAll.setBackgroundResource(R.drawable.none_style);
        tvPending.setBackgroundResource(R.drawable.none_style);
        tvPaid.setBackgroundResource(R.drawable.none_style);
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_transaction_title);
        listView = findViewById(R.id.lv_transaction_list);
        listView.setDivider(null);
        all = findViewById(R.id.tracsation_all);
        pending = findViewById(R.id.tracsation_pending);
        paid = findViewById(R.id.tracsation_paid);
        tvAll = findViewById(R.id.trasnsaction_tv_all);
        tvPending = findViewById(R.id.trasnsaction_tv_pending);
        tvPaid = findViewById(R.id.trasnsaction_tv_paid);
        blank = findViewById(R.id.transaction_blank);
    }

    protected void initTransactions() {
        for (int i = 1; i < 18; i++) {
            Date now = new Date(new Date().getTime() + (i * 3600000));
            double c = (double) (Math.round(i * 10000 / 3) / 100.0);
            String price = String.valueOf(c);
            Transaction transaction = new Transaction("应急培训-三岗三类人员-第" + i + "节测试", new Date().getTime(), DateFormat.format("yyyy-MM-dd HH:mm", now).toString(), price, R.drawable.ic_weixin, "已付款");
            transactions.add(transaction);
        }
    }
}