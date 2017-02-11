package com.bwie.moon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.moon.R;
import com.bwie.moon.adapter.RvAdapter3;
import com.bwie.moon.bean.Products;
import com.bwie.moon.bean.RootBean;
import com.bwie.moon.utils.Path;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */

public class TabFragment extends Fragment {
    private View view;
    private String path=null;
    private RecyclerView favorable_recyclerView;

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
        initView();
        panduan(count);
    }

    private void initView() {
        favorable_recyclerView = (RecyclerView) view.findViewById(R.id.favorable_recyclerView);
        favorable_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
                String result = responseInfo.result;
                Gson gson = new Gson();
                RootBean bean = gson.fromJson(result, RootBean.class);
//                Log.i("TAG", "onSuccess: "+bean.toString());
                List<Products> products = bean.getData().getProducts();
                RvAdapter3 rvAdapter3 = new RvAdapter3(getContext(), products);
                String name = products.get(0).getName();
                Log.i("TAG", "onSuccess: "+name);
                favorable_recyclerView.setAdapter(rvAdapter3);
//                rvAdapter3.notifyDataSetChanged();
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }
}
