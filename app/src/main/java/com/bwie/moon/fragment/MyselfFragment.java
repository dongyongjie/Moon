package com.bwie.moon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.moon.R;

/**
 * Created by lenovo on 2017/2/9.
 */

public class MyselfFragment extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
//        Bundle bundle = getArguments();
//        String agrs1 = bundle.getString("agrs1");
//        TextView tv = (TextView)view.findViewById(R.id.tv_location);
//        tv.setText(agrs1);
        return view;
    }
}
