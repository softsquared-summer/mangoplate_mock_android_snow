package com.example.mangoplate_snow.src.main.community.whole.models;

import com.google.gson.annotations.SerializedName;

public class WholeResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
    public boolean getIsSuccess(){
        return isSuccess;
    }
}
