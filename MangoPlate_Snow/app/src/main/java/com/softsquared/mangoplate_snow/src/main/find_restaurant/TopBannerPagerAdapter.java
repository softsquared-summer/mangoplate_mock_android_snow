package com.softsquared.mangoplate_snow.src.main.find_restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.softsquared.mangoplate_snow.R;

public class TopBannerPagerAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mBannerImg = {R.drawable.img_banner_item_1, R.drawable.img_banner_item_2, R.drawable.img_banner_item_3, R.drawable.img_banner_item_4, R.drawable.img_banner_item_5};
    private LayoutInflater mLayoutInflater;

    public TopBannerPagerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mBannerImg.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = mLayoutInflater.inflate(R.layout.slide_banner_image_viewer, container, false);
        ImageView imageView = v.findViewById(R.id.image_viewer);

        imageView.setImageResource(mBannerImg[position]);

        container.addView(v);
        return v;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.invalidate();
    }
}