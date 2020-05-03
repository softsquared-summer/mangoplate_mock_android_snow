package com.softsquared.mangoplate_snow.src.main.community.whole;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.main.community.whole.interfaces.WholeFragmentView;

import java.util.ArrayList;

public class WholeFragment extends BaseFragment implements WholeFragmentView {
    private WholeRecyclerAdapter mWholeRecyclerAdapter;
    private RecyclerView mWholeRecyclerView;
    private Context mContext;
    private ArrayList<WholeReview> mWholeReviews = new ArrayList<>();

    public WholeFragment() {
    }

    public WholeFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_community_whole, container, false);

        mWholeRecyclerView = rootView.findViewById(R.id.whole_recycler_review_list);
        mWholeRecyclerAdapter = new WholeRecyclerAdapter(mWholeReviews);

        mWholeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mWholeRecyclerView.setAdapter(mWholeRecyclerAdapter);

        for(int i=0; i<20; i++){
            mWholeReviews.add(new WholeReview("혜리밍","200", "300", "@ 장어의꿈 - 남양주시",
                    "이 집 맛있어요~~ 강추강추! 늘 여기만 와요~ 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 늘 여기만 와요~ 강추강추! 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 늘 여기만 와요~! 이 집 맛있어요~~ 강추강추! 이 집 맛있어요~~ 강추강추!",
                    "123", "55", "1 시간 전", false, true, R.drawable.ic_good_review));
        }
        mWholeRecyclerAdapter.notifyDataSetChanged();

        WholeRecyclerViewDecoration bottomSpace = new WholeRecyclerViewDecoration(35);
        mWholeRecyclerView.addItemDecoration(bottomSpace);

        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
