package com.softsquared.mangoplate_snow.src.main.discount;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.EatDealFragment;
import com.softsquared.mangoplate_snow.src.main.discount.interfaces.DiscountFragmentView;
import com.softsquared.mangoplate_snow.src.main.discount.mango_pick_story.MangoPickStoryFragment;
import com.softsquared.mangoplate_snow.src.main.discount.toplist.TopListFragment;
import com.google.android.material.tabs.TabLayout;

public class DiscountFragment extends BaseFragment implements DiscountFragmentView {

    private TabLayout mTopTab;
    private DiscountViewPager mDiscountViewPager;
    private DiscountFragmentPagerAdapter mDiscountFragmentPagerAdapter;
    private Context mContext;
    private EatDealFragment mEatDealFragment;
    private TopListFragment mTopListFragment;
    private MangoPickStoryFragment mMangoPickStoryFragment;

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
        mDiscountViewPager = rootView.findViewById(R.id.discount_view_pager);
        mTopTab.setupWithViewPager(mDiscountViewPager);

        initViewPager();

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
        Toast.makeText(mContext, "위도 : " +lat+"경도 : " + lon, Toast.LENGTH_SHORT).show();
    }
    private void initViewPager() {
        mEatDealFragment = new EatDealFragment(getContext());
        mMangoPickStoryFragment = new MangoPickStoryFragment(getContext());
        mTopListFragment = new TopListFragment(getContext());

        mDiscountFragmentPagerAdapter = new DiscountFragmentPagerAdapter(getChildFragmentManager());

        mDiscountFragmentPagerAdapter.addFragment(mEatDealFragment, "EAT딜");
        mDiscountFragmentPagerAdapter.addFragment(mMangoPickStoryFragment, "망고픽 스토리");
        mDiscountFragmentPagerAdapter.addFragment(mTopListFragment, "TOP 리스트");


        mDiscountViewPager.setAdapter(mDiscountFragmentPagerAdapter);
        mDiscountViewPager.setPagingEnabled(true);

        mDiscountViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
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
