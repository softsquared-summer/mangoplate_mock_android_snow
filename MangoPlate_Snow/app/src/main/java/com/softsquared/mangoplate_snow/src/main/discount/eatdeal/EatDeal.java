package com.softsquared.mangoplate_snow.src.main.discount.eatdeal;

public class EatDeal {
    private String discountPercent;
    private String restaurantName;
    private String discountMenu;
//    private URL imgUrl;

    public EatDeal(String discountPercent, String restaurantName, String discountMenu) {
        this.discountPercent = discountPercent;
        this.restaurantName = restaurantName;
        this.discountMenu = discountMenu;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDiscountMenu() {
        return discountMenu;
    }

    public void setDiscountMenu(String discountMenu) {
        this.discountMenu = discountMenu;
    }
}
