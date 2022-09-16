package com.example.day01_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_username,ed_pwd;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_username = findViewById(R.id.ed_login_username);
        ed_pwd = findViewById(R.id.ed_login_pwd);

        preferences = getSharedPreferences(ed_username.getText().toString(), MODE_PRIVATE);

        findViewById(R.id.btn_login_zhuce).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(this,MainActivity2.class));

    }
}