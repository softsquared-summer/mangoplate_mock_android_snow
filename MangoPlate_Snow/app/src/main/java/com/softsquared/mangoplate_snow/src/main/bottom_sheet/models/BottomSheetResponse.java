package com.softsquared.mangoplate_snow.src.main.bottom_sheet.models;

import com.google.gson.annotations.SerializedName;

public class BottomSheetResponse {
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
