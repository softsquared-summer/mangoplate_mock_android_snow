package com.softsquared.mangoplate_snow.src.main.restaurant_detail;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.softsquared.mangoplate_snow.src.main.find_restaurant.models.FindRestaurantListResponse;
import com.softsquared.mangoplate_snow.src.main.interfaces.MainActivityView;
import com.softsquared.mangoplate_snow.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.mangoplate_snow.src.main.models.DefaultResponse;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.interfaces.RestaurantDetailActivityView;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.interfaces.RestaurantDetailRetrofitInterface;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.models.RestaurantDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.mangoplate_snow.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.mangoplate_snow.src.ApplicationClass.getRetrofit;

class RestaurantDetailService {
    private  final RestaurantDetailActivityView mRestaurantDetailActivityView;
    RestaurantDetailActivity restaurantDetailActivity;
    private int restaurantId= 0;

    RestaurantDetailService(final RestaurantDetailActivityView restaurantDetailActivityView) {
        this.mRestaurantDetailActivityView = restaurantDetailActivityView;
    }

//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        if(intent == null){
//            return Service.START_STICKY;        //서비스가 종료될 경우 자동으로 다시 실행
//        }else{
//            restaurantId = intent.getExtras().getInt("restaurantId");
//        }
//
//        return super.onStartCommand(intent, flags, startId);
//    }

//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }

    void tryGetRestaurantDetailInfo(){
        final RestaurantDetailRetrofitInterface restaurantDetailRetrofitInterface = getRetrofit().create(RestaurantDetailRetrofitInterface.class);
        restaurantDetailRetrofitInterface.getRestaurantDetailInfo(X_ACCESS_TOKEN, 1).enqueue(new Callback<RestaurantDetailResponse>() {
            @Override
            public void onResponse(Call<RestaurantDetailResponse> call, Response<RestaurantDetailResponse> response) {
                final RestaurantDetailResponse restaurantDetailResponse = response.body();
                if (restaurantDetailResponse == null) {
                    mRestaurantDetailActivityView.validateFailure(null);
                }else if(restaurantDetailResponse.getCode() == 200){
                    mRestaurantDetailActivityView.getRestaurantDetailInfoSuccess(restaurantDetailResponse.getResult());
                }else if(restaurantDetailResponse.getCode() == 400) {
                    mRestaurantDetailActivityView.getRestaurantDetailInfoFailure(restaurantDetailResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RestaurantDetailResponse> call, Throwable t) {
                mRestaurantDetailActivityView.validateFailure(null);
            }
        });
    }

}
