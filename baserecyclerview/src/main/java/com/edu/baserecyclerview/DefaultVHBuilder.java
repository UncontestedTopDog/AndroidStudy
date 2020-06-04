package com.edu.baserecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class DefaultVHBuilder {
    public static DefaultFooterVH buildFooter(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.footer_layout,null,false);
        DefaultFooterVH defaultFooterVH = new DefaultFooterVH(view);
        return defaultFooterVH;
    }

    public static DefaultHeaderVH buildHeader(Context context) {
        View view = View.inflate(context, R.layout.header_layout, null);
        DefaultHeaderVH defaultHeaderVH = new DefaultHeaderVH(view);
        return defaultHeaderVH;
    }
}
