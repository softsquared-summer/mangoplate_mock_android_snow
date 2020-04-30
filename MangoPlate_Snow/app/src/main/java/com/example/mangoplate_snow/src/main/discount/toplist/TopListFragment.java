package com.example.mangoplate_snow.src.main.discount.toplist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.main.discount.toplist.interfaces.TopListFragmentView;

import java.util.ArrayList;

public class TopListFragment extends BaseFragment implements TopListFragmentView {
    private TopListRecyclerAdapter mTopListRecyclerAdapter;
    private RecyclerView mTopListRecyclerView;
    private Context mContext;
    ArrayList<TopList> topLists = new ArrayList<>();

    public TopListFragment() {
    }

    public TopListFragment(Context context){
        this.mContext = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_discount_toplist, container, false);

        mTopListRecyclerView = rootView.findViewById(R.id.toplist_recycler_list);
        mTopListRecyclerAdapter = new TopListRecyclerAdapter(topLists);

        mTopListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mTopListRecyclerView.setAdapter(mTopListRecyclerAdapter);

        for(int i=0; i<20; i++){
            topLists.add(new TopList("오래된 한식당 맛집 베스트 50곳","오래된 데에는 다 이유가 있지!", "352,142", "3 일 전"));
        }
        mTopListRecyclerAdapter.notifyDataSetChanged();

        TopListRecyclerViewDecoration bottomSpace = new TopListRecyclerViewDecoration(25);
        mTopListRecyclerView.addItemDecoration(bottomSpace);


        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
