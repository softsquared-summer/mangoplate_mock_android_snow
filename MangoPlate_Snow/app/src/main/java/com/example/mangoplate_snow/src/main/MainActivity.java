package com.example.mangoplate_snow.src.main;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseActivity;
import com.example.mangoplate_snow.src.main.community.CommunityFragment;
import com.example.mangoplate_snow.src.main.discount.DiscountFragment;
import com.example.mangoplate_snow.src.main.find_restaurant.FindRestaurantFragment;
import com.example.mangoplate_snow.src.main.interfaces.MainActivityView;
import com.example.mangoplate_snow.src.main.my_page.MyPageFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends BaseActivity implements MainActivityView {
    private TabLayout mBottomTab;
    private MainViewPager mMainViewPager;
    private DiscountFragment mDiscountFragment;
    private FindRestaurantFragment mFindRestaurantFragment;
    private MyPageFragment mMyPageFragment;
    private CommunityFragment mCommunityFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainViewPager = findViewById(R.id.main_viewpager);
        mBottomTab = findViewById(R.id.main_bottom_tab_layout);
        mBottomTab.setupWithViewPager(mMainViewPager);

        initViewPager();


//        mBottomTab.addTab(mBottomTab.newTab().setText("맛집찾기"));

// 탭 직접 클릭 시 사용
//        mBottomTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) { }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) { }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) { }
//        });

    }

    private void initViewPager() {
        mFindRestaurantFragment = new FindRestaurantFragment(this);
        mDiscountFragment = new DiscountFragment(this);
        mCommunityFragment = new CommunityFragment(this);
        mMyPageFragment = new MyPageFragment(this);

        MainFragmentPagerAdapter mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mainFragmentPagerAdapter.addFragment(mFindRestaurantFragment, "레스토랑");
        mainFragmentPagerAdapter.addFragment(mDiscountFragment, "할인");
        mainFragmentPagerAdapter.addFragment(mCommunityFragment, "소식");
        mainFragmentPagerAdapter.addFragment(mMyPageFragment, "내정보");

        mMainViewPager.setAdapter(mainFragmentPagerAdapter);
        mMainViewPager.setPagingEnabled(true);

        mMainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
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
//            case R.id.main_btn_find_restaurant_tab:
//                mIbFindRestaurant.setImageResource(R.drawable.ic_find_restaurant_tab_selected);
//                mIbDiscount.setImageResource(R.drawable.ic_discount_tab);
//                mIbCommunity.setImageResource(R.drawable.ic_community_tab);
//                mIbMypage.setImageResource(R.drawable.ic_mypage_tab);
//                FragmentManager fragmentManagerR = getSupportFragmentManager();
//                FragmentTransaction fragmentTransactionR = fragmentManagerR.beginTransaction();
//                fragmentTransaction.replace(R.id.main_frame_fragment, new FindRestaurantFragment());
//                break;
//            case R.id.main_btn_discount_tab:
//                mIbFindRestaurant.setImageResource(R.drawable.ic_find_restaurant_tab);
//                mIbDiscount.setImageResource(R.drawable.ic_discount_tab_selected);
//                mIbCommunity.setImageResource(R.drawable.ic_community_tab);
//                mIbMypage.setImageResource(R.drawable.ic_mypage_tab);
//                FragmentManager fragmentManagerD = getSupportFragmentManager();
//                FragmentTransaction fragmentTransactionD = fragmentManagerD.beginTransaction();
//                fragmentTransaction.replace(R.id.main_frame_fragment, new EatDealFragment());
//                break;
//            case R.id.main_btn_community_tab:
//                mIbFindRestaurant.setImageResource(R.drawable.ic_find_restaurant_tab);
//                mIbDiscount.setImageResource(R.drawable.ic_discount_tab);
//                mIbCommunity.setImageResource(R.drawable.ic_community_tab_selected);
//                mIbMypage.setImageResource(R.drawable.ic_mypage_tab);
//                break;
//            case R.id.main_btn_mypage_tab:
//                mIbFindRestaurant.setImageResource(R.drawable.ic_find_restaurant_tab);
//                mIbDiscount.setImageResource(R.drawable.ic_discount_tab);
//                mIbCommunity.setImageResource(R.drawable.ic_community_tab);
//                mIbMypage.setImageResource(R.drawable.ic_mypage_tab_selected);
//                break;
//            case R.id.main_btn_add_tab:
//                break;
//            default:
//                break;
//        }
//    }
}

//recyclerview 구현 & adapter 설정
//https://dev-imaec.tistory.com/27
