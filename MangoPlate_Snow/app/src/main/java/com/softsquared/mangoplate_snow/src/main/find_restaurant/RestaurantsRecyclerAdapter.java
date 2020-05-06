package com.softsquared.mangoplate_snow.src.main.find_restaurant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.main.restaurant_detail.RestaurantDetailActivity;

import java.net.URL;
import java.util.ArrayList;

import retrofit2.http.Url;

public class RestaurantsRecyclerAdapter extends RecyclerView.Adapter<RestaurantsRecyclerAdapter.RItemViewHolder> {
    private ArrayList<Restaurant> RlistData;
    private Context mContext;
    private int restaurantId;

    public RestaurantsRecyclerAdapter(Context context, ArrayList<Restaurant> listData) {
        this.RlistData = listData;
        this.mContext = context;
    }

    class RItemViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivRestaurantMainImg;
        private TextView tvRestaurantName, tvRestaurantDistance, tvRestaurantArea,
                tvSeeCounter, tvReviewCounter, tvRestaurantScore;
        private ImageView ivRestaurantImg;
        private ToggleButton togglebtnWannago;

        public RItemViewHolder(@NonNull View itemView) {
            super(itemView);

            //  ivRestaurantMainImg = itemView.findViewById(R.id.iv_restaurant_main_img);
            tvRestaurantName = itemView.findViewById(R.id.tv_restaurant_name);
            tvRestaurantArea = itemView.findViewById(R.id.tv_restaurant_area);
            tvRestaurantDistance = itemView.findViewById(R.id.tv_restaurant_distance);
            tvSeeCounter = itemView.findViewById(R.id.tv_see_counter);
            tvReviewCounter = itemView.findViewById(R.id.tv_review_counter);
            tvRestaurantScore = itemView.findViewById(R.id.tv_restaurant_score);
            togglebtnWannago = itemView.findViewById(R.id.togglebtn_wanna_go);
            ivRestaurantImg = itemView.findViewById(R.id.iv_restaurant_main_img);

            final Context context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, RestaurantDetailActivity.class);
                    intent.putExtra("restaurantId", restaurantId);
                    context.startActivity(intent);
                }
            });
        }

        void onBind(Restaurant restaurant) {
//            ivRestaurantMainImg.setImageResource(aa);

/*

            if(restaurant.getIsCheckedWannago().equals("YES")){
                togglebtnWannago.setChecked(true);
            }else if(restaurant.getIsCheckedWannago().equals("NO")){
                togglebtnWannago.setChecked(false);
            }
            Glide.with(itemView.getContext()).load(restaurant.getRestaurantImg()).into(ivRestaurantImg);
*/

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
        Restaurant restaurant = RlistData.get(position);
        holder.tvRestaurantName.setText(restaurant.getTitle());
        holder.tvRestaurantArea.setText(restaurant.getArea());
        holder.tvRestaurantDistance.setText(restaurant.getDistance());
        holder.tvSeeCounter.setText(restaurant.getSeenNum());
        holder.tvReviewCounter.setText("" + restaurant.getReviewNum());

        if(RlistData.get(position).getRating().equals("")){
            holder.tvRestaurantScore.setVisibility(View.GONE);
        }else {
            holder.tvRestaurantScore.setText(restaurant.getRating());
        }
        restaurantId = restaurant.getRestaurantId();
        Log.e("ddd", String.valueOf(restaurantId));

        if(RlistData.get(position).getRatingColor().equals("orange")){
            String orange = "#FF7101";
            holder.tvRestaurantScore.setTextColor(Color.parseColor(orange));
            holder.tvRestaurantScore.setVisibility(View.VISIBLE);
        }else if(RlistData.get(position).getRatingColor().equals("gray")){
            String gray = "#F0F0F0";
            holder.tvRestaurantScore.setTextColor(Color.parseColor(gray));
            holder.tvRestaurantScore.setVisibility(View.VISIBLE);
        }else if(RlistData.get(position).getRatingColor().equals("")){
            holder.tvRestaurantScore.setVisibility(View.INVISIBLE);
        }

        if(RlistData.get(position).getStar().equals("YES")){
            holder.togglebtnWannago.setChecked(true);
        }else if(RlistData.get(position).getStar().equals("NO")){
            holder.togglebtnWannago.setChecked(false);
        }

        if(RlistData.get(position).getImg().equals("")){
            Log.e("stop", "이미지가 null값");
        }else{
            Glide.with(mContext).load(restaurant.getImg()).into(holder.ivRestaurantImg);
        }

    }

    @Override
    public int getItemCount() {
        return RlistData.size();
    }

    public void setRlistData(ArrayList<Restaurant> rlistData) {
        RlistData = rlistData;
    }
}
