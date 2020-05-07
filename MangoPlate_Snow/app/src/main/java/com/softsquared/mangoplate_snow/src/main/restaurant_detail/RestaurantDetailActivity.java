package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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
                   mRestaurantDetailScore, mRestaurantDetailAddress, mRestaurantDetailOldAddress,
                    mRestaurantDetailInfoUpdate, mRestaurantDetailInfoTime, mRestaurantDetailInfoHoliday, mRestaurantDetailInfoPrice, mRestaurantDetailTvDescription,
                    mRestaurantDetailMenuUpdate, mGapOnMenu;
    private LinearLayout mRestaurantDetailBtnWannago, mRestaurantDetailBtnVisited, mRestaurantDetailBtnWriteReview, mRestaurantDetailBtnMylist,
                    mRestaurantDetailLinearTime, mRestaurantDetailLinearHoliday, mRestaurantDetailLinearMenu, mRestaurantDetailLinearChips, mRestaurantDetailLinearKeywords;
    private RelativeLayout mRestaurantDetailScoreAndHelp, mRestaurantDetailRelativeDescription;
    private ToggleButton mRestaurantDetailToggleWannago;
    private GoogleMap mGoogleMap;
    public int restaurantId;
    private RestaurantDetailService restaurantDetailService;
    private float restaurantLat, restaurantLng =0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        restaurantDetailService = new RestaurantDetailService(this);

        mRestaurantDetailName = findViewById(R.id.restaurant_detail_name);
        mRestaurantDetailSeeCounter = findViewById(R.id.restaurant_detail_see_counter);
        mRestaurantDetailWannagoCounter = findViewById(R.id.restaurant_detail_wannago_counter);
        mRestaurantDetailReviewCounter = findViewById(R.id.restaurant_detail_review_counter);
        mRestaurantDetailScore = findViewById(R.id.restaurant_detail_score);
        mRestaurantDetailAddress = findViewById(R.id.restaurant_detail_address);
        mRestaurantDetailOldAddress = findViewById(R.id.restaurant_detail_old_address);
        mRestaurantDetailInfoUpdate = findViewById(R.id.restaurant_detail_info_update);
        mRestaurantDetailInfoTime = findViewById(R.id.restaurant_detail_time);
        mRestaurantDetailInfoHoliday = findViewById(R.id.restaurant_detail_holiday);
        mRestaurantDetailInfoPrice = findViewById(R.id.restaurant_detail_price);
        mRestaurantDetailTvDescription = findViewById(R.id.restaurant_detail_tv_description);
        mRestaurantDetailMenuUpdate = findViewById(R.id.restaurant_detail_menu_update);
        mGapOnMenu = findViewById(R.id.gap_on_menu);

        mRestaurantDetailBtnWannago = findViewById(R.id.restaurant_detail_btn_wannago);
        mRestaurantDetailBtnVisited = findViewById(R.id.restaurant_detail_btn_visited);
        mRestaurantDetailBtnWriteReview = findViewById(R.id.restaurant_detail_btn_write_review);
        mRestaurantDetailBtnMylist = findViewById(R.id.restaurant_detail_btn_mylist);
        mRestaurantDetailLinearTime = findViewById(R.id.restaurant_detail_linear_time);
        mRestaurantDetailLinearHoliday = findViewById(R.id.restaurant_detail_linear_holiday);
        mRestaurantDetailLinearMenu = findViewById(R.id.restaurant_detail_linear_menu);
        mRestaurantDetailLinearChips = findViewById(R.id.restaurant_detail_linear_chips);
        mRestaurantDetailLinearKeywords = findViewById(R.id.restaurant_detail_linear_keywords);

        mRestaurantDetailToggleWannago= findViewById(R.id.restaurant_detail_toggle_wannago);

        mRestaurantDetailScoreAndHelp = findViewById(R.id.restaurant_detail_score_and_help);
        mRestaurantDetailRelativeDescription = findViewById(R.id.restaurant_detail_relative_description);

        Intent intent = getIntent();
        restaurantId = intent.getExtras().getInt("restaurantId");
        Toast.makeText(this, ""+restaurantId, Toast.LENGTH_SHORT).show();

//        Intent intentToService = new Intent(this, RestaurantDetailService.class);
//        intentToService.putExtra("restaurantId", restaurantId);
//        startService(intentToService);
//
        tryGetRestaurantDetailInfo();

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.restaurant_detail_map);
//        mapFragment.getMapAsync(this);

        mRestaurantDetailBtnWannago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRestaurantDetailToggleWannago.isChecked()) {
                    mRestaurantDetailToggleWannago.setChecked(false);
                } else {
                    mRestaurantDetailToggleWannago.setChecked(true);
                }
            }
        });
    }

    private void tryGetRestaurantDetailInfo(){
        showProgressDialog();

        restaurantDetailService.tryGetRestaurantDetailInfo();
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void getRestaurantDetailInfoSuccess(RestaurantDetail restaurantDetail) {
        hideProgressDialog();
        //phone은 intent filter 사용할 때 필요 아직 안넣음
        mRestaurantDetailName.setText(restaurantDetail.getName());
        restaurantLat = restaurantDetail.getLat();
        restaurantLng = restaurantDetail.getLng();
        mRestaurantDetailSeeCounter.setText(restaurantDetail.getSeenNum());
        mRestaurantDetailReviewCounter.setText(restaurantDetail.getReviewNum());
        mRestaurantDetailAddress.setText(restaurantDetail.getAddress());
        mRestaurantDetailOldAddress.setText(restaurantDetail.getOldAddress());
        mRestaurantDetailInfoUpdate.setText(restaurantDetail.getInfoUpdate());
        mRestaurantDetailInfoPrice.setText(restaurantDetail.getInfoPrice());

        if(restaurantDetail.getRating().equals("")){
            mRestaurantDetailScoreAndHelp.setVisibility(View.GONE);
        }else{
            mRestaurantDetailScore.setText(restaurantDetail.getRating());
        }

        if(restaurantDetail.getRatingColor().equals("orange")){
            String orange = "#FF7101";
            mRestaurantDetailScore.setTextColor(Color.parseColor(orange));
        }else if(restaurantDetail.getRatingColor().equals("gray")){
            String gray = "#F0F0F0";
            mRestaurantDetailScore.setTextColor(Color.parseColor(gray));
        }else if(restaurantDetail.getRatingColor().equals("")){
            mRestaurantDetailScoreAndHelp.setVisibility(View.GONE);
        }

        if(restaurantDetail.getUserStar().equals("YES")){
            mRestaurantDetailToggleWannago.setChecked(true);
        }else if(restaurantDetail.getUserStar().equals("NO")){
            mRestaurantDetailToggleWannago.setChecked(false);
        }

        if(restaurantDetail.getInfoTime().equals("")){
            mRestaurantDetailLinearTime.setVisibility(View.GONE);
        }else{
            mRestaurantDetailInfoTime.setText(restaurantDetail.getInfoTime());
        }

        if(restaurantDetail.getInfoHoliday().equals("")){
            mRestaurantDetailLinearHoliday.setVisibility(View.GONE);
        }else{
            mRestaurantDetailInfoHoliday.setText(restaurantDetail.getInfoHoliday());
        }

        if(restaurantDetail.getInfoDescription().equals("")){
            mRestaurantDetailRelativeDescription.setVisibility(View.GONE);
        }else{
            mRestaurantDetailTvDescription.setText(restaurantDetail.getInfoDescription());
        }

        if(restaurantDetail.getMenuUpdate().equals("")){
            mRestaurantDetailLinearMenu.setVisibility(View.GONE);
            mGapOnMenu.setVisibility(View.GONE);
        }else{
            //메뉴가 있는 데이터가 거의 없기 때문에 따로 지정하지 않음
        }

        if(restaurantDetail.getKeywords().equals("")){
            mRestaurantDetailLinearKeywords.setVisibility(View.GONE);
        }else{
            LinearLayout.LayoutParams paramsForChips = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams paramsForLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout linearChip1 = new LinearLayout(this);
            linearChip1.setLayoutParams(paramsForLayout);
            LinearLayout linearChip2 = new LinearLayout(this);
            linearChip2.setLayoutParams(paramsForLayout);
            mRestaurantDetailLinearChips.addView(linearChip1);
            mRestaurantDetailLinearChips.addView(linearChip2);
            paramsForChips.setMarginStart(20);
            paramsForLayout.setMargins(0,0,0,40);
            for(int i=0; i<restaurantDetail.getKeywords().size(); i++){
                TextView chip = new TextView(this);
                chip.setText(restaurantDetail.getKeywords().get(i).getKeyword());
                chip.setTextSize(13);
                chip.setBackground(getDrawable(R.drawable.button_round_border_black));
                chip.setPadding(40,20,40,20);
                if((i!=0) || (i!=2)) {
                    chip.setLayoutParams(paramsForChips);
                }
                if(i>1){
                    linearChip2.addView(chip);
                }else {
                    linearChip1.addView(chip);
                }
            }
        }

    }

    @Override
    public void getRestaurantDetailInfoFailure(String message) {

    }

    public int getRestaurantId() {
        return restaurantId;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mGoogleMap = googleMap;
//        LatLng coordinate = null;
//        MarkerOptions marker;

//        if(mRestaurantDetailName.getText().equals("세야스시")) {
//            coordinate = new LatLng(127.072371, 37.2028944);
//        }
//        marker = new MarkerOptions();
//        marker.position(coordinate);
//        marker.alpha(0.8f);
//        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
//        mGoogleMap.addMarker(marker);
//        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinate));
//        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(10));

//https://medium.com/@logishudson0218/%EC%A7%80%EB%8F%84-api-01-72510b25e4bd
    }
}
