package com.softsquared.mangoplate_snow.src.main.bottom_sheet.recent_location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class RecentLocationRecyclerAdapter extends RecyclerView.Adapter<RecentLocationRecyclerAdapter.RLItemViewHolder> {
    private ArrayList<RecentLocationDistrict> RLlistData = new ArrayList<>();

    public RecentLocationRecyclerAdapter(ArrayList<RecentLocationDistrict> RLlistData) {
        this.RLlistData = RLlistData;
    }

    class RLItemViewHolder extends RecyclerView.ViewHolder {
        private Button mDistrictBtn;

        public RLItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mDistrictBtn = itemView.findViewById(R.id.district_btn);
        }

        void onBind(RecentLocationDistrict recentLocationDistrict) {
            mDistrictBtn.setText(recentLocationDistrict.getDistrictName());
        }
    }

    @NonNull
    @Override
    public RLItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_district, parent, false);
        return new RLItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RLItemViewHolder holder, int position) {
        holder.onBind(RLlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return RLlistData.size();
    }
}
