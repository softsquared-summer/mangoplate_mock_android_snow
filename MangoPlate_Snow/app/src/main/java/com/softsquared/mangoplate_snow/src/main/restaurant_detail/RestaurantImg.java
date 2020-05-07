package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import com.google.gson.annotations.SerializedName;

public class RestaurantImg {
    @SerializedName("imageId")
    private int imageId;

    @SerializedName("imageUrl")
    private String imageUrl;

    public int getImageId() {
        return imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
