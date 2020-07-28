package com.example.androidstudy.mvvm.activity;

import android.os.Bundle;
import android.view.MotionEvent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.androidstudy.R;
import com.example.androidstudy.databinding.MvvmMainActivityBinding;
import com.example.androidstudy.mvvm.fragment.FragmentPath;
import com.example.androidstudy.mvvm.viewmodel.MovieViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class MVVMMainActivity extends AppCompatActivity {

    MvvmMainActivityBinding binding;
    private MovieViewModel viewModel;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvvm_main_activity);
        binding = DataBindingUtil.setContentView(this, R.layout.mvvm_main_activity);
        fragment = (Fragment) ARouter.getInstance().build(FragmentPath.Mvvm.MvvmPath).navigation();
        getSupportFragmentManager()    //
                .beginTransaction()
                .add(R.id.fragment_container,fragment)   // 此处的R.id.fragment_container是要盛放fragment
                // 的父容器
                .commit();
    }

    // @Override
    // public boolean dispatchTouchEvent(MotionEvent ev) {
    //     return true;
    // }
}
