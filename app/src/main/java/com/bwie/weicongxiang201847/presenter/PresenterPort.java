package com.bwie.weicongxiang201847.presenter;

import com.bwie.weicongxiang201847.bean.LieBiaoBean;

import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/7.
 */

public interface PresenterPort {
    void getResponseBodyBean(ResponseBody responseBody);
    void getError(Throwable throwable);
    void getBean(LieBiaoBean lieBiaoBean);
}
