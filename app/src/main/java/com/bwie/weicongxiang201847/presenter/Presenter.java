package com.bwie.weicongxiang201847.presenter;

import com.bwie.weicongxiang201847.activity.LieBiaoActivity;
import com.bwie.weicongxiang201847.bean.LieBiaoBean;
import com.bwie.weicongxiang201847.model.Model;
import com.bwie.weicongxiang201847.view.MyView;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/7.
 */

public class Presenter extends BasePresenter implements PresenterPort{
    private MyView myView;
    private final Model model;

    public Presenter(MyView myView) {
        model = new Model(this);
        this.myView = myView;
    }

    @Override
    public void getResponseBodyBean(ResponseBody responseBody) {
        myView.getResponseBodyBean(responseBody);
    }

    @Override
    public void getError(Throwable throwable) {

    }

    @Override
    public void getBean(LieBiaoBean lieBiaoBean) {

    }

    public void getUrl(Observable<ResponseBody> responseBodyObservable) {
        model.getUrl(responseBodyObservable);
    }

    public void setJieYue() {
        model.setJieYue();
    }

    public void getUrlBean(String bean) {
        model.getUrlBean(bean);
    }
}
