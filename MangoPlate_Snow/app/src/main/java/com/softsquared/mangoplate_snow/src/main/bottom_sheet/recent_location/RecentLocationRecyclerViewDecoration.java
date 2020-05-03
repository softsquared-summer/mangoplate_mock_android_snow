package com.softsquared.mangoplate_snow.src.main.bottom_sheet.recent_location;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecentLocationRecyclerViewDecoration extends RecyclerView.ItemDecoration {
    private final int divSpace;

    public RecentLocationRecyclerViewDecoration(int divSpace) {
        this.divSpace = divSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(parent.getChildAdapterPosition(view)%2==1) {
            outRect.left = divSpace;
            outRect.bottom = divSpace;
        } else {
            outRect.right = divSpace;
            outRect.bottom = divSpace;
        }
    }
}
