package com.example.mangoplate_snow.src.main.community.whole;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.main.discount.eatdeal.EatDeal;

import java.util.ArrayList;

public class WholeRecyclerAdapter extends RecyclerView.Adapter<WholeRecyclerAdapter.WItemViewHolder> {
    private ArrayList<WholeReview> WlistData = new ArrayList<>();

    public WholeRecyclerAdapter(ArrayList<WholeReview> WlistData) {
        this.WlistData = WlistData;
    }

    class WItemViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivFrameFoodImg;
        private TextView mCommunityTvUserNickname, mCommunityTvReviewCounter, mCommunityTvFollowerCounter, mCommunityTvUserReview,
                mCommunityTvLikeCount, mCommunityTvCommentCount, mCommunityTvTimeAgo;
        private ToggleButton mCommunityToggleWannago, mCommunityToggleLike;
        private Button mCommunityBtnRestaurantNameAndLocation;
        private ImageView mCommunityIvOverallAssess;

        public WItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mCommunityTvUserNickname = itemView.findViewById(R.id.community_tv_user_nickname);
            mCommunityTvReviewCounter = itemView.findViewById(R.id.community_tv_review_counter);
            mCommunityTvFollowerCounter = itemView.findViewById(R.id.community_tv_follower_counter);
            mCommunityTvUserReview = itemView.findViewById(R.id.community_tv_user_review);
            mCommunityTvLikeCount = itemView.findViewById(R.id.community_tv_like_count);
            mCommunityTvCommentCount = itemView.findViewById(R.id.community_tv_comment_count);
            mCommunityTvTimeAgo = itemView.findViewById(R.id.community_tv_time_ago);

            mCommunityToggleWannago = itemView.findViewById(R.id.community_toggle_wannago);
            mCommunityToggleLike = itemView.findViewById(R.id.community_toggle_like);

            mCommunityBtnRestaurantNameAndLocation = itemView.findViewById(R.id.community_btn_restaurant_name_and_location);

            mCommunityIvOverallAssess = itemView.findViewById(R.id.community_iv_overall_assess);

        }

        void onBind(WholeReview wholeReview) {
            mCommunityTvUserNickname.setText(wholeReview.getUserNickname());
            mCommunityTvReviewCounter.setText(wholeReview.getReviewCount());
            mCommunityTvFollowerCounter.setText(wholeReview.getFollowerCount());
            mCommunityTvUserReview.setText(wholeReview.getUserReview());
            mCommunityTvLikeCount.setText(wholeReview.getLikeCount());
            mCommunityTvCommentCount.setText(wholeReview.getCommentCount());
            mCommunityTvTimeAgo.setText(wholeReview.getTimeAgo());

            mCommunityToggleWannago.setChecked(wholeReview.isWannagoChecked());
            mCommunityToggleLike.setChecked(wholeReview.isLikeChecked());

            mCommunityBtnRestaurantNameAndLocation.setText(wholeReview.getRestaurantNameAndLocation());

            mCommunityIvOverallAssess.setImageResource(wholeReview.getOverallAssess());
        }
    }

    @NonNull
    @Override
    public WItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_community, parent, false);
        return new WItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WItemViewHolder holder, int position) {
        holder.onBind(WlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return WlistData.size();
    }
}
