package com.bwie.weicongxiang201847.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bwie.weicongxiang201847.R;
import com.bwie.weicongxiang201847.adapter.MyAdapter;
import com.bwie.weicongxiang201847.bean.LieBiaoBean;
import com.bwie.weicongxiang201847.presenter.Presenter;
import com.bwie.weicongxiang201847.url.ApiUrl;
import com.bwie.weicongxiang201847.url.RetrofitUtil;
import com.bwie.weicongxiang201847.view.MyView;
import com.bwie.weicongxiang201847.view.SetOnClicked;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class LieBiaoActivity extends AppCompatActivity implements MyView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lie_biao);
        ButterKnife.bind(this);

        presenter = new Presenter(this);
        presenter.attachView(this);
        Map<String, String> map = new HashMap<>();
        //?key=71e58b5b2f930eaf1f937407acde08fe&num=10
        map.put("key","71e58b5b2f930eaf1f937407acde08fe");
        map.put("num","10");
        presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.liebiao,map));
        //presenter.getUrlBean(ApiUrl.bean);
    }

    @Override
    public void getResponseBodyBean(ResponseBody responseBody) {
        try {
            //Log.d("++++++",responseBody.string());
            final LieBiaoBean lieBiaoBean = new Gson().fromJson(responseBody
                    .string(), LieBiaoBean.class);
            recyclerView.setLayoutManager(new LinearLayoutManager(this
                    ,LinearLayoutManager.VERTICAL,false));
            MyAdapter adapter = new MyAdapter(this, lieBiaoBean);
            recyclerView.setAdapter(adapter);
            adapter.setdianjishijian(new SetOnClicked() {
                @Override
                public void getOncLick(int position) {
                    Intent intent = new Intent(LieBiaoActivity
                            .this, XiangQingActivity.class);
                    intent.putExtra("url",lieBiaoBean.getNewslist().get(position).getUrl()+"");
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getError(Throwable throwable) {

    }

    @Override
    public void getBean(LieBiaoBean lieBiaoBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.setJieYue();
        if (presenter!=null){
            presenter.detachView();
        }
    }
}
