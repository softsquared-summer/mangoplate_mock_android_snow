package com.softsquared.mangoplate_snow.src.main.find_restaurant.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.Restaurant;

import java.util.ArrayList;

public class FindRestaurantListResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<Restaurant> restaurantListResult;

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
    public boolean getIsSuccess(){
        return isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public ArrayList<Restaurant> getRestaurantListResult() {
        return restaurantListResult;
    }
}
