package com.example.androidstudy.http.views;

import android.content.Context;
import android.util.AttributeSet;

import com.edu.baserecyclerview.OnLoadMoreListener;
import com.example.http.data.Ms;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieList extends RecyclerView {
    private MovieAdapterV2 adapter;
    private Context context;
    public MovieList(@NonNull Context context) {
        this(context, null);
    }

    public MovieList(@NonNull Context context,
                     @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieList(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        setLayoutManager(layoutManager);
    }

    public void bindData(List<Ms> movieDetails) {
        if (adapter == null) {
            adapter = new MovieAdapterV2(context);
        }
        setAdapter(adapter);
        adapter.bindData(movieDetails);
        adapter.notifyDataSetChanged();
    }
}
