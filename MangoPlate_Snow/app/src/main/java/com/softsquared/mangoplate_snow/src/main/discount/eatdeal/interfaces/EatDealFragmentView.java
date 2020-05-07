package com.softsquared.mangoplate_snow.src.main.discount.eatdeal.interfaces;

import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.EatDeal;

import java.util.ArrayList;

public interface EatDealFragmentView {
    void validateSuccess(String text);
    void validateFailure(String message);
    void getEatDealListSuccess(ArrayList<EatDeal> eatDealListResult);
    void getEatDealListFailure(String message);
}
