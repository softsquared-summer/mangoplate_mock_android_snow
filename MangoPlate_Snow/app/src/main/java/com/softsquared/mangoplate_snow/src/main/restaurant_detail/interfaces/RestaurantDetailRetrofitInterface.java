package com.softsquared.mangoplate_snow.src.main.restaurant_detail.interfaces;

import com.softsquared.mangoplate_snow.src.main.models.DefaultResponse;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.models.RestaurantDetailResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestaurantDetailRetrofitInterface {
//    @GET("/jwt")
//    Call<DefaultResponse> getTest();
//
//    @GET("/test/{number}")
//    Call<DefaultResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<DefaultResponse> postTest(@Body RequestBody params);

    @GET("/restaurants/{restaurantId}")
    Call<RestaurantDetailResponse> getRestaurantDetailInfo(
            @Header("x-access-token") String x_access_token,
            @Path("restaurantId") int restaurantId
    );

}
