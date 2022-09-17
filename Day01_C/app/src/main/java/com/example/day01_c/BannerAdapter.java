package com.example.day01_c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends PagerAdapter {

    private final Context mcontext;
    private final List<imageInfo> imagelist;

    private List<ImageView> viewList = new ArrayList<>();

    public BannerAdapter(List<imageInfo> list,Context mcontext) {
        this.mcontext = mcontext;
        this.imagelist = list;

        for(imageInfo info:list){
            ImageView view = new ImageView(mcontext);
            view.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            view.setImageResource(info.image);
            viewList.add(view);
        }

    }

    @Override
    public int getCount() {
        return imagelist.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView item = viewList.get(position);
        container.addView(item);
        return  item;
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
