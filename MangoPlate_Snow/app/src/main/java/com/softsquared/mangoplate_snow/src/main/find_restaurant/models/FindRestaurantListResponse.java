package com.softsquared.mangoplate_snow.src.main.find_restaurant.models;

import com.google.gson.annotations.SerializedName;

public class FindRestaurantListResponse {
    public class RestaurantListResult {

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
        private int reviewNum;

        @SerializedName("rating")
        private float rating;

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

        public int getReviewNum() {
            return reviewNum;
        }

        public float getRating() {
            return rating;
        }

        public String getRatingColor() {
            return ratingColor;
        }
    }
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private RestaurantListResult restaurantListResult;

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

    public RestaurantListResult getRestaurantListResult() {
        return restaurantListResult;
    }
}
