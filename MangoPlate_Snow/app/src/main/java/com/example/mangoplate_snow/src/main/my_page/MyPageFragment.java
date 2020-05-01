package com.example.mangoplate_snow.src.main.my_page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseFragment;
import com.example.mangoplate_snow.src.main.my_page.interfaces.MyPageFragmentView;

import java.util.zip.Inflater;

public class MyPageFragment extends BaseFragment implements MyPageFragmentView {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_my_page, container, false);
        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
