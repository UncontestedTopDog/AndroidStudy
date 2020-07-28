package com.edu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyLayout extends ViewGroup {
    int[] childWidths;
    int[] childHeights;
    public MyLayout(Context context) {
        this(context, null);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            TextView tv = new TextView(getContext());
            tv.setText(i+"!");
            this.addView(tv);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("AAAAAAAAAA","onMeasure");
        childWidths = new int[getChildCount()];
        childHeights = new int[getChildCount()];
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            childWidths[i] = MeasureSpec.getSize(child.getMeasuredWidth());
            childHeights[i] = MeasureSpec.getSize(child.getMeasuredHeight());
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = 0;
        int height = 0;
        int maxHeight= 0;
        Log.i("AAAAAAAAAAA", getChildCount()+"!");
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int childWidth = MeasureSpec.getSize(child.getMeasuredWidth());
            int childHeight = MeasureSpec.getSize(child.getMeasuredHeight());
            maxHeight = Math.max(maxHeight, childWidth);
            Log.i("AAAAAAAAAAA", i + "       " + childWidth + "            " + childHeight);
            if (width + childWidth <= getWidth()) {
                child.layout(width, height, width + childWidth, height + childHeight);
                width += childWidth;
            } else {
                width = 0;
                height += maxHeight;
                child.layout(width, height, width + childWidth, height + childHeight);
            }
        }
        // width = getWidth();
        // Log.i("AAAAAAAAAAA", getChildCount()+"!"+getWidth()+"!"+width);
        // for (int i = 0; i < getChildCount(); i++) {
        //     View child = getChildAt(i);
        //     child.layout(0,100 * i,getWidth(),100*(i+1));
        // }
    }
}
