package com.example.alllayoutsdesign;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyImageAdapter extends BaseAdapter {

    int [] images;
    Context mContext;
    Animation animation = new Animation() {
        @Override
        public void startNow() {
            super.startNow();
        }
    };

    public MyImageAdapter(Context context, int [] images)
    {
        mContext = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(images[position]);
        //imageView.setAnimation(animation);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(600, 600));

        return imageView;
    }
}
