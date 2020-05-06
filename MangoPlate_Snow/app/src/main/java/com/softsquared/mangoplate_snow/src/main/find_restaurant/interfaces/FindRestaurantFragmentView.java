package com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces;

import com.softsquared.mangoplate_snow.src.main.find_restaurant.models.FindRestaurantListResponse;

public interface FindRestaurantFragmentView {
    void validateSuccess(String text);
    void validateFailure(String message);
    //void getRestaurantListSuccess(FindRestaurantListResponse.RestaurantListResult restaurantListResult);
}
