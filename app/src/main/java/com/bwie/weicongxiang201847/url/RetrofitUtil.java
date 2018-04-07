package com.bwie.weicongxiang201847.url;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2018/4/7.
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil=null;
    private Retrofit retrofit;

    private RetrofitUtil(){

    }
    private RetrofitUtil(String baseurl){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitUtil getFice(String baseurl){
        if (retrofitUtil==null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil==null){
                    retrofitUtil=new RetrofitUtil(baseurl);
                }
            }
        }
        return retrofitUtil;
    }

    public <T> T getCreateService(Class<T> service){

        return retrofit.create(service);
    }
    public static ApiService setService(){

        return RetrofitUtil.getFice(ApiUrl.gongtong).getCreateService(ApiService.class);
    }

}
