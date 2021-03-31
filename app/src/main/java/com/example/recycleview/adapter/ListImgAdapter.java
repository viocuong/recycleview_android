package com.example.recycleview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.recycleview.R;

import java.util.List;

public class ListImgAdapter extends ArrayAdapter<Integer> {
    private List<Integer> mList;
    private Activity activity;
    public ListImgAdapter(@NonNull Context context, List<Integer> list) {
        super(context, R.layout.item_spiner,list);
        mList = list;
        activity = (Activity) context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.item_spiner,parent,false);
        ImageView img = v.findViewById(R.id.imgSpinerItem);
        img.setImageResource(mList.get(position));
        return v;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.item_spiner,parent,false);
        ImageView img = v.findViewById(R.id.imgSpinerItem);
        img.setImageResource(mList.get(position));
        return v;
    }


}
