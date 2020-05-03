package com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangbook;

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
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangbook.interfaces.SeoulGangBookView;

import java.util.ArrayList;

public class SeoulGangBookFragment extends BaseFragment implements SeoulGangBookView {

    private SeoulGangBookRecyclerAdapter mSeoulGangBookRecyclerAdapter;
    private RecyclerView mSeoulGangBookRecyclerView;
    private Context mContext;
    ArrayList<SeoulGangBookDistrict> seoulGangBookDistricts = new ArrayList<>();

    public SeoulGangBookFragment(){

    }
    public SeoulGangBookFragment(Context context){
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.recycler_view_bottom_sheet, container, false);

        mSeoulGangBookRecyclerView = rootView.findViewById(R.id.select_district_recycler_list);
        mSeoulGangBookRecyclerAdapter = new SeoulGangBookRecyclerAdapter(seoulGangBookDistricts);
        mSeoulGangBookRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mSeoulGangBookRecyclerView.setAdapter(mSeoulGangBookRecyclerAdapter);

        for(int i=0; i<3; i++){
            seoulGangBookDistricts.add(new SeoulGangBookDistrict("노원구"));
            seoulGangBookDistricts.add(new SeoulGangBookDistrict("동부이촌동"));
            seoulGangBookDistricts.add(new SeoulGangBookDistrict("건대/군자/광진"));
        }
        mSeoulGangBookRecyclerAdapter.notifyDataSetChanged();
        SeoulGangBookRecyclerViewDecoration space = new SeoulGangBookRecyclerViewDecoration(20);
        mSeoulGangBookRecyclerView.addItemDecoration(space);

        return rootView;
    }


    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
