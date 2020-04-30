package com.example.mangoplate_snow.src.main.discount;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.main.MainFragmentPagerAdapter;
import com.example.mangoplate_snow.src.main.MainViewPager;
import com.example.mangoplate_snow.src.main.discount.eatdeal.EatDeal;
import com.example.mangoplate_snow.src.main.discount.eatdeal.EatDealFragment;
import com.example.mangoplate_snow.src.main.discount.interfaces.DiscountFragmentView;
import com.example.mangoplate_snow.src.main.discount.toplist.TopListFragment;
import com.example.mangoplate_snow.src.main.find_restaurant.FindRestaurantFragment;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class DiscountFragment extends BaseFragment implements DiscountFragmentView {

    private TabLayout mTopTab;
//    private DiscountViewPager mDiscountViewPager;
    private Context mContext;
    private EatDealFragment mEatDealFragment;
    private TopListFragment mTopListFragment;
    private FrameLayout mDiscountFrame;


    public DiscountFragment() {
    }

    public DiscountFragment(Context context){
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_discount, container, false);

        mTopTab = rootView.findViewById(R.id.discount_top_tab);
        mDiscountFrame  = rootView.findViewById(R.id.discount_frame);

        mTopTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //        mDiscountViewPager = rootView.findViewById(R.id.discount_viewpager);
//        mTopTab.setupWithViewPager(mDiscountViewPager);
//
//        mTopTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) { }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) { }
//        });
//        initViewPager();
        mTopTab.addTab(mTopTab.newTab().setText("EAT딜"));
        mTopTab.addTab(mTopTab.newTab().setText("TOP 리스트"));

        /*
        mDiscountPagerAdapter = new DiscountPagerAdapter(getChildFragmentManager(), mTopTab.getTabCount());
        mDiscountViewPager.setAdapter(mDiscountPagerAdapter);
        mDiscountViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTopTab));

        mTopTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {  //선택되지 않음->선택
                mDiscountViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {    //선택->선택되지 않음

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {    //선택 상태의 tab이 사용자로부터 다시 선택됨

            }
        });*/
        return rootView;
    }
    private void changeView(int index){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();

        switch (index){
            case 0:
                EatDealFragment eatDealFragment = new EatDealFragment();
                fragmentTransaction.replace(R.id.discount_frame, eatDealFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                TopListFragment topListFragment = new TopListFragment();
                fragmentTransaction.replace(R.id.discount_frame, topListFragment);
                fragmentTransaction.commit();
                break;
        }
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

//    private void initViewPager() {
//        mEatDealFragment = new EatDealFragment(getContext());
//        mTopListFragment = new TopListFragment(getContext());
//
//        DiscountFragmentPagerAdapter discountFragmentPagerAdapter = new DiscountFragmentPagerAdapter(getChildFragmentManager());
//
//        discountFragmentPagerAdapter.addFragment(mEatDealFragment, "EAT딜");
//        discountFragmentPagerAdapter.addFragment(mTopListFragment, "TOP 리스트");
//
//        mDiscountViewPager.setAdapter(discountFragmentPagerAdapter);
//        mDiscountViewPager.setPagingEnabled(true);
//
//        mDiscountViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position) {
//                    case 0:
//                        break;
//                    case 1:
//                        break;
//                }
//            }
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
//    }
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
