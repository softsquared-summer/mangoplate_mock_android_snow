package com.softsquared.mangoplate_snow.src.main.find_restaurant;

import com.google.gson.annotations.SerializedName;

public class Restaurant {
    @SerializedName("areaId")
    private int areaId;

    @SerializedName("area")
    private String area;

    @SerializedName("restaurantId")
    private int restaurantId;

    @SerializedName("img")
    private String img;

    @SerializedName("star")
    private String star;

    @SerializedName("title")
    private String title;

    @SerializedName("distance")
    private String distance;

    @SerializedName("seenNum")
    private String seenNum;

    @SerializedName("reviewNum")
    private String reviewNum;

    @SerializedName("rating")
    private String rating;

    @SerializedName("ratingColor")
    private String ratingColor;

    public int getAreaId() {
        return areaId;
    }

    public String getArea() {
        return area;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getImg() {
        return img;
    }

    public String getStar() {
        return star;
    }

    public String getTitle() {
        return title;
    }

    public String getDistance() {
        return distance;
    }

    public String getSeenNum() {
        return seenNum;
    }

    public String getReviewNum() {
        return reviewNum;
    }

    public String getRating() {
        return rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }
}
