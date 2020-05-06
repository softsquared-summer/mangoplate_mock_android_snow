package com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces;

import com.softsquared.mangoplate_snow.src.main.find_restaurant.models.FindRestaurantListParams;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.models.FindRestaurantListResponse;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
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

    //    @GET("/restaurants/{type}/{lat}/{lng}/{area}/{category}/{kind}")
//    Call<FindRestaurantListResponse> getRestaurantList(
//            @Path("type") String type,
//            @Path("lat") String lat,
//            @Path("lng") String lng,
//            @Path("area") String area,
//            @Path("category") String category,
//            @Path("kind") String kind
//
//    );
//    @GET("/restaurants")
//    Call<FindRestaurantListResponse> getRestaurantList(
//            @Query("type") String type,
//            @Query("lat") String lat,
//            @Query("lng") String lng,
//            @Query("area") String area,
//            @Query("category") String category,
//            @Query("kind") String kind
//
//    );
    @GET("/restaurants")
    Call<FindRestaurantListResponse> getRestaurantList(
            @Header("x-access-token") String x_access_token,
            @Query("type") String type,
            @Query("area") String area,
            @Query("lat") float lat,
            @Query("lng") float lng

    );

}
