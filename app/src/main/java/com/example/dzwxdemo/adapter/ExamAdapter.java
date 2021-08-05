package com.example.dzwxdemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dzwxdemo.R;
import com.example.dzwxdemo.dto.Exam;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExamAdapter extends ArrayAdapter<Exam> {
    private int resourceId;

    public ExamAdapter(@NonNull Context context, int resource, @NonNull List<Exam> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Exam exam = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        //CircleImageView image = view.findViewById(R.id.exam_image);
        TextView name = view.findViewById(R.id.exam_name);
        TextView time = view.findViewById(R.id.exam_time);
        TextView grade = view.findViewById(R.id.exam_grade);
        //image.setImageResource(exam.getImgUrl());
        name.setText(exam.getName());
        time.setText(exam.getTime());
        grade.setText(exam.getGrade() + "分");
        /*if (Integer.parseInt(exam.getGrade()) < 60) {
            grade.setTextColor(R.color.red);
        }*/
        return view;
    }
}
