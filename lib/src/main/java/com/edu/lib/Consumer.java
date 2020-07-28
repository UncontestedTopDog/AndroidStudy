package com.edu.lib;

public class Consumer {
    private String lock;

    public Consumer(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock) {
                if (StringObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get的值是："+StringObject.value);
                StringObject.value = "";
                lock.notify();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
