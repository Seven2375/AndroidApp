package com.example.day01_c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class BannerAdapter extends PagerAdapter {


    private List<Integer> images = null;

    public void setData(List<Integer> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int realPosition = position % images.size();
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(images.get(realPosition));
        container.addView(imageView);
        return  imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

}
