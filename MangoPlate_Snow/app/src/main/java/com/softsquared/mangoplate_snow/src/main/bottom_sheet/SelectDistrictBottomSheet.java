package com.softsquared.mangoplate_snow.src.main.bottom_sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.around_me.AroundMeFragment;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.interfaces.BottomSheetView;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.recent_location.RecentLocationFragment;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangbook.SeoulGangBookFragment;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangnam.SeoulGangNamFragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class SelectDistrictBottomSheet extends BottomSheetDialogFragment implements BottomSheetView {
    private BottomSheetViewPager mBottomSheetViewPager;
    private RecentLocationFragment mRecentLocationFragment;
    private AroundMeFragment mAroundMeFragment;
    private SeoulGangNamFragment mSeoulGangNamFragment;
    private SeoulGangBookFragment mSeoulGangBookFragment;
    private Context mContext;
    private TabLayout mTopTab;

    public static  SelectDistrictBottomSheet getInstance(){
        return new SelectDistrictBottomSheet();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.bottom_sheet_select_district, container, false);

        mBottomSheetViewPager = rootView.findViewById(R.id.select_district_view_pager);
        mTopTab = rootView.findViewById(R.id.select_district_top_tab);
        mTopTab.setupWithViewPager(mBottomSheetViewPager);

        initViewPager();

        return rootView;
    }
    private void initViewPager() {
        mRecentLocationFragment = new RecentLocationFragment(mContext);
        mAroundMeFragment = new AroundMeFragment(mContext);
        mSeoulGangNamFragment = new SeoulGangNamFragment(mContext);
        mSeoulGangBookFragment = new SeoulGangBookFragment(mContext);

        BottomSheetFragmentPagerAdapter bottomSheetFragmentPagerAdapter = new BottomSheetFragmentPagerAdapter(getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        bottomSheetFragmentPagerAdapter.addFragment(mRecentLocationFragment, "최근지역");
        bottomSheetFragmentPagerAdapter.addFragment(mAroundMeFragment, "내 주변");
        bottomSheetFragmentPagerAdapter.addFragment(mSeoulGangNamFragment, "서울-강남");
        bottomSheetFragmentPagerAdapter.addFragment(mSeoulGangBookFragment, "서울-강북");

        mBottomSheetViewPager.setAdapter(bottomSheetFragmentPagerAdapter);
        mBottomSheetViewPager.setPagingEnabled(true);

        mBottomSheetViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    }

    @Override
    public void validateFailure(String message) {

    }
}
