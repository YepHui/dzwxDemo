package com.example.dzwxdemo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dzwxdemo.R;
import com.example.dzwxdemo.dto.Transaction;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TransactionAdapter extends ArrayAdapter<Transaction> {

    private int resourceId;

    public TransactionAdapter(@NonNull Context context, int resource, @NonNull List<Transaction> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Transaction transaction = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        CircleImageView image = view.findViewById(R.id.transaction_image);
        TextView name = view.findViewById(R.id.transaction_name);
        TextView id = view.findViewById(R.id.transaction_id);
        TextView time = view.findViewById(R.id.transaction_time);
        TextView price = view.findViewById(R.id.transaction_price);
        image.setImageResource(transaction.getImageUrl());
        name.setText(transaction.getName());
        id.setText(transaction.getId().toString());
        time.setText(transaction.getCreateTime());
        price.setText(transaction.getPrice());
        return view;
    }
}
