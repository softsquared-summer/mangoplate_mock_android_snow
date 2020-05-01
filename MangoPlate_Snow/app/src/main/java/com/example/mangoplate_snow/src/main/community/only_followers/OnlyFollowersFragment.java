package com.example.mangoplate_snow.src.main.community.only_followers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.main.community.only_followers.interfaces.OnlyFollowersFragmentView;
import com.example.mangoplate_snow.src.main.discount.toplist.TopList;
import com.example.mangoplate_snow.src.main.discount.toplist.TopListRecyclerAdapter;
import com.example.mangoplate_snow.src.main.discount.toplist.TopListRecyclerViewDecoration;

import java.util.ArrayList;

public class OnlyFollowersFragment extends BaseFragment implements OnlyFollowersFragmentView {
    private OnlyFollowersRecyclerAdapter mOnlyFollowersRecyclerAdapter;
    private RecyclerView mOnlyFollowersRecyclerView;
    private Context mContext;
    private ArrayList<OnlyFollowersReview> mOnlyFollowersReviews = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_community_only_followers, container, false);

        mOnlyFollowersRecyclerView = rootView.findViewById(R.id.only_followers_recycler_review_list);
        mOnlyFollowersRecyclerAdapter = new OnlyFollowersRecyclerAdapter(mOnlyFollowersReviews);

        mOnlyFollowersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mOnlyFollowersRecyclerView.setAdapter(mOnlyFollowersRecyclerAdapter);

        for(int i=0; i<20; i++){
            mOnlyFollowersReviews.add(new OnlyFollowersReview("혜오닝","100", "200", "@ 나향반점 - 논현동",
                    "우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아우와 리뷰입니다아ㅏ아아아아아",
                    "356", "12", "12 시간 전", true, false, R.drawable.ic_good_review));
        }
        mOnlyFollowersRecyclerAdapter.notifyDataSetChanged();

        OnlyFollowersRecyclerViewDecoration bottomSpace = new OnlyFollowersRecyclerViewDecoration(35);
        mOnlyFollowersRecyclerView.addItemDecoration(bottomSpace);

        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
