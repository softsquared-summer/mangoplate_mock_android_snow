package com.softsquared.mangoplate_snow.src.main.bottom_sheet.recent_location;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.recent_location.interfaces.RecentLocationView;

import java.util.ArrayList;

public class RecentLocationFragment extends BaseFragment implements RecentLocationView {

    private RecentLocationRecyclerAdapter mRecentLocationRecyclerAdapter;
    private RecyclerView mRecentLocationRecyclerView;
    private Context mContext;
    ArrayList<RecentLocationDistrict> recentLocationDistricts = new ArrayList<>();

    public RecentLocationFragment(){

    }
    public RecentLocationFragment(Context context){
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.recycler_view_bottom_sheet, container, false);

        mRecentLocationRecyclerView = rootView.findViewById(R.id.select_district_recycler_list);
        mRecentLocationRecyclerAdapter = new RecentLocationRecyclerAdapter(recentLocationDistricts);
        mRecentLocationRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecentLocationRecyclerView.setAdapter(mRecentLocationRecyclerAdapter);

        for(int i=0; i<3; i++){
            recentLocationDistricts.add(new RecentLocationDistrict("남양주시"));
            recentLocationDistricts.add(new RecentLocationDistrict("제주시"));
            recentLocationDistricts.add(new RecentLocationDistrict("천안시"));
        }
        mRecentLocationRecyclerAdapter.notifyDataSetChanged();
        RecentLocationRecyclerViewDecoration space = new RecentLocationRecyclerViewDecoration(20);
        mRecentLocationRecyclerView.addItemDecoration(space);

        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
