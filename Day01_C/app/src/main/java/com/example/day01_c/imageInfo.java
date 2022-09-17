package com.example.day01_c;

import java.util.ArrayList;
import java.util.List;

public class imageInfo {

    public imageInfo(int image) {
        this.image = image;
    }

    public int image;

    private static int[] imageArray = {R.drawable.banner,R.drawable.banner2,R.drawable.banner3};

    public static List<imageInfo> getList(){
        List<imageInfo> list = new ArrayList<imageInfo>();
        for (int i = 0; i < imageArray.length; i++) {
            list.add(new imageInfo(imageArray[i]));
        }
        return list;
    }
}
