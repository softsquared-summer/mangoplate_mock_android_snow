package com.softsquared.mangoplate_snow.src.main.find_restaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.login.LoginActivity;
import com.softsquared.mangoplate_snow.src.main.MainActivity;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces.FindRestaurantFragmentView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class FindRestaurantFragment extends BaseFragment implements FindRestaurantFragmentView{

    private RestaurantsRecyclerAdapter mRestaurantsRecyclerAdapter;
    private RecyclerView mRestaurantRecyclerView;
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    private Context mContext;
    private Button mFindRestaurantBtnDistrict, mFindRestaurantSort;
    private TopBannerViewPager mTopBannerViewPager;
    private TopBannerPagerAdapter mTopBannerPagerAdapter;
   // private TabLayout mBannerTab;


    private ImageButton test;

    private int currentBannerImg = 0;
    Timer timer;
    final long DELAY = 100;
    final long PERIOD = 8000;

    public FindRestaurantFragment() {
    }

    public FindRestaurantFragment(Context context){
        this.mContext = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_find_restaurant, container, false);


        mRestaurantRecyclerView = rootView.findViewById(R.id.frag_find_restaurant_recyclerview_restaurant_list);
        mFindRestaurantBtnDistrict = rootView.findViewById(R.id.frag_find_restaurant_btn_district);
        mFindRestaurantSort = rootView.findViewById(R.id.frag_find_restaurant_sort);

        mRestaurantsRecyclerAdapter = new RestaurantsRecyclerAdapter(restaurants);
        mRestaurantRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRestaurantRecyclerView.setAdapter(mRestaurantsRecyclerAdapter);

        mTopBannerViewPager = rootView.findViewById(R.id.frag_find_restaurant_top_banner);
        mTopBannerPagerAdapter = new TopBannerPagerAdapter(getContext());
        mTopBannerViewPager.setAdapter(mTopBannerPagerAdapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentBannerImg == mTopBannerViewPager.getChildCount()){
                    currentBannerImg = 0;
                }
                mTopBannerViewPager.setCurrentItem(currentBannerImg++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY, PERIOD);

            restaurants.add(new Restaurant("1. 잔치국수 전문점", "화성싱 - 300.6m",
                    "353", "532", "3.6", R.drawable.test1));
            restaurants.add(new Restaurant("2. 마라탕 전문점", "화성시 - 513.5m",
                    "232", "43", "3.4", R.drawable.test2));
            restaurants.add(new Restaurant("3. 닭도리탕 전문점", "화성시 - 1.35km",
                    "6767", "44", "4.2", R.drawable.test3));
            restaurants.add(new Restaurant("4. 모밀 전문점", "화성시 - 1.6km",
                    "123123", "1454", "3.8", R.drawable.test4));
            restaurants.add(new Restaurant("5. 삼계탕 전문점", "화성시 - 2.1km",
                    "2342", "232", "3.9", R.drawable.test5));
        restaurants.add(new Restaurant("6. 잔치국수 전문점", "화성싱 - 300.6m",
                "353", "532", "3.6", R.drawable.test1));
        restaurants.add(new Restaurant("7. 마라탕 전문점", "화성시 - 513.5m",
                "232", "43", "3.4", R.drawable.test2));
        restaurants.add(new Restaurant("8. 닭도리탕 전문점", "화성시 - 1.35km",
                "6767", "44", "4.2", R.drawable.test3));
        restaurants.add(new Restaurant("9. 모밀 전문점", "화성시 - 1.6km",
                "123123", "1454", "3.8", R.drawable.test4));
        restaurants.add(new Restaurant("10. 삼계탕 전문점", "화성시 - 2.1km",
                "2342", "232", "3.9", R.drawable.test5));
        restaurants.add(new Restaurant("11. 잔치국수 전문점", "화성싱 - 300.6m",
                "353", "532", "3.6", R.drawable.test1));
        restaurants.add(new Restaurant("12. 마라탕 전문점", "화성시 - 513.5m",
                "232", "43", "3.4", R.drawable.test2));
        restaurants.add(new Restaurant("13. 닭도리탕 전문점", "화성시 - 1.35km",
                "6767", "44", "4.2", R.drawable.test3));
        restaurants.add(new Restaurant("14. 모밀 전문점", "화성시 - 1.6km",
                "123123", "1454", "3.8", R.drawable.test4));
        restaurants.add(new Restaurant("15. 삼계탕 전문점", "화성시 - 2.1km",
                "2342", "232", "3.9", R.drawable.test5));
        restaurants.add(new Restaurant("16. 잔치국수 전문점", "화성싱 - 300.6m",
                "353", "532", "3.6", R.drawable.test1));
        restaurants.add(new Restaurant("17. 마라탕 전문점", "화성시 - 513.5m",
                "232", "43", "3.4", R.drawable.test2));
        restaurants.add(new Restaurant("18. 닭도리탕 전문점", "화성시 - 1.35km",
                "6767", "44", "4.2", R.drawable.test3));
        restaurants.add(new Restaurant("19. 모밀 전문점", "화성시 - 1.6km",
                "123123", "1454", "3.8", R.drawable.test4));
        restaurants.add(new Restaurant("20. 삼계탕 전문점", "화성시 - 2.1km",
                "2342", "232", "3.9", R.drawable.test5));

        mRestaurantsRecyclerAdapter.notifyDataSetChanged();
        FindRestaurantRecyclerViewDecoration space = new FindRestaurantRecyclerViewDecoration(20);
        mRestaurantRecyclerView.addItemDecoration(space);

        mFindRestaurantBtnDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).showD("showDistrict");
            }
        });
        mFindRestaurantSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).showD("showSort");
            }
        });


        test = rootView.findViewById(R.id.frag_find_restaurant_ib_map);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
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

}


//recyclerview 구현 & adapter 설정
//https://dev-imaec.tistory.com/27
