package com.example.mangoplate_snow.src.main.community;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.main.community.interfaces.CommunityFragmentView;

public class CommunityFragment extends BaseFragment implements CommunityFragmentView {
    private Context mContext;

    public CommunityFragment() {
    }

    public CommunityFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_community, container, false);
        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
