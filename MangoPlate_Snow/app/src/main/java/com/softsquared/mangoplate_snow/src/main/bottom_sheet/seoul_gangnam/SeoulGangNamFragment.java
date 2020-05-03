package com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangnam;

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
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.seoul_gangnam.interfaces.SeoulGangNamView;

import java.util.ArrayList;

public class SeoulGangNamFragment extends BaseFragment implements SeoulGangNamView {

    private SeoulGangNamRecyclerAdapter mSeoulGangNamRecyclerAdapter;
    private RecyclerView mSeoulGangNamRecyclerView;
    private Context mContext;
    ArrayList<SeoulGangNamDistrict> seoulGangNamDistricts = new ArrayList<>();

    public SeoulGangNamFragment(){

    }
    public SeoulGangNamFragment(Context context){
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.recycler_view_bottom_sheet, container, false);

        mSeoulGangNamRecyclerView = rootView.findViewById(R.id.select_district_recycler_list);
        mSeoulGangNamRecyclerAdapter = new SeoulGangNamRecyclerAdapter(seoulGangNamDistricts);
        mSeoulGangNamRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mSeoulGangNamRecyclerView.setAdapter(mSeoulGangNamRecyclerAdapter);

        for(int i=0; i<3; i++){
            seoulGangNamDistricts.add(new SeoulGangNamDistrict("강남역"));
            seoulGangNamDistricts.add(new SeoulGangNamDistrict("가로수길"));
            seoulGangNamDistricts.add(new SeoulGangNamDistrict("관악구"));
        }
        mSeoulGangNamRecyclerAdapter.notifyDataSetChanged();
        SeoulGangNamRecyclerViewDecoration space = new SeoulGangNamRecyclerViewDecoration(20);
        mSeoulGangNamRecyclerView.addItemDecoration(space);

        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
