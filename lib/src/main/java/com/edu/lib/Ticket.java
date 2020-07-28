package com.edu.lib;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int num = 100;
    ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            // synchronized (this) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + ".....sale...." + num--);
                }
            // }
            lock.unlock();
        }
    }
}
