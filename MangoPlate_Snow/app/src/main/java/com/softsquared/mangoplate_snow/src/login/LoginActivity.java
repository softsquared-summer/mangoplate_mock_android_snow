package com.softsquared.mangoplate_snow.src.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseActivity;
import com.softsquared.mangoplate_snow.src.FacebookLoginCallback;
import com.softsquared.mangoplate_snow.src.login.interfaces.LoginActivityView;

import java.util.Arrays;

public class LoginActivity extends BaseActivity implements LoginActivityView {
    private ImageButton mIbLoginFacebook;
    private LoginButton mBtnLoginFacebook;
    private FacebookLoginCallback mFacebookLoginCallback;
    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mIbLoginFacebook = findViewById(R.id.login_ib_facebook);
        mBtnLoginFacebook = findViewById(R.id.login_btn_facebook);
        mFacebookLoginCallback = new FacebookLoginCallback();
        mCallbackManager = CallbackManager.Factory.create();

        mBtnLoginFacebook.setReadPermissions(Arrays.asList("public_profile", "email"));
        mBtnLoginFacebook.registerCallback(mCallbackManager, mFacebookLoginCallback);

        mIbLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnLoginFacebook.performClick();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
