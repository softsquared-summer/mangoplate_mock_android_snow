package com.example.mangoplate_snow.src.main.find_restaurant;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.mangoplate_snow.R;

public class SelectDistrictDialog extends DialogFragment implements View.OnClickListener {
//    private Fragment fragment;
//    private Button mSelectDistrictSubmit;

    public SelectDistrictDialog(){
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.custom_dialog_select_district, container, false);
//        Bundle args = getArguments();
//        String beforeSelected = args.getString("Selected");
//
//        mSelectDistrictSubmit = rootView.findViewById(R.id.select_district_submit);
//        mSelectDistrictSubmit.setOnClickListener((View.OnClickListener) getContext());
//
//        fragment = getActivity().getSupportFragmentManager().findFragmentByTag("tag");
        return rootView;
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.select_district_submit:
//                DialogFragment dialogFragment = (DialogFragment) fragment;
//                dialogFragment.dismiss();
//                break;
//        }
    }
}
