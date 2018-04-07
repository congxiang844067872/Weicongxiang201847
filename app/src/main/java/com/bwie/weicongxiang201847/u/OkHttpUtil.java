package com.bwie.weicongxiang201847.u;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by admin on 2018/4/7.
 */

public class OkHttpUtil {
    private static OkHttpClient okHttpClient=null;

    private OkHttpUtil(){

    }

    private static OkHttpClient getInstance(){
        if (okHttpClient==null){
            synchronized (OkHttpUtil.class){
                if (okHttpClient==null){
                    File sdcache = new File(Environment.getExternalStorageDirectory(), "cache");
                    //指定缓存大小
                    int cacheSize = 10 * 1024 * 1024;

                    okHttpClient = new OkHttpClient.Builder()//构建器
                            .connectTimeout(15, TimeUnit.SECONDS)//连接超时
                            .writeTimeout(20, TimeUnit.SECONDS)//写入超时
                            .readTimeout(20, TimeUnit.SECONDS)//读取超时

                            //.addInterceptor(new CommonParamsInterceptor())//添加的是应用拦截器...公共参数
                            //.addNetworkInterceptor(new CacheInterceptor())//添加的网络拦截器

                            .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize))//设置缓存
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    public static void doGet(String oldUrl, Callback callback){
        /*StringBuilder stringBuilder = new StringBuilder();//创建一个stringBuilder

        stringBuilder.append(oldUrl);*/

        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        //创建Request
        Request request = new Request.Builder().url(oldUrl).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }



}
