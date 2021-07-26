package com.example.dzwxdemo;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_layout);
        init();
        initToolbar(toolbar);
        initTransactions();
        TransactionAdapter adapter = new TransactionAdapter(TransactionActivity.this, R.layout.transaction_item, transactions);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Transaction transaction = transactions.get(i);
                Toast.makeText(TransactionActivity.this, transaction.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_transaction_title);
        listView = findViewById(R.id.lv_transaction_list);
        listView.setDivider(null);
    }

    protected void initTransactions() {
        for (int i = 1; i < 18; i++) {
            Date now = new Date(new Date().getTime() + (i * 3600000));
            double c = (double) (Math.round(i * 10000 / 3) / 100.0);
            String price = String.valueOf(c);
            Transaction transaction = new Transaction("应急培训-三岗三类人员-第" + i + "节测试", new Date().getTime(), DateFormat.format("yyyy-MM-dd HH:mm", now).toString(), price, R.drawable.ic_weixin);
            transactions.add(transaction);
        }
    }
}