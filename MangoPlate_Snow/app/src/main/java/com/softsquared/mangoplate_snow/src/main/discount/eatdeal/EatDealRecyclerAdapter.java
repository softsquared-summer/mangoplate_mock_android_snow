package com.softsquared.mangoplate_snow.src.main.discount.eatdeal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class EatDealRecyclerAdapter extends RecyclerView.Adapter<EatDealRecyclerAdapter.EDItemViewHolder> {
    private ArrayList<EatDeal> EDlistData = new ArrayList<>();

    public EatDealRecyclerAdapter(ArrayList<EatDeal> EDlistData) {
        this.EDlistData = EDlistData;
    }

    class EDItemViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivFrameFoodImg;
        private TextView mEDTvDiscountPercent, mEDTvRestaurantName, mEDTvDiscountedMenu;

        public EDItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mEDTvDiscountPercent = itemView.findViewById(R.id.eatdeal_tv_discount_percent);
            mEDTvRestaurantName = itemView.findViewById(R.id.eatdeal_tv_restaurant_name);
            mEDTvDiscountedMenu = itemView.findViewById(R.id.eatdeal_tv_discounted_menu);

        }

        void onBind(EatDeal eatDeal) {
            mEDTvDiscountPercent.setText(eatDeal.getDiscountPercent());
            mEDTvRestaurantName.setText(eatDeal.getRestaurantName());
            mEDTvDiscountedMenu.setText(eatDeal.getDiscountMenu());
//            ivRestaurantMainImg.setImageResource(aa);
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
        holder.onBind(EDlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return EDlistData.size();
    }
}
