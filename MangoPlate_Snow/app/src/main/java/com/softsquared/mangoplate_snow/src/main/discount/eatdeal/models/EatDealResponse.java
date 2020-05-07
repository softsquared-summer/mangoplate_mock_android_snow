package com.softsquared.mangoplate_snow.src.main.discount.eatdeal.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.EatDeal;

import java.util.ArrayList;

public class EatDealResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<EatDeal> eatDealListResult;

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
    public boolean getIsSuccess(){
        return isSuccess;
    }
    public ArrayList<EatDeal> getEatDealListResult() {
        return eatDealListResult;
    }
}
