package com.example.androidstudy.mvvm.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.edu.baserecyclerview.OnLoadMoreListener;
import com.example.androidstudy.R;
import com.example.androidstudy.databinding.MvvmMainFragmentBinding;
import com.example.androidstudy.mvvm.viewmodel.MovieViewModel;
import com.example.androidstudy.mvvm.views.IRefresh;
import com.example.http.data.MovieData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

@Route(path = FragmentPath.Mvvm.MvvmPath)
public class MVVMMainFragment extends Fragment {

    private MvvmMainFragmentBinding binding;
    private View rootView;
    private MovieViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.mvvm_main_fragment,container,
                    false);
            rootView = binding.getRoot();
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        viewModel.movieDataLiveData.observe(getViewLifecycleOwner(), new Observer<MovieData>() {
            @Override
            public void onChanged(MovieData movieData) {
                binding.movieView.bindData(movieData.getMs());
            }
        });
        binding.movieView.setOnRefresh(new IRefresh() {
            @Override
            public void onRefresh() {
                viewModel.loadMovie(291);
            }
        });
        binding.movieView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                Log.i("AAAASDD",countItem+"   "+lastItem);
                if (countItem == lastItem+1) {
                    viewModel.loadMovie(292);
                }
            }
        });
        viewModel.loadMovie(290);
    }
}
