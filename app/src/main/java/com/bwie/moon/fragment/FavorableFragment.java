package com.bwie.moon.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.moon.R;
import com.bwie.moon.adapter.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/9.
 */

public class FavorableFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list=new ArrayList<>();
    private String[] titles=new String[]{
            "天天优惠","为你精选","亲的最爱"
    };

    public static FavorableFragment newInstance(String param1) {
        FavorableFragment fragment = new FavorableFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public FavorableFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorable, container, false);
//        Bundle bundle = getArguments();
//        String agrs1 = bundle.getString("agrs1");
//        TextView tv = (TextView)view.findViewById(R.id.tv_location);
//        tv.setText(agrs1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addFragment();
        initView();
    }

    private void initView() {
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(new MyPageAdapter(getActivity().getSupportFragmentManager(),list,titles,getContext()));
//        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
    }
    public void addFragment(){
        list.clear();
        for (int i = 0; i < titles.length; i++) {
            TabFragment fragment=new TabFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("path",i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
    }
}
