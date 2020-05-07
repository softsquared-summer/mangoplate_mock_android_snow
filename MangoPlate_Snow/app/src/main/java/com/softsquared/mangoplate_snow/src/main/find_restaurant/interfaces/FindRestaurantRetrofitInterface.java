package com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces;

import com.softsquared.mangoplate_snow.src.main.find_restaurant.models.FindRestaurantListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FindRestaurantRetrofitInterface {
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

    @GET("/restaurants")
    Call<FindRestaurantListResponse> getRestaurantList(
            @Query("type") String type,
            @Query("lat") float lat,
            @Query("lng") float lng,
            @Query("category") String category,
            @Query("kind") String kind
    );
}
//일단 한거 완료짓기 완벽하게, 맛집찾기 탭 지도, 가게 상세페이지
