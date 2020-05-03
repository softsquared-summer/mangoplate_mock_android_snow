package com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class SeoulGangBookRecyclerAdapter extends RecyclerView.Adapter<SeoulGangBookRecyclerAdapter.SGBItemViewHolder> {
    private ArrayList<SeoulGangBookDistrict> SGBlistData = new ArrayList<>();

    public SeoulGangBookRecyclerAdapter(ArrayList<SeoulGangBookDistrict> SGBlistData) {
        this.SGBlistData = SGBlistData;
    }

    class SGBItemViewHolder extends RecyclerView.ViewHolder {
        private Button mDistrictBtn;

        public SGBItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mDistrictBtn = itemView.findViewById(R.id.district_btn);
        }

        void onBind(SeoulGangBookDistrict seoulGangBookDistrict) {
            mDistrictBtn.setText(seoulGangBookDistrict.getDistrictName());
        }
    }

    @NonNull
    @Override
    public SGBItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_district, parent, false);
        return new SGBItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SGBItemViewHolder holder, int position) {
        holder.onBind(SGBlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return SGBlistData.size();
    }
}
