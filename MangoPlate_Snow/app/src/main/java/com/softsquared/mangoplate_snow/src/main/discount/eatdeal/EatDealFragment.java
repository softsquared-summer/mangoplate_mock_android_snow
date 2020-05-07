package com.softsquared.mangoplate_snow.src.main.discount.eatdeal;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseFragment;
import com.softsquared.mangoplate_snow.src.main.MainActivity;
import com.softsquared.mangoplate_snow.src.main.discount.eatdeal.interfaces.EatDealFragmentView;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.interfaces.FindRestaurantFragmentView;

import java.util.ArrayList;

public class EatDealFragment extends BaseFragment implements EatDealFragmentView {

    private EatDealRecyclerAdapter mEatDealRecyclerAdapter;
    private RecyclerView mEatDealRecyclerView;
    private LinearLayout mEatdealBtnAroundMe;
    private Context mContext;
    private EatDealService eatDealService;
    ArrayList<EatDeal> eatDeals = new ArrayList<>();

    public EatDealFragment(){

    }
    public EatDealFragment(Context context){
        this.mContext = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_discount_eatdeal, container, false);

        eatDealService = new EatDealService(this);

        mEatDealRecyclerView = rootView.findViewById(R.id.eatdeal_recycler_restaurant_list);
        mEatDealRecyclerAdapter = new EatDealRecyclerAdapter(eatDeals, mContext);
        mEatdealBtnAroundMe = rootView.findViewById(R.id.eatdeal_btn_around_me);

        mEatDealRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mEatDealRecyclerView.setAdapter(mEatDealRecyclerAdapter);

//        for(int i=0; i<20; i++){
//            eatDeals.add(new EatDeal("20"+"&#37;","[수원시] 월화주가", "마라새우 세트"));
//        }
        tryGetEatDealList();
        mEatDealRecyclerAdapter.notifyDataSetChanged();

        EatDealRecyclerViewDecoration bottomSpace = new EatDealRecyclerViewDecoration(100);
        mEatDealRecyclerView.addItemDecoration(bottomSpace);
        mEatdealBtnAroundMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).showD("showDistrict");
            }
        });
        return rootView;
    }
    private void tryGetEatDealList(){
        showProgressDialog();

        eatDealService.tryGetEatDealList();
    }
    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? "네트워크 연결이 원활하지 않습니다." : message);
    }

    @Override
    public void getEatDealListSuccess(ArrayList<EatDeal> eatDealListResult) {
        hideProgressDialog();

        for(int i = 0; i < eatDealListResult.size(); i++){
            eatDeals.add(eatDealListResult.get(i));
        }
        mEatDealRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void getEatDealListFailure(String message) {
        showCustomToast(message);
    }

//    public void customOnClick(View view){
//        switch (view.getId()){
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
//            default:
//                break;
//        }
//    }
}


//recyclerview 구현 & adapter 설정
//https://dev-imaec.tistory.com/27
