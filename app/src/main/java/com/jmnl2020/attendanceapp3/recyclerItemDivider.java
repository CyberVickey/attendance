package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerItemDivider extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    private Drawable divider;


    public recyclerItemDivider(Context context) {
        final TypedArray styledAttributes = context.obtainStyledAttributes(ATTRS);
        divider = styledAttributes.getDrawable(0);
        styledAttributes.recycle();
    }

    public recyclerItemDivider(Context context, int resId) {
        divider = ContextCompat.getDrawable(context, resId);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

}
