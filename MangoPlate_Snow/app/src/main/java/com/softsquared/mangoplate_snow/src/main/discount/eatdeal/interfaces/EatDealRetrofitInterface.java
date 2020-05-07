package com.softsquared.mangoplate_snow.src.main.discount.eatdeal.interfaces;

import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.models.EatDealResponse;
import com.softsquared.mangoplate_snow.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EatDealRetrofitInterface {
    @GET("/eatdeals")
    Call<EatDealResponse> getEatDeal();
}
