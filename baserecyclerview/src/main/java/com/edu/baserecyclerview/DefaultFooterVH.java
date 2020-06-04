package com.edu.baserecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

public class DefaultFooterVH extends RecyclerView.ViewHolder {
    ContentLoadingProgressBar footerProgress;
    TextView footerText;
    String[] text = {"正在努力加载","正在努力加载.","正在努力加载..","正在努力加载..."};

    public DefaultFooterVH(@NonNull View itemView) {
        super(itemView);
        footerProgress = itemView.findViewById(R.id.footer_progress);
        footerText = itemView.findViewById(R.id.footer_text);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    final int finalI = i;
                    footerText.post(new Runnable() {
                        @Override
                        public void run() {
                            footerText.setText(text[finalI %text.length]);
                        }
                    });
                    i++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
