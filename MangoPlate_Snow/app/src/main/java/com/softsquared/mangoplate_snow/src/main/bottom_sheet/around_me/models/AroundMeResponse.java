package com.softsquared.mangoplate_snow.src.main.bottom_sheet.around_me.models;

import com.google.gson.annotations.SerializedName;

public class AroundMeResponse {
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
