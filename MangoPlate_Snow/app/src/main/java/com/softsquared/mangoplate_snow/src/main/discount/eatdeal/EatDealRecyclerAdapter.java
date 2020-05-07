package com.softsquared.mangoplate_snow.src.main.discount.eatdeal;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class EatDealRecyclerAdapter extends RecyclerView.Adapter<EatDealRecyclerAdapter.EDItemViewHolder> {
    private ArrayList<EatDeal> EDlistData = new ArrayList<>();
    private Context mContext;

    public EatDealRecyclerAdapter(ArrayList<EatDeal> EDlistData, Context context) {
        this.EDlistData = EDlistData;
        this.mContext = context;
    }

    class EDItemViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivFrameFoodImg;
        private TextView mEDTvDiscountPercent, mEDTvRestaurantTitle, mEDTvDiscountedMenu, mEDTvDescription, mEDTvOriginalPrice, mEDTvDiscountedPrice,
                        mEDTvNotice, mEDTvQuantity;
        private ImageView mEDIvFoodImg;

        public EDItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mEDTvDiscountPercent = itemView.findViewById(R.id.eatdeal_tv_discount_percent);
            mEDTvRestaurantTitle = itemView.findViewById(R.id.eatdeal_tv_restaurant_title);
            mEDTvDiscountedMenu = itemView.findViewById(R.id.eatdeal_tv_discounted_menu);
            mEDTvDescription = itemView.findViewById(R.id.restaurant_detail_tv_description);
            mEDTvOriginalPrice = itemView.findViewById(R.id.eatdeal_iv_original_price);
            mEDTvDiscountedPrice = itemView.findViewById(R.id.eatdeal_iv_discounted_price);
            mEDTvNotice = itemView.findViewById(R.id.eatdeal_tv_notice);
            mEDTvQuantity =itemView.findViewById(R.id.eatdeal_tv_quantity);
            mEDIvFoodImg = itemView.findViewById(R.id.eatdeal_iv_food_img);

        }

        void onBind(EatDeal eatDeal) {
//            mEDTvDiscountPercent.setText(eatDeal.getDiscountPercent());
//            mEDTvRestaurantName.setText(eatDeal.getRestaurantName());
//            mEDTvDiscountedMenu.setText(eatDeal.getDiscountMenu());
////            ivRestaurantMainImg.setImageResource(aa);
        }
    }

    @NonNull
    @Override
    public EDItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_eatdeal, parent, false);
        return new EDItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EDItemViewHolder holder, int position) {
        EatDeal eatDeal = EDlistData.get(position);
        holder.mEDTvRestaurantTitle.setText(eatDeal.getTitle());
        holder.mEDTvDiscountedMenu.setText(eatDeal.getItem());
        //Glide.with(mContext).load(eatDeal.getImageUrl()).into(holder.mEDIvFoodImg);
//        if(!eatDeal.getPercent().equals("")){
//            holder.mEDTvDiscountPercent.setVisibility(View.VISIBLE);
//            holder.mEDTvDiscountPercent.setText(eatDeal.getPercent());
//        }
        holder.mEDTvOriginalPrice.setText(eatDeal.getOriginalPrice());
        holder.mEDTvOriginalPrice.setPaintFlags(holder.mEDTvOriginalPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        holder.mEDTvDiscountedPrice.setText(eatDeal.getSalePrice());
//        if(eatDeal.getDescription() == null){
//        }else{
//            holder.mEDTvDescription.setVisibility(View.VISIBLE);
//            holder.mEDTvDescription.setText(eatDeal.getDescription());
//        }
//
//        if(eatDeal.getQuantity() == null){
//            holder.mEDTvQuantity.setVisibility(View.GONE);
//        }else{
//            holder.mEDTvQuantity.setText(eatDeal.getQuantity());
//        }
    }

    @Override
    public int getItemCount() {
        return EDlistData.size();
    }
}
