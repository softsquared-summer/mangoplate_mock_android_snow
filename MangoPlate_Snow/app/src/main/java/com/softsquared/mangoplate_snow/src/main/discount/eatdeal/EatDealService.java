package com.softsquared.mangoplate_snow.src.main.discount.eatdeal;

import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.interfaces.EatDealFragmentView;
import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.interfaces.EatDealRetrofitInterface;
import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.models.EatDealResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.mangoplate_snow.src.ApplicationClass.getRetrofit;

public class EatDealService {
    private  final EatDealFragmentView mEatDealFragmentView;

    EatDealService(final EatDealFragmentView eatDealFragmentView) {
        this.mEatDealFragmentView = eatDealFragmentView;
    }

    public void tryGetEatDealList() {
        final EatDealRetrofitInterface eatDealRetrofitInterface = getRetrofit().create(EatDealRetrofitInterface.class);
        eatDealRetrofitInterface.getEatDeal().enqueue(new Callback<EatDealResponse>() {
            @Override
            public void onResponse(Call<EatDealResponse> call, Response<EatDealResponse> response) {
                final EatDealResponse eatDealResponse = response.body();
                if (eatDealResponse == null) {
                    mEatDealFragmentView.validateFailure(null);
                }else if(eatDealResponse.getCode() == 200){
                    mEatDealFragmentView.getEatDealListSuccess(eatDealResponse.getEatDealListResult());
                }else if(eatDealResponse.getCode() == 400) {
                    mEatDealFragmentView.getEatDealListFailure(eatDealResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<EatDealResponse> call, Throwable t) {
                mEatDealFragmentView.validateFailure(null);
            }
        });
    }
}
