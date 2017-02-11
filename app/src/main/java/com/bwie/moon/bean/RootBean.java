package com.bwie.moon.bean;

/**
 * Created by lenovo on 2017/2/10.
 */

public class RootBean {
    private Data1 data;

    public Data1 getData() {
        return data;
    }

    public void setData(Data1 data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RootBean{" +
                "data=" + data +
                '}';
    }
}
