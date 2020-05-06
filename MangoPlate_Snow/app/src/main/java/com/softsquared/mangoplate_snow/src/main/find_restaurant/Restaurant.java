package com.softsquared.mangoplate_snow.src.main.find_restaurant;

public class Restaurant {
//    private int areaId;
//    private String area;
//    private int restaurantId;
//    private String restaurantImg;
//    private String isCheckedWannago;
//    private String restaurantTitle;
//    private String distance;
//    private String seeCounter;
//    private int reviewCounter;
//    private float restaurantScore;
//    private String scoreColor;
//
//
//    public Restaurant(String area, String restaurantImg, String isCheckedWannago, String restaurantTitle, String distance, String seeCounter, int reviewCounter, float restaurantScore, String scoreColor) {
//        this.area = area;
//        this.restaurantImg = restaurantImg;
//        this.isCheckedWannago = isCheckedWannago;
//        this.restaurantTitle = restaurantTitle;
//        this.distance = distance;
//        this.seeCounter = seeCounter;
//        this.reviewCounter = reviewCounter;
//        this.restaurantScore = restaurantScore;
//        this.scoreColor = scoreColor;
//    }
    private int areaId;
    private String area;
    private int restaurantId;
    private String restaurantImg;
    private String isCheckedWannago;
    private String restaurantTitle;
    private String distance;
    private String seeCounter;
    private int reviewCounter;
    private float restaurantScore;
    private String scoreColor;


    public Restaurant(String area, String restaurantImg, String isCheckedWannago, String restaurantTitle, String distance, String seeCounter, int reviewCounter, double restaurantScore, String scoreColor) {
        this.area = area;
        this.restaurantImg = restaurantImg;
        this.isCheckedWannago = isCheckedWannago;
        this.restaurantTitle = restaurantTitle;
        this.distance = distance;
        this.seeCounter = seeCounter;
        this.reviewCounter = reviewCounter;
        this.restaurantScore = (float) restaurantScore;
        this.scoreColor = scoreColor;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantImg() {
        return restaurantImg;
    }

    public void setRestaurantImg(String restaurantImg) {
        this.restaurantImg = restaurantImg;
    }

    public String getIsCheckedWannago() {
        return isCheckedWannago;
    }

    public void setIsCheckedWannago(String isCheckedWannago) {
        this.isCheckedWannago = isCheckedWannago;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public void setRestaurantTitle(String restaurantTitle) {
        this.restaurantTitle = restaurantTitle;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSeeCounter() {
        return seeCounter;
    }

    public void setSeeCounter(String seeCounter) {
        this.seeCounter = seeCounter;
    }

    public int getReviewCounter() {
        return reviewCounter;
    }

    public void setReviewCounter(int reviewCounter) {
        this.reviewCounter = reviewCounter;
    }

    public float getRestaurantScore() {
        return restaurantScore;
    }

    public void setRestaurantScore(float restaurantScore) {
        this.restaurantScore = restaurantScore;
    }

    public String getScoreColor() {
        return scoreColor;
    }

    public void setScoreColor(String scoreColor) {
        this.scoreColor = scoreColor;
    }
}
