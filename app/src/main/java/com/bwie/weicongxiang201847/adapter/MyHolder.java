package com.bwie.weicongxiang201847.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.weicongxiang201847.R;

/**
 * Created by admin on 2018/4/7.
 */

public class MyHolder extends RecyclerView.ViewHolder {

    public ImageView image_tu;
    public TextView text_title;
    public TextView text_time;

    public MyHolder(View itemView) {
        super(itemView);
        image_tu = itemView.findViewById(R.id.image_tu);
        text_title = itemView.findViewById(R.id.text_title);
        text_time = itemView.findViewById(R.id.text_time);
    }
}
