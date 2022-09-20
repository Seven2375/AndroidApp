package com.example.day01_c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APIActivity extends AppCompatActivity {

    private String nb;
    private TextView api_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apiactivity);

        api_text = findViewById(R.id.api_text);

        OkHttpApi();

    }

    public void OkHttpApi() {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("username", "admin").add("pwd", "wsadjk").build();
        Request request = new Request.Builder().url("https://v1.hitokoto.cn/").post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Log.e("data","aaaaaa:"+data);
                Gson gson = new Gson();
                Userinfo userinfo = gson.fromJson(data, Userinfo.class);
                nb = userinfo.getHitokoto();
                Log.e("nb","bbbbbb1111:"+ nb);

                api_text.setText(""+nb);
                Log.e("nb","ccccc:"+ nb);
            }
        });
    }
}