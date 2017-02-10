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
import com.bwie.moon.adapter.RvAdapter;
import com.bwie.moon.adapter.RvAdapter2;
import com.bwie.moon.bean.Drink;
import com.bwie.moon.bean.Products;
import com.bwie.moon.bean.Titles;
import com.bwie.moon.utils.Path;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/9.
 */

public class LocationFragment extends Fragment {

    private View view;
    private int count=0;
    private List<Drink> categories=new ArrayList<>();
//    private String path="http://eleteamapi.ygcr8.com/v1/category/list-with-product";
    private RecyclerView locationFragment_recyclerView1;
    private RecyclerView locationFragment_recyclerView2;
    private RvAdapter2 adapter;
    private Titles titles;

    public static LocationFragment newInstance(String param1) {
        LocationFragment fragment = new LocationFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public LocationFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        addMessage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_location, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
//        TextView tv = (TextView) view.findViewById(R.id.tv_location);
//        tv.setText(agrs1);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addMessage();


    }

    private void addMessage() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, Path.kUrlCategoryListWithProduct, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Gson gson = new Gson();
                titles = gson.fromJson(result, Titles.class);
//                categories = titles.getData().getCategories();
                categories.addAll(titles.getData().getCategories());

                Log.i("TAG", "onSuccess: "+categories.toString());
                initView();
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
//        list.add("功夫茶");
//        list.add("秘制奶盖");
//        list.add("鲜茶特调");
//        list.add("香浓淳奶");
//        list.add("鲜果汁");
//        list.add("世界好茶");
//        list.add("冰沙风暴");
//        list.add("现磨咖啡");
//        list.add("超级热饮");
//        list.add("茉莉花茶");
//        list.add("拿铁咖啡");
    }

    private void initView() {
        locationFragment_recyclerView1 = (RecyclerView) view.findViewById(R.id.locationFragment_recyclerView1);
        locationFragment_recyclerView2 = (RecyclerView) view.findViewById(R.id.locationFragment_recyclerView2);
        locationFragment_recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        locationFragment_recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        RvAdapter adapter = new RvAdapter(getContext(), categories);
        locationFragment_recyclerView1.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        locationFragment_recyclerView1
        play1(0);
        adapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View viewHolder, int pos) {
                play1(pos);
            }
        });
    }

    private void play1(int pos) {
        List<Products> list = titles.getData().getCategories().get(pos).getProducts();
        adapter = new RvAdapter2(getContext(), list);
        locationFragment_recyclerView2.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        categories.clear();
    }
}
