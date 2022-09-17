package com.example.day01_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences preferences;
    private String username,pwd;
    private EditText ed_username,ed_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed_username = findViewById(R.id.et_zhuce_username);
        ed_pwd = findViewById(R.id.et_zhuce_pwd);

        findViewById(R.id.btn_zhuce).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        username = ed_username.getText().toString();
        pwd = ed_pwd.getText().toString();
        preferences = getSharedPreferences(username, Context.MODE_PRIVATE);
        if (TextUtils.isEmpty(username)){
            Toast.makeText(this, "注册失败！账号不能为空", Toast.LENGTH_SHORT).show();
        }else {
            if (pwd.length() <8) {
                Toast.makeText(this, "注册失败！密码长度不能小于8", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor edit = preferences.edit();
                edit.putString("username",username);
                edit.putString("pwd",pwd);
                edit.commit();
                finish();
            }
        }

    }

}