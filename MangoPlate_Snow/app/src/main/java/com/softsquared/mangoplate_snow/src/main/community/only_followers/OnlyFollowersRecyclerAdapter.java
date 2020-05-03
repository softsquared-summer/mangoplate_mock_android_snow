package com.softsquared.mangoplate_snow.src.main.community.only_followers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class OnlyFollowersRecyclerAdapter extends RecyclerView.Adapter<OnlyFollowersRecyclerAdapter.OFItemViewHolder> {
    private ArrayList<OnlyFollowersReview> OFlistData = new ArrayList<>();

    public OnlyFollowersRecyclerAdapter(ArrayList<OnlyFollowersReview> OFlistData) {
        this.OFlistData = OFlistData;
    }

    class OFItemViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivFrameFoodImg;
        private TextView mCommunityTvUserNickname, mCommunityTvReviewCounter, mCommunityTvFollowerCounter, mCommunityTvUserReview,
                mCommunityTvLikeCount, mCommunityTvCommentCount, mCommunityTvTimeAgo;
        private ToggleButton mCommunityToggleWannago, mCommunityToggleLike;
        private Button mCommunityBtnRestaurantNameAndLocation;
        private ImageView mCommunityIvOverallAssess;

        public OFItemViewHolder(@NonNull View itemView) {
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

        void onBind(OnlyFollowersReview onlyFollowersReview) {
            mCommunityTvUserNickname.setText(onlyFollowersReview.getUserNickname());
            mCommunityTvReviewCounter.setText(onlyFollowersReview.getReviewCount());
            mCommunityTvFollowerCounter.setText(onlyFollowersReview.getFollowerCount());
            mCommunityTvUserReview.setText(onlyFollowersReview.getUserReview());
            mCommunityTvLikeCount.setText(onlyFollowersReview.getLikeCount());
            mCommunityTvCommentCount.setText(onlyFollowersReview.getCommentCount());
            mCommunityTvTimeAgo.setText(onlyFollowersReview.getTimeAgo());

            mCommunityToggleWannago.setChecked(onlyFollowersReview.isWannagoChecked());
            mCommunityToggleLike.setChecked(onlyFollowersReview.isLikeChecked());

            mCommunityBtnRestaurantNameAndLocation.setText(onlyFollowersReview.getRestaurantNameAndLocation());

            mCommunityIvOverallAssess.setImageResource(onlyFollowersReview.getOverallAssess());

        }
    }

    @NonNull
    @Override
    public OFItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_community, parent, false);
        return new OFItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OFItemViewHolder holder, int position) {
        holder.onBind(OFlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return OFlistData.size();
    }
}
