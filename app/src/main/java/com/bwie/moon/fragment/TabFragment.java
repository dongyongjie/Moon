package com.bwie.moon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.moon.R;
import com.bwie.moon.utils.Path;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by lenovo on 2017/2/10.
 */

public class TabFragment extends Fragment {

    private View view;
    private String path=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        int count = bundle.getInt("path",0);
        panduan(count);
    }

    private void panduan(int count) {
        switch (count){
            case 0:
                path= Path.kUrlGetFeaturedProducts;
                break;
            case 1:
                path= Path.kUrlGetTopicProducts;
                break;
            case 2:
                path= Path.kUrlGetFeaturedProducts;
                break;
        }
        lianwang();
    }

    private void lianwang() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, path, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }
}
