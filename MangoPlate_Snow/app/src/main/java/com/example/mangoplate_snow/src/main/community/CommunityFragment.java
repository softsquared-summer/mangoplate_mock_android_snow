package com.example.mangoplate_snow.src.main.community;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.main.community.interfaces.CommunityFragmentView;
import com.example.mangoplate_snow.src.main.community.only_followers.OnlyFollowersFragment;
import com.example.mangoplate_snow.src.main.community.whole.WholeFragment;
import com.example.mangoplate_snow.src.main.discount.eatdeal.EatDealFragment;
import com.example.mangoplate_snow.src.main.discount.toplist.TopListFragment;
import com.google.android.material.tabs.TabLayout;

public class CommunityFragment extends BaseFragment implements CommunityFragmentView {
    private Context mContext;
    private TabLayout mTopTab;
    private WholeFragment mWholeFragment;
    private OnlyFollowersFragment mOnlyFollowersFragment;
    private FrameLayout mCommunityFrame;

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
        mCommunityFrame = rootView.findViewById(R.id.community_frame);
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
        mTopTab.addTab(mTopTab.newTab().setText("전체"));
        mTopTab.addTab(mTopTab.newTab().setText("팔로잉"));

        return rootView;
    }

    private void changeView(int index){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();

        switch (index){
            case 0:
                WholeFragment wholeFragment = new WholeFragment();
                fragmentTransaction.replace(R.id.community_frame, wholeFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                OnlyFollowersFragment onlyFollowersFragment = new OnlyFollowersFragment();
                fragmentTransaction.replace(R.id.community_frame, onlyFollowersFragment);
                fragmentTransaction.commit();
                break;
        }
    }
    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
