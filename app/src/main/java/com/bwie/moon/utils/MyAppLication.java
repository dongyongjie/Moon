package com.bwie.moon.utils;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by lenovo on 2017/2/10.
 */

public class MyAppLication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initView();
    }

    private void initView() {
        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration.Builder builder=new ImageLoaderConfiguration.Builder(this);
        imageLoader.init(builder.build());

    }
}
