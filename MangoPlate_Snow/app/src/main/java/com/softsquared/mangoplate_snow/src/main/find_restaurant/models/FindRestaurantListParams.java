package com.softsquared.mangoplate_snow.src.main.find_restaurant.models;

import com.google.gson.annotations.SerializedName;

public class FindRestaurantListParams {
    @SerializedName("type")
    private String type;

    @SerializedName("lat")
    private float lat;

    @SerializedName("lng")
    private float lng;

    @SerializedName("area")
    private String area;

    @SerializedName("category")
    private String category;

    @SerializedName("kind")
    private String kind;

    public FindRestaurantListParams(String type, float lat, float lng, String area, String category, String kind) {
        this.type = this.type;
        this.lat = this.lat;
        this.lng = this.lng;
        this.area = this.area;
        this.category = this.category;
        this.kind = this.kind;
    }

}
