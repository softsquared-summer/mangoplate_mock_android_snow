package com.softsquared.mangoplate_snow.src.main.find_restaurant;

import android.util.Log;
import android.widget.Toast;

import com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces.FindRestaurantFragmentView;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces.FindRestaurantRetrofitInterface;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.models.FindRestaurantListParams;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.models.FindRestaurantListResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.mangoplate_snow.src.ApplicationClass.BASE_URL;
import static com.softsquared.mangoplate_snow.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.softsquared.mangoplate_snow.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.mangoplate_snow.src.ApplicationClass.getRetrofit;

public class FindRestaurantService {
    private  final FindRestaurantFragmentView mFindRestaurantFragmentView;
    private RestaurantsRecyclerAdapter mRestaurantsRecyclerAdapter;

    FindRestaurantService(final FindRestaurantFragmentView findRestaurantFragmentView) {
        this.mFindRestaurantFragmentView = findRestaurantFragmentView;
    }

    public void tryGetRestaurantList() {
        final FindRestaurantRetrofitInterface findRestaurantRetrofitInterface = getRetrofit().create(FindRestaurantRetrofitInterface.class);
        findRestaurantRetrofitInterface.getRestaurantList(X_ACCESS_TOKEN, "main", "금천구, 구로구", (float) 37.477929, (float) 126.899720).enqueue(new Callback<FindRestaurantListResponse>() {
            @Override
            public void onResponse(Call<FindRestaurantListResponse> call, Response<FindRestaurantListResponse> response) {
                final FindRestaurantListResponse findRestaurantListResponse = response.body();
                if (findRestaurantListResponse == null) {
                    mFindRestaurantFragmentView.validateFailure(null);
                }else if(findRestaurantListResponse.getCode() == 200){
                    mFindRestaurantFragmentView.getRestaurantListSuccess(findRestaurantListResponse.getRestaurantListResult());
                }else if(findRestaurantListResponse.getCode() == 400) {
                    mFindRestaurantFragmentView.getRestaurantListFailure(findRestaurantListResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<FindRestaurantListResponse> call, Throwable t) {
                mFindRestaurantFragmentView.validateFailure(null);
            }
        });
    }
}
