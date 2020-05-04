package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseActivity;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.interfaces.RestaurantDetailActivityView;

public class RestaurantDetailActivity extends BaseActivity implements RestaurantDetailActivityView {

    private TextView mRestaurantDetailName, mRestaurantDetailSeeCounter, mRestaurantDetailWannagoCounter, mRestaurantDetailReviewCounter,
                   mRestaurantDetailScore;
    private LinearLayout mRestaurantDetailBtnWannago, mRestaurantDetailBtnVisited, mRestaurantDetailBtnWriteReview, mRestaurantDetailBtnMylist;
    private ImageView mRestaurantDetailWannagoIv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        mRestaurantDetailName = findViewById(R.id.restaurant_detail_name);
        mRestaurantDetailSeeCounter = findViewById(R.id.restaurant_detail_see_counter);
        mRestaurantDetailWannagoCounter = findViewById(R.id.restaurant_detail_wannago_counter);
        mRestaurantDetailReviewCounter = findViewById(R.id.restaurant_detail_review_counter);
        mRestaurantDetailScore = findViewById(R.id.restaurant_detail_score);
        mRestaurantDetailBtnWannago = findViewById(R.id.restaurant_detail_btn_wannago);
        mRestaurantDetailBtnVisited = findViewById(R.id.restaurant_detail_btn_visited);
        mRestaurantDetailBtnWriteReview = findViewById(R.id.restaurant_detail_btn_write_review);
        mRestaurantDetailBtnMylist = findViewById(R.id.restaurant_detail_btn_mylist);
        mRestaurantDetailWannagoIv = findViewById(R.id.restaurant_detail_wannago_iv);

        Intent intent = getIntent();
        String rName = intent.getExtras().getString("restaurant_name");
        mRestaurantDetailName.setText(rName);
        String sCounter = intent.getExtras().getString("see_counter");
        mRestaurantDetailSeeCounter.setText(sCounter);
        String rCounter = intent.getExtras().getString("review_counter");
        mRestaurantDetailReviewCounter.setText(rCounter);
        String rScore = intent.getExtras().getString("restaurant_score");
        mRestaurantDetailScore.setText(rScore);
        Boolean isWannagoChecked = intent.getExtras().getBoolean("is_wannago");
        if(isWannagoChecked)
            mRestaurantDetailWannagoIv.setImageResource(R.drawable.ic_wanna_go_orange_selected);


    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
