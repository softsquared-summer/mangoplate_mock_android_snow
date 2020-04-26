package com.example.mangoplate_snow.src.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mangoplate_snow.R;
import com.example.mangoplate_snow.src.BaseActivity;
import com.example.mangoplate_snow.src.main.interfaces.MainActivityView;

public class MainActivity extends BaseActivity implements MainActivityView {
    private TextView mTvHelloWorld;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHelloWorld = findViewById(R.id.main_tv_hello_world);
    }

    private void tryGetTest(){
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        mTvHelloWorld.setText(text);
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? "네트워크 연결이 원활하지 않습니다." : message);
    }
    public void customOnClick(View view){
        switch (view.getId()){
            case R.id.main_btn_hello_world:
                tryGetTest();
                break;
            default:
                break;
        }
    }
}
