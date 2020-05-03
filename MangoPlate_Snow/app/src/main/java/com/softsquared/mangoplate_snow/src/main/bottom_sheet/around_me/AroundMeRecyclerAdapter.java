package com.softsquared.mangoplate_snow.src.main.bottom_sheet.around_me;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;

import java.util.ArrayList;

public class AroundMeRecyclerAdapter extends RecyclerView.Adapter<AroundMeRecyclerAdapter.AMDItemViewHolder> {
    private ArrayList<AroundMeDistrict> AMDlistData = new ArrayList<>();
//    private OnItemClickListener mListener = null;

    public AroundMeRecyclerAdapter(ArrayList<AroundMeDistrict> AMDlistData) {
        this.AMDlistData = AMDlistData;
    }

    class AMDItemViewHolder extends RecyclerView.ViewHolder {
        private Button mDistrictBtn;

        public AMDItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mDistrictBtn = itemView.findViewById(R.id.district_btn);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position = getAdapterPosition();
//                    if(position != RecyclerView.NO_POSITION){
//                        mListener.onItemClick(view, position);
//                    }
//                }
//            });
        }

        void onBind(AroundMeDistrict aroundMeDistrict) {
            mDistrictBtn.setText(aroundMeDistrict.getDistrictName());
        }
    }
//    public interface OnItemClickListener{
//        void onItemClick(View v, int position);
//    }
//    public void setOnItemClickListener(OnItemClickListener listener){
//        this.mListener = listener;
//    }

    @NonNull
    @Override
    public AMDItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_district, parent, false);
        return new AMDItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AMDItemViewHolder holder, int position) {
        holder.onBind(AMDlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return AMDlistData.size();
    }
}
