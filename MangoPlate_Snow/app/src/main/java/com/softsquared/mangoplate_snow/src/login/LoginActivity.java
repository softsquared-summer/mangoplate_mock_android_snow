package com.softsquared.mangoplate_snow.src.login;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.softsquared.mangoplate_snow.src.BaseActivity;
import com.softsquared.mangoplate_snow.src.login.interfaces.LoginActivityView;

public class LoginActivity extends BaseActivity implements LoginActivityView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
