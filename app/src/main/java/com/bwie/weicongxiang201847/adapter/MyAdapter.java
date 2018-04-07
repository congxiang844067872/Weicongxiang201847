package com.bwie.weicongxiang201847.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.weicongxiang201847.R;
import com.bwie.weicongxiang201847.activity.LieBiaoActivity;
import com.bwie.weicongxiang201847.bean.LieBiaoBean;
import com.bwie.weicongxiang201847.view.SetOnClicked;

/**
 * Created by admin on 2018/4/7.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private final Context context;
    private final LieBiaoBean lieBiaoBean;
    private SetOnClicked setOnClicked;

    public MyAdapter(Context context, LieBiaoBean lieBiaoBean) {

        this.context = context;
        this.lieBiaoBean = lieBiaoBean;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_liebiao, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        Glide.with(context).load(lieBiaoBean.getNewslist()
                .get(position).getPicUrl()).into(holder.image_tu);
        holder.text_title.setText(lieBiaoBean.getNewslist().get(position).getTitle());
        holder.text_time.setText(lieBiaoBean.getNewslist().get(position).getCtime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClicked.getOncLick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lieBiaoBean.getNewslist().size();
    }


    public void setdianjishijian(SetOnClicked setOnClicked) {


        this.setOnClicked = setOnClicked;
    }
}
