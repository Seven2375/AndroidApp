package com.example.day01_c;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private ViewPager viewpager;
    private BannerAdapter adapter;

    private static List<Integer> sColor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initUI();
    }

    private void initUI() {
        viewpager = findViewById(R.id.banner_image);
        adapter = new BannerAdapter(sColor);
    }
}