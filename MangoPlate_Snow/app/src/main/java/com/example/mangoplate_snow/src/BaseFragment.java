package com.example.mangoplate_snow.src;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

@SuppressLint("Registered")
public class BaseFragment extends Fragment {
    public ProgressDialog mProgressDialog;

    public void showCustomToast(final String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
    public void showProgressDialog(){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("로딩중입니다.");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }
    public void hideProgressDialog(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}
