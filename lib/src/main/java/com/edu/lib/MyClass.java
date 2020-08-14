package com.edu.lib;

import java.util.LinkedList;

public class MyClass {
    public static void main(String[] args) {
        for (int i = 255; i > -100; i--) {
            System.out.println(i+"      "+transformVolume(i));
        }
    }
    private static int transformVolume(int volume) {
        int[] xx = {60,30,10};
        for (int i = 0; i < xx.length ; i++) {
            if (volume / xx[i] >= 1) {
                return xx.length - i;
            }
        }
        return 0;
    }
}
