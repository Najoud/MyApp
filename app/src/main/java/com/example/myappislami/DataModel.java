package com.example.myappislami;

import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("Name")
    private String name;
    @SerializedName("URL")
    private String url;



    public DataModel(String name,String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


