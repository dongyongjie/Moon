package com.bwie.moon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bwie.moon.fragment.FavorableFragment;
import com.bwie.moon.fragment.LocationFragment;
import com.bwie.moon.fragment.MyselfFragment;
import com.bwie.moon.fragment.ShoppingFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private ArrayList<Fragment> fragments;
    private LocationFragment mLocationFragment;
    private FavorableFragment mFavorableFragment;
    private ShoppingFragment mShoppingFragment;
    private MyselfFragment mMyselfFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加导航栏
        addNavigation();
        initView();
    }

    private void initView() {

    }

    private void addNavigation() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.tab_home, "月光茶人").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.tab_topic, "优惠").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.main_index_cart_normal, "购物车").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.main_index_my_normal, "我的").setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();

    }
    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        mLocationFragment = LocationFragment.newInstance("位置");
        transaction.replace(R.id.fr, mLocationFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        Log.d("TAG", "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance("位置");
                }
                transaction.replace(R.id.fr, mLocationFragment);
                break;
            case 1:
                if (mFavorableFragment == null) {
                    mFavorableFragment = mFavorableFragment.newInstance("发现");
                }
                transaction.replace(R.id.fr, mFavorableFragment);
                break;
            case 2:
                if (mShoppingFragment == null) {
                    mShoppingFragment = mShoppingFragment.newInstance("爱好");
                }
                transaction.replace(R.id.fr, mShoppingFragment);
                break;
            case 3:
                if (mMyselfFragment == null) {
                    mMyselfFragment = mMyselfFragment.newInstance("图书");
                }
                transaction.replace(R.id.fr, mMyselfFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
