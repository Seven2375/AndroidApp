package com.example.day01_c;

import java.util.Map;

public class Avo {

    /*public Avo() {
        super();
        this.status = status;
        this.info = info;
        this.url = url;
        this.data = data;
    }*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;
    private int status;
    private String info;
    private String url;
    private Map<String,String> data;

    public Avo(){
        super();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }



}
