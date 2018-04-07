package com.bwie.weicongxiang201847.view;

import com.bwie.weicongxiang201847.bean.LieBiaoBean;

import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/7.
 */

public interface MyView {
    void getResponseBodyBean(ResponseBody responseBody);
    void getError(Throwable throwable);
    void getBean(LieBiaoBean lieBiaoBean);
}
