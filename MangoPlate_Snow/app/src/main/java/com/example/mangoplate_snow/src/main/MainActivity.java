package com.example.mangoplate_snow.src.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseActivity;
import com.example.mangoplate_snow.src.main.interfaces.MainActivityView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements MainActivityView {
    private RestaurantsRecyclerAdapter mRestaurantsRecyclerAdapter;
    private RecyclerView mRecyclerView;
    ArrayList<Restaurant> restaurants = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        for(int i=0; i<20; i++){
            restaurants.add(new Restaurant("이름입니다."+i, "강남구 - 0.1235135m",
                    "2533", "12", "2.6"));
        }
        mRestaurantsRecyclerAdapter.notifyDataSetChanged();

    }
    private void initialize(){
        mRecyclerView = findViewById(R.id.main_recyclerview_restaurant_list);

        mRestaurantsRecyclerAdapter = new RestaurantsRecyclerAdapter(restaurants);
        mRecyclerView.setAdapter(mRestaurantsRecyclerAdapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

//    private void tryGetTest(){
//        showProgressDialog();
//
//        final MainService mainService = new MainService(this);
//        mainService.getTest();
//    }

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
