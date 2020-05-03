package com.softsquared.mangoplate_snow.src.main.bottom_sheet.around_me;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.around_me.interfaces.AroundMeView;

import java.util.ArrayList;

public class AroundMeFragment extends BaseFragment implements AroundMeView {

    private AroundMeRecyclerAdapter mAroundMeRecyclerAdapter;
    private RecyclerView mAroundMeRecyclerView;
    private Context mContext;
    private Button mDistrictBtn;
    private int count =0;
    ArrayList<AroundMeDistrict> aroundMeDistricts = new ArrayList<>();

    public AroundMeFragment(){

    }
    public AroundMeFragment(Context context){
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.recycler_view_bottom_sheet, container, false);

        mAroundMeRecyclerView = rootView.findViewById(R.id.select_district_recycler_list);
        mAroundMeRecyclerAdapter = new AroundMeRecyclerAdapter(aroundMeDistricts);
        mAroundMeRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mAroundMeRecyclerView.setAdapter(mAroundMeRecyclerAdapter);

        for(int i=0; i<3; i++){
            aroundMeDistricts.add(new AroundMeDistrict("수원시"));
            aroundMeDistricts.add(new AroundMeDistrict("용인시"));
            aroundMeDistricts.add(new AroundMeDistrict("평택시"));
        }
        mAroundMeRecyclerAdapter.notifyDataSetChanged();
        AroundMeRecyclerViewDecoration space = new AroundMeRecyclerViewDecoration(25);
        mAroundMeRecyclerView.addItemDecoration(space);

        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
