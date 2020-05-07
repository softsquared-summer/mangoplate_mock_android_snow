package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import com.google.gson.annotations.SerializedName;

public class RestaurantMenu {
    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
