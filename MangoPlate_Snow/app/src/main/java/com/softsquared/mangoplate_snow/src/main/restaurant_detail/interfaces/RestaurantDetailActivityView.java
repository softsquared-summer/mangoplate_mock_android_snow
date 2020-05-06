package com.softsquared.mangoplate_snow.src.main.restaurant_detail.interfaces;

import com.softsquared.mangoplate_snow.src.main.restaurant_detail.RestaurantDetail;

public interface RestaurantDetailActivityView {
    void validateSuccess(String text);
    void validateFailure(String message);
    void getRestaurantDetailInfoSuccess(RestaurantDetail restaurantDetail);
    void getRestaurantDetailInfoFailure(String message);
}
