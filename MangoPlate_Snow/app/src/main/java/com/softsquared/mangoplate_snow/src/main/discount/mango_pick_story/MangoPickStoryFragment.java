package com.softsquared.mangoplate_snow.src.main.discount.mango_pick_story;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.main.discount.mango_pick_story.interfaces.MangoPickStoryFragmentView;

public class MangoPickStoryFragment extends BaseFragment implements MangoPickStoryFragmentView {
    private Context mContext;

    public MangoPickStoryFragment() {
    }

    public MangoPickStoryFragment(Context context){
        this.mContext = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_discount_mango_pick_story, container, false);

        return rootView;
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
