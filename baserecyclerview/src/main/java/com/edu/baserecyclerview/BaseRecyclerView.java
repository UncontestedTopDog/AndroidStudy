package com.edu.baserecyclerview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class BaseRecyclerView extends RecyclerView {
    public BaseRecyclerView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BaseRecyclerView(@NonNull Context context,
                            @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {

            }
        });
    }


}
