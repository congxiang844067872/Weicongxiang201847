package com.bwie.weicongxiang201847.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.bwie.weicongxiang201847.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangQingActivity extends AppCompatActivity {

    @BindView(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        ButterKnife.bind(this);

        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);


    }
}
