package com.bwie.moon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.moon.R;
import com.bwie.moon.adapter.MyBaseAdapter;

/**
 * Created by lenovo on 2017/2/9.
 */

public class MyselfFragment extends Fragment {

    private View view;
    private ListView myself_listView1;
    private ListView myself_listView2;
    private ImageView headportrait;
    private TextView login;
    private TextView register;
    private ImageView registeright;
    private LinearLayout myself_line1;
    private LinearLayout myself_line2;
    private LinearLayout myself_line3;
    private RelativeLayout re2;
    private String[] title1s=new String[]{
            "优惠红包","我的收藏","最近游览"
    };
    private String[] title2s=new String[]{
            "店址导航","关于我们"
    };
    private int[] image1s=new int[]{
            R.drawable.collect,
            R.drawable.my_wallet_user_icon_normal,
            R.drawable.main_index_search_normal
    };
    private int[] image2s=new int[]{
            R.drawable.ic_address_40,
            R.drawable.my_favorite_user_icon_normal,
    };

    public static MyselfFragment newInstance(String param1) {
        MyselfFragment fragment = new MyselfFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MyselfFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_myself, container, false);
//        Bundle bundle = getArguments();
//        String agrs1 = bundle.getString("agrs1");
//        TextView tv = (TextView)view.findViewById(R.id.tv_location);
//        tv.setText(agrs1);
        initView();
        return view;
    }

    private void initView() {
        myself_listView1 = (ListView) view.findViewById(R.id.myself_listView1);
        myself_listView2 = (ListView) view.findViewById(R.id.myself_listView2);
        headportrait = (ImageView) view.findViewById(R.id.Headportrait);
        login = (TextView) view.findViewById(R.id.login);
        register = (TextView) view.findViewById(R.id.register);
        registeright = (ImageView) view.findViewById(R.id.registeright);
        myself_line1 = (LinearLayout) view.findViewById(R.id.myself_line1);
        myself_line2 = (LinearLayout) view.findViewById(R.id.myself_line2);
        myself_line3 = (LinearLayout) view.findViewById(R.id.myself_line3);
        re2 = (RelativeLayout) view.findViewById(R.id.re2);
        myself_listView1.setAdapter(new MyBaseAdapter(getContext(),title1s,image1s));
        myself_listView2.setAdapter(new MyBaseAdapter(getContext(),title2s,image2s));
    }
}
