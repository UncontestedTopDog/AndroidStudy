package com.edu.baserecyclerview;

import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING;

public abstract class OnLoadMoreListener extends RecyclerView.OnScrollListener {

    private boolean isScolled = false;
    private int countItem;
    private int lastItem;
    private RecyclerView.LayoutManager layoutManager;

    protected abstract void onLoading(int countItem, int lastItem);

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        // super.onScrollStateChanged(recyclerView, newState);
        if (newState == SCROLL_STATE_DRAGGING || newState == SCROLL_STATE_SETTLING) {
            isScolled = true;
        } else {
            isScolled = false;
        }
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            layoutManager = recyclerView.getLayoutManager();
            countItem = layoutManager.getItemCount();
            lastItem =
                    ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        if (isScolled && countItem != lastItem && lastItem == countItem - 1) {
            onLoading(countItem, lastItem);
        }
    }
}
