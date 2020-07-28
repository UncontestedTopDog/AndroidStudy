package com.edu.lib;

public class ThreadProduct extends Thread {
    private Product product;
    public ThreadProduct(Product product) {
        super();
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.setValue();
        }
    }
}
