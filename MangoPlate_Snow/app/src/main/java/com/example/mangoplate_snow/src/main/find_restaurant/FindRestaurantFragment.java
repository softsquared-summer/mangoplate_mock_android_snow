package com.example.mangoplate_snow.src.main.findRestaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.main.findRestaurant.interfaces.FindRestaurantFragmentView;

import java.util.ArrayList;

public class FindRestaurantFragment extends BaseFragment implements FindRestaurantFragmentView {

    private RestaurantsRecyclerAdapter mRestaurantsRecyclerAdapter;
    private RecyclerView mRecyclerView;
    ArrayList<Restaurant> restaurants = new ArrayList<>();

    public FindRestaurantFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.find_restaurant_fragment, container, false);

        mRecyclerView = rootView.findViewById(R.id.frag_find_restaurant_recyclerview_restaurant_list);
        mRestaurantsRecyclerAdapter = new RestaurantsRecyclerAdapter(restaurants);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mRestaurantsRecyclerAdapter);

        for(int i=0; i<20; i++){
            restaurants.add(new Restaurant("이름입니다."+i, "강남구 - 0.1235135m",
                    "2533", "12", "2.6"));
        }
        mRestaurantsRecyclerAdapter.notifyDataSetChanged();

        return rootView;
    }
    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? "네트워크 연결이 원활하지 않습니다." : message);
    }

//    public void customOnClick(View view){
//        switch (view.getId()){
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
//            default:
//                break;
//        }
//    }
}


//recyclerview 구현 & adapter 설정
//https://dev-imaec.tistory.com/27
