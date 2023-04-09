package com.example.anywallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<List> {
    private Context mContext;
    private int mResource;
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<List> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        convertView=layoutInflater.inflate(mResource,parent,false);
        ImageView imageView=convertView.findViewById(R.id.img_list);
        TextView textList=convertView.findViewById(R.id.text_list);
        TextView signList=convertView.findViewById(R.id.sign_list);
        imageView.setImageResource(getItem(position).getImage());
        textList.setText(getItem(position).getAmount());
        signList.setText(getItem(position).getSign());
        return convertView;
    }
}
