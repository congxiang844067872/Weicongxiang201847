package com.bwie.weicongxiang201847;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bwie.weicongxiang201847.activity.GaoDeActivity;
/*
*首先使用属性动画完成菜单栏伸缩
* 集成高德地图SDK
* 展示地图获取经纬度
* 吐司跳转显示列表
* 给列表设置点击事件，
* 点击跳转详情
*
*
* */
public class MainActivity extends AppCompatActivity  implements AMapLocationListener  {

    private ImageView image_view;
    private ImageView image_qq;
    private ImageView image_weixin;
    private ImageView image_user;
    private RelativeLayout r;
    private AMapLocationClient mLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btntiao=findViewById(R.id.btntiao);
        image_view = findViewById(R.id.image_view);
        image_qq = findViewById(R.id.image_qq);
        image_weixin = findViewById(R.id.image_weixin);
        image_user = findViewById(R.id.image_user);
        r = findViewById(R.id.r);
        image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setVisibility(View.VISIBLE);
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int screenHeight = metrics.heightPixels;
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(image_qq, "y", image_qq.getTop(), (screenHeight-image_view.getHeight())/4);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(image_weixin
                        , "y", image_weixin.getTop(), (screenHeight-image_view.getHeight())/3);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(image_user
                        , "y", image_user.getTop(), (screenHeight-image_view.getHeight())/2);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(animator1).with(animator2).with(animator3);
                animSet.setDuration(1000);
                animSet.start();

            }
        });

        btntiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GaoDeActivity.class);
                startActivity(intent);

                //1.初始化定位
                mLocationClient = new AMapLocationClient(MainActivity.this);
                //2.设置定位回调监听
                //mLocationClient.setLocationListener(this);
                //mLocationClient.setLocationListener(this);

                //2....2给定位客户端对象设置定位参数
                AMapLocationClientOption mLocationOption = new AMapLocationClientOption();

                //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
                mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

                //获取一次定位结果：
                mLocationOption.setOnceLocation(true);
                //获取最近3s内精度最高的一次定位结果：
                mLocationOption.setOnceLocationLatest(true);

                mLocationClient.setLocationOption(mLocationOption);
                //3.启动定位
                mLocationClient.startLocation();

            }
        });
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        //获取定位的结果
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("配送至:"+aMapLocation.getCity()+"--");
        stringBuilder.append(""+aMapLocation.getDistrict()+"--");
        stringBuilder.append(""+aMapLocation.getStreet()+"--");
        stringBuilder.append(""+aMapLocation.getStreetNum()+"");

        Toast.makeText(MainActivity.this
                ,stringBuilder.toString()+"",Toast.LENGTH_LONG).show();
    }

}
