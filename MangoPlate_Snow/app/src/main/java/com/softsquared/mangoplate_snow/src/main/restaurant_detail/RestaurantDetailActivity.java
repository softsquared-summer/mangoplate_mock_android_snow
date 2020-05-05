package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseActivity;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.interfaces.RestaurantDetailActivityView;

public class RestaurantDetailActivity extends BaseActivity implements RestaurantDetailActivityView, OnMapReadyCallback {

    private TextView mRestaurantDetailName, mRestaurantDetailSeeCounter, mRestaurantDetailWannagoCounter, mRestaurantDetailReviewCounter,
                   mRestaurantDetailScore;
    private LinearLayout mRestaurantDetailBtnWannago, mRestaurantDetailBtnVisited, mRestaurantDetailBtnWriteReview, mRestaurantDetailBtnMylist;
    private ImageView mRestaurantDetailWannagoIv;
    private GoogleMap mGoogleMap;

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

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.restaurant_detail_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        LatLng coordinate = null;
        MarkerOptions marker;

        if(mRestaurantDetailName.getText().equals("세야스시")) {
            coordinate = new LatLng(127.072371, 37.2028944);
        }
        marker = new MarkerOptions();
        marker.position(coordinate);
        marker.alpha(0.8f);
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mGoogleMap.addMarker(marker);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinate));
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(10));

//https://medium.com/@logishudson0218/%EC%A7%80%EB%8F%84-api-01-72510b25e4bd
    }
}
