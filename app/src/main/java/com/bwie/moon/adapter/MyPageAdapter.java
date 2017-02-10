package com.bwie.moon.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    private String[] titles;
    private Context context;

    public MyPageAdapter(FragmentManager fm, List<Fragment> list, String[] titles, Context context) {
        super(fm);
        this.list = list;
        this.titles = titles;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
