package com.edu.thread;

import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public Test() {
        // service.execute(new Runnable() {
        //     @Override
        //     public void run() {
        //         Log.i("ThreadPoolExecutor", "execute");
        //     }
        // });
        // Future<Integer> future = service.submit(new Callable<Integer>() {
        //     @Override
        //     public Integer call() throws Exception {
        //         Log.i("ThreadPoolExecutor", "submit");
        //         return 2;
        //     }
        // });
        // try {
        //    Integer number = future.get();
        // }catch (ExecutionException e) {
        //     e.printStackTrace();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }

    public ExecutorService init() {
        // ExecutorService service = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
        //         new LinkedBlockingQueue<Runnable>());
        // return service;

        ExecutorService service1 = Executors.newCachedThreadPool();
        return service1;
    }
}
