package com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangnam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class SeoulGangNamRecyclerAdapter extends RecyclerView.Adapter<SeoulGangNamRecyclerAdapter.SGNItemViewHolder> {
    private ArrayList<SeoulGangNamDistrict> SGNlistData = new ArrayList<>();

    public SeoulGangNamRecyclerAdapter(ArrayList<SeoulGangNamDistrict> SGNlistData) {
        this.SGNlistData = SGNlistData;
    }

    class SGNItemViewHolder extends RecyclerView.ViewHolder {
        private Button mDistrictBtn;

        public SGNItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mDistrictBtn = itemView.findViewById(R.id.district_btn);
        }

        void onBind(SeoulGangNamDistrict seoulGangNamDistrict) {
            mDistrictBtn.setText(seoulGangNamDistrict.getDistrictName());
        }
    }

    @NonNull
    @Override
    public SGNItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_district, parent, false);
        return new SGNItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SGNItemViewHolder holder, int position) {
        holder.onBind(SGNlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return SGNlistData.size();
    }
}
