package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseActivity;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.interfaces.RestaurantDetailActivityView;

public class RestaurantDetailActivity extends BaseActivity implements RestaurantDetailActivityView {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_restaurant_detail);


    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
