package com.softsquared.mangoplate_snow.src;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

public class FacebookLoginCallback implements FacebookCallback<LoginResult> {
    @Override
    public void onSuccess(LoginResult loginResult) {
        Log.e("Callback :: ", "onSuccess");
        requestMe(loginResult.getAccessToken());
    }

    @Override
    public void onCancel() {
        Log.e("Callback :: ", "onCancel");
    }

    @Override
    public void onError(FacebookException error) {
        Log.e("Callback :: ", "onError : "+error.getMessage());
    }

    public void requestMe(AccessToken token){
        GraphRequest graphRequest = GraphRequest.newMeRequest(token, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.e("result", object.toString());
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, name, email, profilePic");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }
}
