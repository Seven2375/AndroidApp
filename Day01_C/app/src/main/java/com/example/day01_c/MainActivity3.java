package com.example.day01_c;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    private ViewPager viewpager;
    private List<imageInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        list = imageInfo.getList();


        initUI();
    }

    private void initUI() {
        viewpager = findViewById(R.id.banner_image);
        BannerAdapter adapter = new BannerAdapter(list,this);
        viewpager.setAdapter(adapter);
    }
}