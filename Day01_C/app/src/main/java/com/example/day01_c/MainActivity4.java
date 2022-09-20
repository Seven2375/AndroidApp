package com.example.day01_c;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Gson gson = new Gson();
        jiPiaoBean jiPiaoBean = gson.fromJson(json, jiPiaoBean.class);
        try {
            String code = jiPiaoBean.getDatas().getUserinfo().getData().get(1).getName();
            Log.e("mmmmmmmmmmmmm",""+code);
        }catch (Exception e){
            e.printStackTrace();
        }

    }














    private String json = "{\n" +
            "  \"code\": \"200\",\n" +
            "  \"datas\": {\n" +
            "    \"verifySuccess\": true,\n" +
            "    \"userInfo\": {\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"time\": \"2022/12/3\",\n" +
            "          \"name\": \"春秋航空\",\n" +
            "          \"starttime\": \"19:35\",\n" +
            "          \"endtime\": \"23:45\",\n" +
            "          \"number\": \"GX8916\",\n" +
            "          \"lowestprice\": \"1000\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"time\": \"2022/12/3\",\n" +
            "          \"name\": \"东方航空\",\n" +
            "          \"starttime\": \"19:35\",\n" +
            "          \"endtime\": \"23:45\",\n" +
            "          \"number\": \"GX8916\",\n" +
            "          \"lowestprice\": \"1000\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"time\": \"2022/12/3\",\n" +
            "          \"name\": \"厦门航空\",\n" +
            "          \"starttime\": \"19:35\",\n" +
            "          \"endtime\": \"23:45\",\n" +
            "          \"number\": \"GX8916\",\n" +
            "          \"lowestprice\": \"1000\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"time\": \"2022/12/3\",\n" +
            "          \"name\": \"山东航空\",\n" +
            "          \"starttime\": \"19:35\",\n" +
            "          \"endtime\": \"23:45\",\n" +
            "          \"number\": \"GX8916\",\n" +
            "          \"lowestprice\": \"1000\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"time\": \"2022/12/3\",\n" +
            "          \"name\": \"深圳航空\",\n" +
            "          \"starttime\": \"19:35\",\n" +
            "          \"endtime\": \"23:45\",\n" +
            "          \"number\": \"GX8916\",\n" +
            "          \"lowestprice\": \"1000\"\n" +
            "        },{\n" +
            "          \"time\": \"2022/12/3\",\n" +
            "          \"name\": \"四川航空\",\n" +
            "          \"starttime\": \"19:35\",\n" +
            "          \"endtime\": \"23:45\",\n" +
            "          \"number\": \"GX8916\",\n" +
            "          \"lowestprice\": \"1000\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"time\": \"2022/12/3\",\n" +
            "          \"name\": \"中国南方航空\",\n" +
            "          \"starttime\": \"19:35\",\n" +
            "          \"endtime\": \"23:45\",\n" +
            "          \"number\": \"GX8916\",\n" +
            "          \"lowestprice\": \"1000\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  }\n" +
            "}" ;
}

