package com.softsquared.mangoplate_snow.src.main.restaurant_detail.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.RestaurantDetail;

public class RestaurantDetailResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private RestaurantDetail result;

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
    public boolean getIsSuccess(){
        return isSuccess;
    }

    public RestaurantDetail getResult() {
        return result;
    }
}
