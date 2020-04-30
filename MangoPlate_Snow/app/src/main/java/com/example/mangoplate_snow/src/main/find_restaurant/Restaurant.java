package com.example.mangoplate_snow.src.main.find_restaurant;

public class Restaurant {
    private String restaurantName;
    private String districtAndDistance;
    private String seeCounter;
    private String reviewCounter;
    //private URL restaurantImgUrl;
    private String restaurantScore;
    private boolean toggleWannago;

    public Restaurant(String restaurantName, String districtAndDistance, String seeCounter, String reviewCounter, String restaurantScore) {
        this.restaurantName = restaurantName;
        this.districtAndDistance = districtAndDistance;
        this.seeCounter = seeCounter;
        this.reviewCounter = reviewCounter;
       // this.restaurantImgUrl = restaurantImgUrl;
        this.restaurantScore = restaurantScore;
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

//    public URL getRestaurantImgUrl() {
//        return restaurantImgUrl;
//    }
//
//    public void setRestaurantImgUrl(URL restaurantImgUrl) {
//        this.restaurantImgUrl = restaurantImgUrl;
//    }

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
}
