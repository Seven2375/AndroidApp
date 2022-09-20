package com.example.day01_c;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private ViewPager viewpager;
    private static List<Integer> images = new ArrayList<>();

    static {
        images.add(R.drawable.banner);
        images.add(R.drawable.banner2);
        images.add(R.drawable.banner3);
    }

    private Handler handler;
    private LinearLayout points;
    private BannerAdapter adapter;
    private EditText et_date;
    private Button btn_jipiao;
    private EditText et_from_city;
    private EditText et_to_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initUI();

        handler = new Handler();
        //handler.post(runimg);//开始轮播图片

    }
    private Runnable runimg = new Runnable() {
        @Override
        public void run() {
            //切换viewpage视图的下一个图片
            int currentItem = viewpager.getCurrentItem();
            viewpager.setCurrentItem(++currentItem,true);
            handler.postDelayed(this,2000);//2秒一次
        }
    };

    private void initUI() {
        viewpager = findViewById(R.id.banner_image);//轮播图
        //设置轮播图适配器
        adapter = new BannerAdapter();
        adapter.setData(images);    //设置图片数据
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(this);//给图片设置监听
        //根据图片个数，添加点
        points = findViewById(R.id.points);
        inserPoint();
        viewpager.setCurrentItem(images.size()*100,false);  //设置起点为第100
        //出发，到达地点
        et_from_city = findViewById(R.id.et_from_city);
        et_to_city = findViewById(R.id.et_to_city);
        //时间
        et_date = findViewById(R.id.et_date);
        et_date.setOnClickListener(this);
        //儿童婴儿单选框
        RadioGroup radioGroup = findViewById(R.id.k3);
        //搜索按钮
        btn_jipiao = findViewById(R.id.btn_jipiao);
        btn_jipiao.setOnClickListener(this);
    }

    private void inserPoint() {
        for (int i = 0; i < images.size(); i++) {
            View pointView = new View(this);//新建一个视图
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(40, 40);//设置宽和高
            layoutParams.leftMargin = 10;//左边间隔
            pointView.setBackground(getDrawable(R.drawable.shape_point_no));//设置背景样式
            pointView.setLayoutParams(layoutParams);//传入宽高
            points.addView(pointView);//添加到视图
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //图片位置
        int realPositon = position % adapter.getRealSize();
        //循环小点
        for (int i = 0; i < points.getChildCount(); i++) {
            //拿到当前小点
            View pointsChildAt = points.getChildAt(i);
            if (i != realPositon){
                //点的位置不等于图片位置  点就是白色
                pointsChildAt.setBackgroundResource(R.drawable.shape_point_no);
            }else{//等于就是红色
                pointsChildAt.setBackgroundResource(R.drawable.shape_point_yes);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.et_date:
                DatePickerDialog dialog = new DatePickerDialog(
                        this,android.R.style.Theme_Holo_Light_Dialog,
                        this,2022,1,1);
                //显示日期对话框
                dialog.show();
                return;
            case R.id.btn_jipiao:
                String et_from_cityText = et_from_city.getText().toString();
                String et_to_cityText = et_to_city.getText().toString();
                String et_dateText = et_date.getText().toString();
                if (TextUtils.isEmpty(et_from_cityText) || TextUtils.isEmpty(et_to_cityText) || TextUtils.isEmpty(et_dateText)){
                    Toast.makeText(this,"请补充完整信息",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(this,MainActivity4.class));
                }

                return;

        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        et_date.setText(i+"年"+i1+"月"+i2+"日");
    }

}