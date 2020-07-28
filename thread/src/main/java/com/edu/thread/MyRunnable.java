package com.edu.thread;

import android.util.Log;

public class MyRunnable implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (i < 100) {
            Log.i("MyRunnable", "currentTime: " + i);
            i++;
        }
    }
}
