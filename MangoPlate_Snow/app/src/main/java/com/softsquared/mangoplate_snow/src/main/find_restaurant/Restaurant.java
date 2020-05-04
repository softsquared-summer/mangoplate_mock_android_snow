package com.softsquared.mangoplate_snow.src.main.find_restaurant;

public class Restaurant {
    private String restaurantName;
    private String districtAndDistance;
    private String seeCounter;
    private String reviewCounter;
    private String restaurantScore;
    private boolean toggleWannago;
    private int imgUrl;             //임시 이미지

    public Restaurant(String restaurantName, String districtAndDistance, String seeCounter, String reviewCounter, String restaurantScore, int imgUrl) {
        this.restaurantName = restaurantName;
        this.districtAndDistance = districtAndDistance;
        this.seeCounter = seeCounter;
        this.reviewCounter = reviewCounter;
        this.restaurantScore = restaurantScore;
        this.imgUrl = imgUrl;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDistrictAndDistance() {
        return districtAndDistance;
    }

    public void setDistrictAndDistance(String districtAndDistance) {
        this.districtAndDistance = districtAndDistance;
    }

    public String getSeeCounter() {
        return seeCounter;
    }

    public void setSeeCounter(String seeCounter) {
        this.seeCounter = seeCounter;
    }

    public String getReviewCounter() {
        return reviewCounter;
    }

    public void setReviewCounter(String reviewCounter) {
        this.reviewCounter = reviewCounter;
    }

    public String getRestaurantScore() {
        return restaurantScore;
    }

    public void setRestaurantScore(String restaurantScore) {
        this.restaurantScore = restaurantScore;
    }
    public boolean isToggleWannago() {
        return toggleWannago;
    }

    public void setToggleWannago(boolean toggleWannago) {
        this.toggleWannago = toggleWannago;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }
}
