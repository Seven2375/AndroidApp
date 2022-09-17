package com.example.day01_c;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    private ViewPager viewpager;
    private static List<Integer> images = new ArrayList<>();

    static {
        images.add(R.drawable.banner);
        images.add(R.drawable.banner2);
        images.add(R.drawable.banner3);
    }

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initUI();

        handler = new Handler();
        handler.post(runimg);//开始轮播图片

    }
    private Runnable runimg = new Runnable() {
        @Override
        public void run() {
            //切换viewpage视图的下一个图片
            int currentItem = viewpager.getCurrentItem();
            viewpager.setCurrentItem(++currentItem,true);
            handler.postDelayed(this,2000);
        }
    };

    private void initUI() {
        viewpager = findViewById(R.id.banner_image);
        BannerAdapter adapter = new BannerAdapter();
        adapter.setData(images);    //设置数据
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(images.size()*100,false);  //设置起点为第100
    }
}