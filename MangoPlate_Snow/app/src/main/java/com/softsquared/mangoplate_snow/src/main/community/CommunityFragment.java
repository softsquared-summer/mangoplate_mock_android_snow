package com.softsquared.mangoplate_snow.src.main.community;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.main.community.holic.HolicFragment;
import com.softsquared.mangoplate_snow.src.main.community.interfaces.CommunityFragmentView;
import com.softsquared.mangoplate_snow.src.main.community.only_followers.OnlyFollowersFragment;
import com.softsquared.mangoplate_snow.src.main.community.whole.WholeFragment;
import com.google.android.material.tabs.TabLayout;

public class CommunityFragment extends BaseFragment implements CommunityFragmentView {
    private Context mContext;
    private TabLayout mTopTab;
    private CommunityViewPager mCommunityViewPager;
    private CommunityFragmentPagerAdapter mCommunityFragmentPagerAdapter;
    private WholeFragment mWholeFragment;
    private OnlyFollowersFragment mOnlyFollowersFragment;
    private HolicFragment mHolicFragment;


    public CommunityFragment() {
    }

    public CommunityFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_community, container, false);

        mTopTab = rootView.findViewById(R.id.community_top_tab);
        mCommunityViewPager = rootView.findViewById(R.id.community_view_pager);
        mTopTab.setupWithViewPager(mCommunityViewPager);

        initViewPager();

        return rootView;
    }
//
//    private void changeView(int index){
//        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
//
//        switch (index){
//            case 0:
//                WholeFragment wholeFragment = new WholeFragment();
//                fragmentTransaction.replace(R.id.community_frame, wholeFragment);
//                fragmentTransaction.commit();
//                break;
//            case 1:
//                OnlyFollowersFragment onlyFollowersFragment = new OnlyFollowersFragment();
//                fragmentTransaction.replace(R.id.community_frame, onlyFollowersFragment);
//                fragmentTransaction.commit();
//                break;
//        }
    private void initViewPager() {
        mWholeFragment = new WholeFragment(getContext());
        mOnlyFollowersFragment = new OnlyFollowersFragment(getContext());
        mHolicFragment = new HolicFragment(getContext());

        mCommunityFragmentPagerAdapter = new CommunityFragmentPagerAdapter(getChildFragmentManager());

        mCommunityFragmentPagerAdapter.addFragment(mWholeFragment, "전체");
        mCommunityFragmentPagerAdapter.addFragment(mOnlyFollowersFragment, "팔로잉");
        mCommunityFragmentPagerAdapter.addFragment(mHolicFragment, "홀릭");


        mCommunityViewPager.setAdapter(mCommunityFragmentPagerAdapter);
        mCommunityViewPager.setPagingEnabled(true);

        mCommunityViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
