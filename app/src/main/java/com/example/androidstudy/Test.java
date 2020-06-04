package com.example.androidstudy;

import java.util.List;

public class Test {
    public <T> T tt(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        T ins = tClass.newInstance();
        return ins;
    }

    public void ttt(List<?> c) {
        c.get(0);
    }
}
