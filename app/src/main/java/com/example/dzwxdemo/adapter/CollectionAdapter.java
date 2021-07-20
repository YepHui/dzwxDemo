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
import com.example.dzwxdemo.dto.Collection;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CollectionAdapter extends ArrayAdapter<Collection> {
    private int resourceId;

    public CollectionAdapter(@NonNull Context context, int resource, @NonNull List<Collection> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Collection collection = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        CircleImageView image = view.findViewById(R.id.collection_image);
        TextView name = view.findViewById(R.id.collection_name);
        image.setImageResource(collection.getImgUrl());
        name.setText(collection.getName());
        return view;
    }
}
