package com.softsquared.mangoplate_snow.src.main.discount.eatdeal;

import com.google.gson.annotations.SerializedName;

public class EatDeal {
    @SerializedName("eatdealId")
    private int eatdealId;

    @SerializedName("areaId")
    private int areaId;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("status")
    private String status;

    @SerializedName("percent")
    private String percent;

    @SerializedName("originalPrice")
    private String originalPrice;

    @SerializedName("salePrice")
    private String salePrice;

    @SerializedName("title")
    private String title;

    @SerializedName("item")
    private String item;

    @SerializedName("description")
    private String description;

    @SerializedName("quantity")
    private String quantity;

    public int getEatdealId() {
        return eatdealId;
    }

    public int getAreaId() {
        return areaId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getPercent() {
        return percent;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public String getTitle() {
        return title;
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    //    private String discountPercent;
//    private String restaurantName;
//    private String discountMenu;
////    private URL imgUrl;
//
//    public EatDeal(String discountPercent, String restaurantName, String discountMenu) {
//        this.discountPercent = discountPercent;
//        this.restaurantName = restaurantName;
//        this.discountMenu = discountMenu;
//    }
//
//    public String getDiscountPercent() {
//        return discountPercent;
//    }
//
//    public void setDiscountPercent(String discountPercent) {
//        this.discountPercent = discountPercent;
//    }
//
//    public String getRestaurantName() {
//        return restaurantName;
//    }
//
//    public void setRestaurantName(String restaurantName) {
//        this.restaurantName = restaurantName;
//    }
//
//    public String getDiscountMenu() {
//        return discountMenu;
//    }
//
//    public void setDiscountMenu(String discountMenu) {
//        this.discountMenu = discountMenu;
//    }
}
