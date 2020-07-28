package com.edu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = 0;
        int height = 0;
        if (widthMode == MeasureSpec.AT_MOST) {
            //如果填入的是wrap_content，进行处理
        } else {
            width = MeasureSpec.getSize(widthMeasureSpec);
        }

        if (heightMode == MeasureSpec.AT_MOST) {
            //如果填入的是wrap_content，进行处理
        } else {
            height = MeasureSpec.getSize(heightMeasureSpec);
        }

        int max = Math.max(width,height);
        int measureSpec = MeasureSpec.makeMeasureSpec(max,
                MeasureSpec.AT_MOST);



        setMeasuredDimension(measureSpec,measureSpec);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i("AAAAAAAAAAAA",w+" "+h+" "+oldw+" "+oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
    }

    protected int dp2px(float dp) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
