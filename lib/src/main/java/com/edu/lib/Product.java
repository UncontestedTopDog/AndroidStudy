package com.edu.lib;

public class Product {
    private String lock;

    public Product(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!StringObject.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "" + System.nanoTime();
                System.out.println("set的值是：" + value);
                StringObject.value = value;
                lock.notify();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
