package com.example.androidstudy.http.views;

import android.content.Context;
import android.util.AttributeSet;

import com.example.http.data.Ms;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieView extends RecyclerView {
    private MovieAdapter adapter;
    private Context context;
    public MovieView(@NonNull Context context) {
        this(context, null);
    }

    public MovieView(@NonNull Context context,
                     @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
            adapter = new MovieAdapter(context);
        }
        setAdapter(adapter);
        adapter.bindData(movieDetails);
        adapter.notifyDataSetChanged();
    }
}
