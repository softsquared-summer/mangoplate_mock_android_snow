package com.softsquared.mangoplate_snow.src.main.discount.toplist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;
import java.util.ArrayList;

public class TopListRecyclerAdapter extends RecyclerView.Adapter<TopListRecyclerAdapter.TLItemViewHolder> {
    private ArrayList<TopList> TLlistData = new ArrayList<>();

    public TopListRecyclerAdapter(ArrayList<TopList> TLlistData) {
        this.TLlistData = TLlistData;
    }

    class TLItemViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivFrameFoodImg;
        private TextView mTLTvSeeCounter, mTLTvDayAgo, mTLTvIntroduce, mTLTvDetail;
        private ImageView mTopOfTop;

        public TLItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mTLTvSeeCounter = itemView.findViewById(R.id.item_top_list_tv_see_counter);
            mTLTvDayAgo = itemView.findViewById(R.id.item_top_list_day_ago);
            mTLTvIntroduce = itemView.findViewById(R.id.item_top_list_tv_introduce);
            mTLTvDetail = itemView.findViewById(R.id.item_top_list_tv_detail);
            mTopOfTop = itemView.findViewById(R.id.item_top_list_iv_top_of_top);

            //가장 조회수가 많은 아이템이 가장 상단에 위치. 해당 아이템에만 이 이미지뷰 보이도록
//            int pos = getAdapterPosition();
//            if(pos != RecyclerView.NO_POSITION) {
//                if (pos == 0) {
//                    mTopOfTop.setVisibility(View.VISIBLE);
//                }
//            }

        }

        void onBind(TopList topList) {
            mTLTvSeeCounter.setText(topList.getTopListSeeCounter());
            mTLTvDayAgo.setText(topList.getTopListDayAgo());
            mTLTvIntroduce.setText(topList.getTopListIntroduce());
            mTLTvDetail.setText(topList.getTopListDetail());

        }
    }

    @NonNull
    @Override
    public TLItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_list, parent, false);
        return new TLItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TLItemViewHolder holder, int position) {
       holder.onBind(TLlistData.get(position));
    }

    @Override
    public int getItemCount() {
        return TLlistData.size();
    }
}
