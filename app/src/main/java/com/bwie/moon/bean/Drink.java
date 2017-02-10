package com.bwie.moon.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class Drink {
    private String name;
    private List<Products> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
