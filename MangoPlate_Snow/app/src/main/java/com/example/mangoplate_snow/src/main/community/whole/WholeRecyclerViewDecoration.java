package com.example.mangoplate_snow.src.main.community.whole;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WholeRecyclerViewDecoration extends RecyclerView.ItemDecoration {
    private final int divSpace;

    public WholeRecyclerViewDecoration(int divSpace) {
        this.divSpace = divSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
            outRect.bottom = divSpace;
    }
}
