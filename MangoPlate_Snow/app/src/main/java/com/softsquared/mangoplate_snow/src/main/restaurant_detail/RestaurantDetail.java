package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RestaurantDetail {
    @SerializedName("images")
    private ArrayList<RestaurantImg> images;

    @SerializedName("name")
    private String name;

    @SerializedName("lat")
    private float lat;

    @SerializedName("lng")
    private float lng;

    @SerializedName("seenNum")
    private String seenNum;

    @SerializedName("reviewNum")
    private String reviewNum;

    @SerializedName("starNum")
    private String starNum;

    @SerializedName("rating")
    private String rating;

    @SerializedName("ratingColor")
    private String ratingColor;

    @SerializedName("userStar")
    private String userStar;

    @SerializedName("address")
    private String address;

    @SerializedName("oldAddress")
    private String oldAddress;

    @SerializedName("phone")
    private String phone;

    @SerializedName("userName")
    private String userName;

    @SerializedName("userProfileUrl")
    private String userProfileUrl;

    @SerializedName("infoUpdate")
    private String infoUpdate;

    @SerializedName("infoTime")
    private String infoTime;

    @SerializedName("infoHoliday")
    private String infoHoliday;

    @SerializedName("infoDescription")
    private String infoDescription;

    @SerializedName("infoPrice")
    private String infoPrice;

    @SerializedName("infoKind")
    private String infoKind;

    @SerializedName("infoParking")
    private String infoParking;

    @SerializedName("infoSite")
    private String infoSite;

    @SerializedName("keywords")
    private ArrayList<RestaurantKeywords> keywords;

    @SerializedName("menu")
    private ArrayList<RestaurantMenu> menu;

    @SerializedName("menuUpdate")
    private String menuUpdate;

    public ArrayList<RestaurantImg> getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public String getSeenNum() {
        return seenNum;
    }

    public String getReviewNum() {
        return reviewNum;
    }

    public String getStarNum() {
        return starNum;
    }

    public String getRating() {
        return rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public String getUserStar() {
        return userStar;
    }

    public String getAddress() {
        return address;
    }

    public String getOldAddress() {
        return oldAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserProfileUrl() {
        return userProfileUrl;
    }

    public String getInfoUpdate() {
        return infoUpdate;
    }

    public String getInfoTime() {
        return infoTime;
    }

    public String getInfoHoliday() {
        return infoHoliday;
    }

    public String getInfoDescription() {
        return infoDescription;
    }

    public String getInfoPrice() {
        return infoPrice;
    }

    public String getInfoKind() {
        return infoKind;
    }

    public String getInfoParking() {
        return infoParking;
    }

    public String getInfoSite() {
        return infoSite;
    }

    public ArrayList<RestaurantKeywords> getKeywords() {
        return keywords;
    }

    public ArrayList<RestaurantMenu> getMenu() {
        return menu;
    }

    public String getMenuUpdate() {
        return menuUpdate;
    }
}
