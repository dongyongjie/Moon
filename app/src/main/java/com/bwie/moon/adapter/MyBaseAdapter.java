package com.bwie.moon.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.moon.R;

/**
 * Created by lenovo on 2017/2/11.
 */

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private String[] titles;
    private int[] images;

    public MyBaseAdapter(Context context, String[] titles, int[] images) {
        this.context = context;
        this.titles = titles;
        this.images = images;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return titles[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder v;
        if (view == null) {
            view=View.inflate(context, R.layout.listview_item,null);
            v=new ViewHolder();
            v.imageView1= (ImageView) view.findViewById(R.id.listView_imageView1);
            v.imageView2= (ImageView) view.findViewById(R.id.listView_imageView2);
            v.title= (TextView) view.findViewById(R.id.listView_textView);
            view.setTag(v);
        }else {
            v= (ViewHolder) view.getTag();
        }
        v.imageView1.setImageResource(images[i]);
        v.imageView2.setImageResource(R.drawable.arrow_listpage_normal);
        v.title.setText(titles[i]);
        return view;
    }
    class ViewHolder{
        ImageView imageView1,imageView2;
        TextView title;
    }
}
