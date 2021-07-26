package com.example.dzwxdemo;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.dzwxdemo.adapter.ExamAdapter;
import com.example.dzwxdemo.adapter.TransactionAdapter;
import com.example.dzwxdemo.dto.Exam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ExamActivity extends BaseActivity {

    private Toolbar toolbar;
    private ListView listView;
    private List<Exam> exams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_layout);
        init();
        initToolbar(toolbar);
        initExam();
        ExamAdapter adapter = new ExamAdapter(ExamActivity.this, R.layout.exam_item, exams);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Exam exam = exams.get(i);
                Toast.makeText(ExamActivity.this, exam.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_exam_title);
        listView = findViewById(R.id.lv_exam_list);
        listView.setDivider(null);
    }

    protected void initExam() {
        for (int i = 1; i < 18; i++) {
            Date now = new Date(new Date().getTime() + (i * 3600000));
            String grade = String.valueOf((int) (Math.random() * 100));
            Exam exam = new Exam((long) i, R.drawable.ic_weixin, "应急培训-三岗三类人员-第" + i + "节测试", grade, DateFormat.format("yyyy-MM-dd HH:mm", now).toString());
            exams.add(exam);
        }
    }
}