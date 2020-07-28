package com.edu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class NumProBar extends View {

    private float textSize;
    private int reachedBarHeight;
    private int unReachedBarHeight;
    private Rect reachedRect = new Rect();
    private Rect unReachedRect = new Rect();
    private int textX = 0;
    private int textY = 0;
    private float textOffset = 0;
    private int progress;
    private int max;
    private Paint reachedPaint;
    private int reachedColor;
    private Paint unReachedPaint;
    private int unReachedColor;
    private Paint textPaint;
    private int textColor;
    private boolean showText = false;


    public NumProBar(Context context) {
        this(context, null);
    }

    public NumProBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NumProBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        textSize = sp2px(10);
        reachedBarHeight = (int) dp2px(1.5f);
        unReachedBarHeight = (int) dp2px(1.5f);
        progress = 100;
        max = 100;
        textOffset = dp2px(3.0f);
        // reachedColor = Color.rgb(66, 145, 241);
        reachedColor = Color.BLUE;
        unReachedColor = Color.GRAY;
        textColor = Color.RED;

        reachedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        reachedPaint.setColor(reachedColor);

        unReachedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        unReachedPaint.setColor(unReachedColor);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec, true),measure(heightMeasureSpec, false));
    }

    private int measure(int measureSpec, boolean isWidth) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            return size;
        } else {
            int padding = isWidth ? getPaddingLeft()+getPaddingRight():
                    getPaddingTop()+getPaddingBottom();
            int result = isWidth ? getSuggestedMinimumWidth() + padding :
                    getSuggestedMinimumHeight() + padding;
            if (mode == MeasureSpec.AT_MOST) {
                return isWidth ?  Math.max(result,size) : Math.min(result,size);
            }
            return result;
        }
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        return (int) Math.max(textSize,Math.max(reachedBarHeight,unReachedBarHeight));
    }

    @Override
    protected int getSuggestedMinimumWidth() {
        return (int) textSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (showText) {
            calculateRect();
        } else {
            calculateNoTextRect();
        }
        canvas.drawRect(unReachedRect,unReachedPaint);
        canvas.drawRect(reachedRect,reachedPaint);
        canvas.drawText(progress+"%",textX,textY,textPaint);
    }

    private void calculateRect() {
        String  text = progress+"%";
        int textWidth = (int) textPaint.measureText(text);
        int mainWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        reachedRect.top = (getHeight() - reachedBarHeight) / 2;
        reachedRect.bottom = (getHeight() + reachedBarHeight) / 2;
        reachedRect.left = getPaddingLeft();
        reachedRect.right = getPaddingLeft() + mainWidth * progress / max;

        if (reachedRect.right > (getPaddingLeft() + mainWidth - 2 * textOffset - textWidth)) {
            reachedRect.right = (int) (getPaddingLeft() + mainWidth - 2 * textOffset - textWidth);
        }

        textX = (int) (reachedRect.right + textOffset);
        textY = (int) ((getHeight() - (textPaint.descent() + textPaint.ascent())) / 2);

        unReachedRect.top = (getHeight() - unReachedBarHeight) / 2;
        unReachedRect.bottom = (getHeight() + unReachedBarHeight) / 2;

        unReachedRect.left = (int) (reachedRect.right + 2 * textOffset + textWidth);
        unReachedRect.right = getPaddingLeft() + mainWidth;
    }

    private void calculateNoTextRect() {
        int mainWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        reachedRect.top = (getHeight() - reachedBarHeight) / 2;
        reachedRect.bottom = (getHeight() + reachedBarHeight) / 2;
        reachedRect.left = getPaddingLeft();
        reachedRect.right = getPaddingLeft() + mainWidth * progress / max;

        unReachedRect.top = (getHeight() - unReachedBarHeight) / 2;
        unReachedRect.bottom = (getHeight() + unReachedBarHeight) / 2;
        unReachedRect.left = reachedRect.right;
        unReachedRect.right = getPaddingLeft() + mainWidth;
    }

    public float sp2px(float sp) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    public float dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
