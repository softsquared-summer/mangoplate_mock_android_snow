package com.softsquared.mangoplate_snow.src.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.mangoplate_snow.R;
import com.softsquared.mangoplate_snow.src.BaseActivity;
import com.softsquared.mangoplate_snow.src.GpsInfo;
import com.softsquared.mangoplate_snow.src.main.bottom_sheet.SelectDistrictBottomSheet;
import com.softsquared.mangoplate_snow.src.main.community.CommunityFragment;
import com.softsquared.mangoplate_snow.src.main.discount.DiscountFragment;
import com.softsquared.mangoplate_snow.src.main.find_restaurant.FindRestaurantFragment;
import com.softsquared.mangoplate_snow.src.main.interfaces.MainActivityView;
import com.softsquared.mangoplate_snow.src.main.my_page.MyPageFragment;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends BaseActivity implements MainActivityView {
    private final int PERMISSIONS_ACCESS_FINE_LOCATION = 1000;
    private final int PERMISSIONS_ACCESS_COARSE_LOCATION = 1001;
    private boolean isAccessFineLocation = false;
    private boolean isAccessCoarseLocation = false;
    private boolean isPermission = false;
    private double lat = 0;
    private double lon = 0;
    private GpsInfo gpsInfo;

    private TabLayout mBottomTab;
    private ImageView mIvFindRestaurantIcon, mIvFindRestaurantIconS, mIvDiscountIcon, mIvDiscountIconS, mIvCommunityIcon, mIvCommunityIconS, mIvMypageIcon, mIvMypageIconS;
    private MainViewPager mMainViewPager;
    private DiscountFragment mDiscountFragment;
 //   private EmptyFragment mEmptyFragment;
    private FindRestaurantFragment mFindRestaurantFragment;
    private MyPageFragment mMyPageFragment;
    private CommunityFragment mCommunityFragment;

   @SuppressLint("ResourceType")
   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       callPermission();
       settingGPS();

       mMainViewPager = findViewById(R.id.main_viewpager);
       mBottomTab = findViewById(R.id.main_bottom_tab_layout);
       mBottomTab.setupWithViewPager(mMainViewPager);
       mBottomTab.setTabGravity(TabLayout.GRAVITY_FILL);
//
//       mIvFindRestaurantIcon = new ImageView(this);
//       mIvDiscountIcon = new ImageView(this);
//       mIvCommunityIcon = new ImageView(this);
//       mIvMypageIcon = new ImageView(this);
//
//       mIvFindRestaurantIconS = new ImageView(this);
//       mIvDiscountIconS = new ImageView(this);
//       mIvCommunityIconS = new ImageView(this);
//       mIvMypageIconS = new ImageView(this);
//
//       mIvFindRestaurantIcon.setImageResource(R.drawable.ic_find_restaurant_tab);
//       mIvDiscountIcon.setImageResource(R.drawable.ic_discount_tab);
//       mIvCommunityIcon.setImageResource(R.drawable.ic_community_tab);
//       mIvMypageIcon.setImageResource(R.drawable.ic_mypage_tab);
//
//       mIvFindRestaurantIconS.setImageResource(R.drawable.ic_find_restaurant_tab_selected);
//       mIvDiscountIconS.setImageResource(R.drawable.ic_discount_tab_selected);
//       mIvCommunityIconS.setImageResource(R.drawable.ic_community_tab_selected);
//       mIvMypageIconS.setImageResource(R.drawable.ic_mypage_tab_selected);

//       mIvFindRestaurantIcon.setScaleType(ImageView.ScaleType.CENTER);
//       mIvDiscountIcon.setScaleType(ImageView.ScaleType.CENTER);
//       mIvCommunityIcon.setScaleType(ImageView.ScaleType.CENTER);
//       mIvMypageIcon.setScaleType(ImageView.ScaleType.CENTER);

       initViewPager();

//       mBottomTab.getTabAt(0).setIcon(R.drawable.ic_find_restaurant_tab_selected);


//        mBottomTab.addTab(mBottomTab.newTab().setText("맛집찾기"));

// 탭 직접 클릭 시 사용
//        mBottomTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) { }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) { }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) { }
//        });

    }

    private void settingGPS(){
        if(!isPermission){
            callPermission();
            return;
        }
        gpsInfo = new GpsInfo(MainActivity.this);
        if(gpsInfo.isGetLocation()){
            lat = gpsInfo.getLatitude();
            lon = gpsInfo.getLongitude();
//            Toast.makeText(this, "현재 위치\n" + "위도 : " + latitude + "\n경도 : " +longitude, Toast.LENGTH_LONG).show();
            Log.e("위치", "위도 : "+lat);
            Log.e("위치", "경도 : "+lon);
        }else{
            gpsInfo.showSettingAlert();
        }
        callPermission();
    }
    private void initViewPager() {
        mFindRestaurantFragment = new FindRestaurantFragment(this);
        mDiscountFragment = new DiscountFragment(this);
        mCommunityFragment = new CommunityFragment(this);
        mMyPageFragment = new MyPageFragment(this);

        MainFragmentPagerAdapter mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mainFragmentPagerAdapter.addFragment(mFindRestaurantFragment);
        mFindRestaurantFragment.whereami(lat, lon);
        mainFragmentPagerAdapter.addFragment(mDiscountFragment);
        mainFragmentPagerAdapter.addFragment(mCommunityFragment);
        mainFragmentPagerAdapter.addFragment(mMyPageFragment);

        mMainViewPager.setAdapter(mainFragmentPagerAdapter);
        mMainViewPager.setPagingEnabled(true);

//        mBottomTab.getTabAt(0).setCustomView(mIvFindRestaurantIconS);
//        mBottomTab.getTabAt(1).setCustomView(mIvDiscountIcon);
//        mBottomTab.getTabAt(2).setCustomView(mIvCommunityIcon);
//        mBottomTab.getTabAt(3).setCustomView(mIvMypageIcon);
        mBottomTab.getTabAt(0).setIcon(R.drawable.ic_find_restaurant_tab_selected);
        mBottomTab.getTabAt(1).setIcon(R.drawable.ic_discount_tab);
        mBottomTab.getTabAt(2).setIcon(R.drawable.ic_community_tab);
        mBottomTab.getTabAt(3).setIcon(R.drawable.ic_mypage_tab);

        mMainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

//                mBottomTab.getTabAt(0).setCustomView(mIvFindRestaurantIcon);
//                mBottomTab.getTabAt(1).setCustomView(mIvDiscountIcon);
//                mBottomTab.getTabAt(2).setCustomView(mIvCommunityIcon);
//                mBottomTab.getTabAt(3).setCustomView(mIvMypageIcon);

                mBottomTab.getTabAt(0).setIcon(R.drawable.ic_find_restaurant_tab);
                mBottomTab.getTabAt(1).setIcon(R.drawable.ic_discount_tab);
                mBottomTab.getTabAt(2).setIcon(R.drawable.ic_community_tab);
                mBottomTab.getTabAt(3).setIcon(R.drawable.ic_mypage_tab);

                switch (position) {
                    case 0:
                        mFindRestaurantFragment.whereami(lat, lon);
                        mBottomTab.getTabAt(0).setIcon(R.drawable.ic_find_restaurant_tab_selected);
                        break;
                    case 1:
                        mDiscountFragment.whereami(lat, lon);
                        mBottomTab.getTabAt(1).setIcon(R.drawable.ic_discount_tab_selected);
                        break;
                    case 2:
                        mBottomTab.getTabAt(2).setIcon(R.drawable.ic_community_tab_selected);
                        break;
                    case 3:
                        mBottomTab.getTabAt(3).setIcon(R.drawable.ic_mypage_tab_selected);
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       if(requestCode == PERMISSIONS_ACCESS_FINE_LOCATION
               && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            isAccessFineLocation = true;
       }else if(requestCode == PERMISSIONS_ACCESS_COARSE_LOCATION
                && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            isAccessCoarseLocation = true;
        }
       if(isAccessFineLocation && isAccessCoarseLocation){
            isPermission = true;
       }
    }

    private void callPermission(){
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
               && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
               != PackageManager.PERMISSION_GRANTED){

           requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                   PERMISSIONS_ACCESS_FINE_LOCATION);

       }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
               && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
               != PackageManager.PERMISSION_GRANTED){

           requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                   PERMISSIONS_ACCESS_COARSE_LOCATION);

       }else{
           isPermission = true;
       }
    }
    public void showD(String whichDialog){
       switch (whichDialog){
           case "showDistrict":
               SelectDistrictBottomSheet selectDistrictBottomSheet = SelectDistrictBottomSheet.getInstance();
               selectDistrictBottomSheet.show(getSupportFragmentManager(), "select");
               break;
           case "showSort":
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("정렬보여주세요~~");
               builder.setMessage("요기요~~");
               builder.create();
               builder.show();
               break;
       }

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
    //    public void customOnClick(View view){
//        switch (view.getId()){
//            case R.id.main_btn_find_restaurant_tab:
//                break;
//            case R.id.main_btn_discount_tab:
//                break;
//            case R.id.main_btn_community_tab:
//                break;
//            case R.id.main_btn_mypage_tab
//                break;
//            case R.id.main_btn_add_tab:
//                break;
//            default:
//                break;
//        }
//    }
}

//recyclerview 구현 & adapter 설정
//https://dev-imaec.tistory.com/27
