package com.bwie.weicongxiang201847.zidingyi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwie.weicongxiang201847.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/7.
 */

public class MMenu extends RelativeLayout implements View.OnClickListener {
    private ImageView center,home,call,hyperlink;

    private List<ImageView> oViews;

    private boolean mFlag=true;

    private float mHiddenViewMeasuredHeight;

    public MMenu(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.menu_layout, this);
        center=(ImageView) findViewById(R.id.center);
        call=(ImageView) findViewById(R.id.call);
        home=(ImageView) findViewById(R.id.home);
        hyperlink=(ImageView) findViewById(R.id.hyperlink);

        //将四个Imageview放在集合里，方便管理
        oViews=new ArrayList<ImageView>();
        oViews.add(center);
        oViews.add(call);
        oViews.add(home);
        oViews.add(hyperlink);

        center.setOnClickListener(this);
        call.setOnClickListener(this);
        home.setOnClickListener(this);
        hyperlink.setOnClickListener(this);
    }

    public MMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home:
                break;
        }
    }
}
