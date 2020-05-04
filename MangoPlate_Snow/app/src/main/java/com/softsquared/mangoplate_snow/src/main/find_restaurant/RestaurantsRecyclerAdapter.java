package com.softsquared.mangoplate_snow.src.main.find_restaurant;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class RestaurantsRecyclerAdapter extends RecyclerView.Adapter<RestaurantsRecyclerAdapter.RItemViewHolder> {
    private ArrayList<Restaurant> RlistData = new ArrayList<>();

    public RestaurantsRecyclerAdapter(ArrayList<Restaurant> listData) {
        this.RlistData = listData;
    }

    class RItemViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivRestaurantMainImg;
        private TextView tvRestaurantName, tvRestaurantDistrictAndDistance,
                tvSeeCounter, tvReviewCounter, tvRestaurantScore;
        private ImageView ivRestaurantImg;
        private ToggleButton togglebtnWannago;

        public RItemViewHolder(@NonNull View itemView) {
            super(itemView);

            //  ivRestaurantMainImg = itemView.findViewById(R.id.iv_restaurant_main_img);
            tvRestaurantName = itemView.findViewById(R.id.tv_restaurant_name);
            tvRestaurantDistrictAndDistance = itemView.findViewById(R.id.tv_restaurant_district_and_distance);
            tvSeeCounter = itemView.findViewById(R.id.tv_see_counter);
            tvReviewCounter = itemView.findViewById(R.id.tv_review_counter);
            tvRestaurantScore = itemView.findViewById(R.id.tv_restaurant_score);
            togglebtnWannago = itemView.findViewById(R.id.togglebtn_wanna_go);
            ivRestaurantImg = itemView.findViewById(R.id.iv_restaurant_main_img);

            final Context context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "아이템은 "+getAdapterPosition()+"번째", Toast.LENGTH_SHORT).show();
                }
            });
        }

        void onBind(Restaurant restaurant) {
//            ivRestaurantMainImg.setImageResource(aa);
            tvRestaurantName.setText(restaurant.getRestaurantName());
            tvRestaurantDistrictAndDistance.setText(restaurant.getDistrictAndDistance());
            tvSeeCounter.setText(restaurant.getSeeCounter());
            tvReviewCounter.setText(restaurant.getReviewCounter());
            tvRestaurantScore.setText(restaurant.getRestaurantScore());
            togglebtnWannago.setChecked(restaurant.isToggleWannago());
            ivRestaurantImg.setImageResource(restaurant.getImgUrl());
        }
    }

    @NonNull
    @Override
    public RItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new RItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RItemViewHolder holder, int position) {
        holder.onBind(RlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return RlistData.size();
    }
}
