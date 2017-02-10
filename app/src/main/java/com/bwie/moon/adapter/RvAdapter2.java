package com.bwie.moon.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.moon.R;
import com.bwie.moon.bean.Products;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */

public class RvAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Products> list;
    private int count;
    private static final int NORMAL_TYPE = 0;
    private static final int CHECK_TYPE = 1;
    private OnItemClickListener clickListener;
    private ImageLoader imageLoader;
    private final DisplayImageOptions.Builder builder;

    public RvAdapter2(Context context, List<Products> list) {
        super();
        this.context = context;
        this.list = list;

        builder = new DisplayImageOptions.Builder();
        builder.bitmapConfig(Bitmap.Config.RGB_565);
        builder.cacheOnDisk(true);
        builder.cacheInMemory(true);
    }
    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public static interface OnItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public int getItemViewType(int position) {
        String featured_price = list.get(position).getFeatured_price();
        if (featured_price == null) {
            return NORMAL_TYPE;
        }
        return CHECK_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NORMAL_TYPE) {
            return new ViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));
        } else {
            return new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item2, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder , int position) {
        imageLoader = ImageLoader.getInstance();
        if (holder instanceof ViewHolder1) {
            imageLoader.displayImage(list.get(position).getImage_small(),((ViewHolder1) holder).imageView1,builder.build());
            ((ViewHolder1) holder).title1.setText(list.get(position).getName());
            ((ViewHolder1) holder).price1.setText(list.get(position).getPrice());
        } else {
            imageLoader.displayImage(list.get(position).getImage_small(),((ViewHolder2) holder).imageView2,builder.build());
            ((ViewHolder2) holder).title2.setText(list.get(position).getName());
            ((ViewHolder2) holder).price2.setText(list.get(position).getPrice());
            ((ViewHolder2) holder).price3.setText(list.get(position).getFeatured_price());
            ((ViewHolder2) holder).price3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            ((ViewHolder2) holder).price4.setText("立减2元");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{
        private ImageView imageView1;
        private TextView title1,price1;
        public ViewHolder1(View itemView) {
            super(itemView);
            imageView1= (ImageView) itemView.findViewById(R.id.recyclerView_item_ImageView);
            title1= (TextView) itemView.findViewById(R.id.recyclerView_item_Title);
            price1= (TextView) itemView.findViewById(R.id.recyclerView_item_Price);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        private ImageView imageView2;
        private TextView title2,price2,price3,price4;
        public ViewHolder2(View itemView) {
            super(itemView);
            imageView2= (ImageView) itemView.findViewById(R.id.recyclerView_item2_ImageView);
            title2= (TextView) itemView.findViewById(R.id.recyclerView_item2_Title);
            price2= (TextView) itemView.findViewById(R.id.recyclerView_item2_Price);
            price3= (TextView) itemView.findViewById(R.id.recyclerView_item2_Price2);
            price4= (TextView) itemView.findViewById(R.id.recyclerView_item2_Price3);
        }
    }
}
