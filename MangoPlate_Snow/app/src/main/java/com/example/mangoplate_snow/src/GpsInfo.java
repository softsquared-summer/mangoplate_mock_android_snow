package com.example.mangoplate_snow.src;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class GpsInfo extends Service implements LocationListener {
    private  final Context mContext;
    boolean isGpsEnabled = false;
    boolean isNetworkEnabled = false;
    boolean isGetLocation = false;      //GPS 상태값

    Location location;
    double lat;
    double lon;

    //최소 GPS 정보 업데이트 거리 10미터
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    //최소 GPS 정보 업데이트 시간 1분
    private static final long MIN_TIME_BW_UPDATES = 1000*60*1;

    protected LocationManager locationManager;

    public GpsInfo(Context mContext) {
        this.mContext = mContext;
        getLocation();
    }

    public Location getLocation() {
        if(Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(
                        mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(
                        mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return null;
        }
        try{
            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

            //GSP 정보 가져오기
            isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            //네트워크 상태 값 가져오기
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if(!isGpsEnabled && !isNetworkEnabled){
                //GPS와 네트워크 사용이 가능하지 않을때 어떻게 할건지 코드 넣어주면 됨
            }else{
                this.isGetLocation = true;
                //네트워크 정보로부터 위치값 가져오기
                if(isNetworkEnabled){
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    if(locationManager != null){
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if(location != null){
                            //위도 경도 값 넣어주기
                            lat = location.getLatitude();
                            lon = location.getLongitude();
                        }
                    }
                }
                if(isGpsEnabled){
                    if(location == null){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        if(locationManager != null){
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if(location != null){
                                lat = location.getLatitude();
                                lon = location.getLongitude();
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return location;
    }

    //GPS 종료
    public void stopUsingGPS(){
        if(locationManager != null){
            locationManager.removeUpdates(GpsInfo.this);
        }
    }

    //위도값 가져옴
    public double getLatitude(){
        if(location != null){
            lat = location.getLatitude();
        }
        return lat;
    }

    //경도값 가져옴
    public double getLongitude(){
        if(location != null){
            lon = location.getLongitude();
        }
        return lon;
    }

    //GPS나 WIFI가 켜져있는지 확인
    public boolean isGetLocation(){
        return this.isGetLocation;
    }

    //GPS 정보를 가져오지 못했을때 설정으로 갈지 물어보면 alert 창
    public void showSettingAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

        alertDialog.setMessage("GPS를 켜주세요.");
        alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mContext.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //앱 강제종료
                //android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        alertDialog.show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}

//참고 사이트
//https://mainia.tistory.com/1153