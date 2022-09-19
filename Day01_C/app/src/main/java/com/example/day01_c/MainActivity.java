package com.example.day01_c;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_username,ed_pwd;
    private CheckBox cb_savelogin;
    private String username,pwd;
    private SharedPreferences config;
    private String kk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config = getSharedPreferences("config", MODE_PRIVATE);

        ed_username = findViewById(R.id.ed_login_username);
        ed_pwd = findViewById(R.id.ed_login_pwd);
        cb_savelogin = findViewById(R.id.cb_login_savepwd);

        reload();   //查看之前是否记住密码

        findViewById(R.id.btn_login_zhuce).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);



        OkHttpClient okHttpClient = new OkHttpClient();
        //2.通过new FormBody()调用build方法,创建一个RequestBody,可以用add添加键值对
        RequestBody requestBody = new FormBody.Builder().add("username","admin").add("passwrod","123456").build();
        //3.创建Request对象，设置URL地址，将RequestBody作为post方法的参数传入
        //Request request = new Request.Builder().url("http://app.qianwang1688.com/MallApi/login/app_pwd_login").post(requestBody).build();
        Request request = new Request.Builder().url("https://w2code.com/api/register").post(requestBody).build();
        //4.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //5.请求加入调度,重写回调方法
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("data",response.body().string());
                //获取json数据 传入到body
                String body = response.body().string();
                //创建一个gson
                Gson gson = new Gson();
                //新建一个Avo的Bean函数
                Avo avoobj= gson.fromJson(body,Avo.class);

                kk = avoobj.getCode();

            }
        });

    }

    private void reload() {
        boolean ischecked = config.getBoolean("ischecked", false);
        if (ischecked){
            ed_username.setText(config.getString("username",""));
            ed_pwd.setText(config.getString("pwd",""));
            cb_savelogin.setChecked(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login_zhuce:
                startActivity(new Intent(this, MainActivity2.class));
                break;
            case R.id.btn_login:
                String u = ed_username.getText().toString();
                String p = ed_pwd.getText().toString();
                SharedPreferences preferences = getSharedPreferences("wsadjk", MODE_PRIVATE);
                username = preferences.getString("username", "");
                pwd = preferences.getString("pwd", "");
                if (TextUtils.equals(u, username) && TextUtils.equals(p, pwd)){
                    //判断是否要记住密码
                    if(cb_savelogin.isChecked()){
                        savePwd(); //执行保存密码方法
                    }else{
                        noSavePwd();
                    }
                    String hello = String.format("%s,欢迎登录", kk);
                    Toast.makeText(this,hello,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity3.class));
                }else{
                    ed_pwd.setText("");
                    Toast.makeText(this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private void noSavePwd() {
        SharedPreferences.Editor edit = config.edit();
        edit.putBoolean("ischecked",false);
        edit.commit();
    }

    private void savePwd() {

        SharedPreferences.Editor edit = config.edit();
        edit.putString("username",username);
        edit.putString("pwd",pwd);
        edit.putBoolean("ischecked",true);
        edit.commit();
    }
}