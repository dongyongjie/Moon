package com.bwie.moon.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class Data1 {
    private List<Products> products;

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Data1{" +
                "products=" + products +
                '}';
    }
}
