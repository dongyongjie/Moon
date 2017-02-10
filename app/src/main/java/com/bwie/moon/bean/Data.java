package com.bwie.moon.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */

public class Data {
    private List<Drink> categories;

    public List<Drink> getCategories() {
        return categories;
    }

    public void setCategories(List<Drink> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Data{" +
                "categories=" + categories +
                '}';
    }
}
