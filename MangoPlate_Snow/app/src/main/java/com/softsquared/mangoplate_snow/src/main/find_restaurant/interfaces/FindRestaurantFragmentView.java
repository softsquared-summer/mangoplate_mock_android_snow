package com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces;

import com.softsquared.mangoplate_snow.src.main.find_restaurant.Restaurant;

import java.util.ArrayList;

public interface FindRestaurantFragmentView {
    void validateSuccess(String text);
    void validateFailure(String message);
    void getRestaurantListSuccess(ArrayList<Restaurant> restaurantListResult);
    void getRestaurantListFailure(String message);
}
