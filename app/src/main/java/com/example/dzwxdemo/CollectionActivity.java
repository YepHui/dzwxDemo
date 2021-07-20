package com.example.dzwxdemo;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.dzwxdemo.adapter.CollectionAdapter;
import com.example.dzwxdemo.dto.Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionActivity extends BaseActivity {

    private Toolbar toolbar;
    private ListView listView;
    private List<Collection> collections = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_layout);
        init();
        initToolbar(toolbar);
        initCollection();
        CollectionAdapter adapter = new CollectionAdapter(CollectionActivity.this, R.layout.collection_item, collections);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Collection collection = collections.get(i);
                Toast.makeText(CollectionActivity.this, collection.getId().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_collection_title);
        listView = findViewById(R.id.lv_collection_list);
        listView.setDivider(null);
    }

    private void initCollection() {
        for (int i = 1; i < 18; i++) {
            Collection collection = new Collection((long) i, "应急培训-三岗三类人员-第" + i + "节测试", R.drawable.weixin_logo);
            collections.add(collection);
        }

    }
}