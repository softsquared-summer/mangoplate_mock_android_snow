package com.example.mangoplate_snow.src.main.find_restaurant;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.GpsInfo;
import com.example.mangoplate_snow.src.main.MainActivity;
import com.example.mangoplate_snow.src.main.find_restaurant.interfaces.FindRestaurantFragmentView;

import java.util.ArrayList;

public class FindRestaurantFragment extends BaseFragment implements FindRestaurantFragmentView{

    private RestaurantsRecyclerAdapter mRestaurantsRecyclerAdapter;
    private RecyclerView mRestaurantRecyclerView;
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    private Context mContext;
    private Button mFindRestaurantBtnDistrict;
    MainActivity mainActivity;
    private double latitude_f = 0;
    private double longitude_f = 0;

    public FindRestaurantFragment() {
    }

    public FindRestaurantFragment(Context context){
        this.mContext = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_find_restaurant, container, false);

        mRestaurantRecyclerView = rootView.findViewById(R.id.frag_find_restaurant_recyclerview_restaurant_list);
        mFindRestaurantBtnDistrict = rootView.findViewById(R.id.frag_find_restaurant_btn_district);
        mRestaurantsRecyclerAdapter = new RestaurantsRecyclerAdapter(restaurants);
        mRestaurantRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRestaurantRecyclerView.setAdapter(mRestaurantsRecyclerAdapter);

        for(int i=0; i<20; i++){
            restaurants.add(new Restaurant("이름입니다."+i, "강남구 - 0.1235135m",
                    "2533", "12", "2.6"));
        }
        mRestaurantsRecyclerAdapter.notifyDataSetChanged();

        FindRestaurantRecyclerViewDecoration space = new FindRestaurantRecyclerViewDecoration(20);
        mRestaurantRecyclerView.addItemDecoration(space);

        mFindRestaurantBtnDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("프", "위도 : "+latitude_f);
                Log.e("프", "경도 : "+longitude_f);
                Toast.makeText(getActivity(), "현재 위치\n" + "위도 : " + latitude_f + "\n경도 : " +longitude_f, Toast.LENGTH_LONG).show();
//                Log.e("click", "click");
//                Bundle args = new Bundle();
//                args.putString("key", "value");
//                SelectDistrictDialog selectDistrictDialog = new SelectDistrictDialog();
//                selectDistrictDialog.setArguments(args);
//                selectDistrictDialog.show(getActivity().getSupportFragmentManager(), "tag");
//                Log.e("show", "show");
            }
        });

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
    public void whereami(double lat, double lon){
        Log.e("fr", "위도 : "+lat);
        Log.e("fr", "경도 : "+lon);
    }

//    public void customOnClick(View view){
//        switch (view.getId()){
//            case R.id.frag_find_restaurant_btn_district:
//                Bundle args = new Bundle();
//                args.putString("key", "value");
//                SelectDistrictDialog selectDistrictDialog = new SelectDistrictDialog();
//                selectDistrictDialog.setArguments(args);
//                selectDistrictDialog.show(getActivity().getSupportFragmentManager(), "tag");
//                break;
//            default:
//                break;
//        }
//    }

//    @Override
//    public void onClick(View view) {
//        Log.e("click", "click");
//        switch(view.getId()){
//            case R.id.frag_find_restaurant_btn_district:
//                Log.e("incase", "incase");
//                Bundle args = new Bundle();
//                args.putString("key", "value");
//                SelectDistrictDialog selectDistrictDialog = new SelectDistrictDialog();
//                selectDistrictDialog.setArguments(args);
//                selectDistrictDialog.show(getActivity().getSupportFragmentManager(), "tag");
//                Log.e("show", "show");
//                break;
//            default:
//                break;
//        }
//    }
}


//recyclerview 구현 & adapter 설정
//https://dev-imaec.tistory.com/27
