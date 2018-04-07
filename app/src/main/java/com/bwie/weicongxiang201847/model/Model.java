package com.bwie.weicongxiang201847.model;

import com.bwie.weicongxiang201847.presenter.PresenterPort;
import com.bwie.weicongxiang201847.u.OkHttpUtil;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/7.
 */

public class Model {

    private PresenterPort presenterPort;
    private Disposable d;
    public Model(PresenterPort presenterPort) {

        this.presenterPort = presenterPort;
    }

    public void getUrl(Observable<ResponseBody> responseBodyObservable) {
        responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                        Model.this.d = d;
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        presenterPort.getResponseBodyBean(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void setJieYue() {
        d.dispose();
    }

    public void getUrlBean(String bean) {
        OkHttpUtil.doGet(bean, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String json = response.body().toString();


                }
            }
        });
    }
}
