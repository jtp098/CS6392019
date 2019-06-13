package com.example.imageviewer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {
    private Context mContext;

    public MyAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(250, 300));
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        return imageView;
    }

    private Integer[] images = {
            R.drawable.rainy_day, R.drawable.cat2,
            R.drawable.cat3, R.drawable.cat4,
            R.drawable.cat5, R.drawable.cat6

    };
}
