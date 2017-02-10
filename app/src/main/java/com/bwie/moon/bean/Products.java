package com.bwie.moon.bean;

/**
 * Created by lenovo on 2017/2/10.
 */
public class Products {
    private String featured_price;
    private String name;
    private String price;
    private String short_description;
    private String specs_json;
    private String id;
    private String image_small;
    private String app_long_image1;
    private String app_long_image2;
    private String app_long_image3;
    private String app_long_image4;
    private String app_long_image5;

    public String getFeatured_price() {
        return featured_price;
    }

    public void setFeatured_price(String featured_price) {
        this.featured_price = featured_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getSpecs_json() {
        return specs_json;
    }

    public void setSpecs_json(String specs_json) {
        this.specs_json = specs_json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_small() {
        return image_small;
    }

    public void setImage_small(String image_small) {
        this.image_small = image_small;
    }

    public String getApp_long_image1() {
        return app_long_image1;
    }

    public void setApp_long_image1(String app_long_image1) {
        this.app_long_image1 = app_long_image1;
    }

    public String getApp_long_image2() {
        return app_long_image2;
    }

    public void setApp_long_image2(String app_long_image2) {
        this.app_long_image2 = app_long_image2;
    }

    public String getApp_long_image3() {
        return app_long_image3;
    }

    public void setApp_long_image3(String app_long_image3) {
        this.app_long_image3 = app_long_image3;
    }

    public String getApp_long_image4() {
        return app_long_image4;
    }

    public void setApp_long_image4(String app_long_image4) {
        this.app_long_image4 = app_long_image4;
    }

    public String getApp_long_image5() {
        return app_long_image5;
    }

    public void setApp_long_image5(String app_long_image5) {
        this.app_long_image5 = app_long_image5;
    }

    @Override
    public String toString() {
        return "Products{" +
                "featured_price='" + featured_price + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", short_description='" + short_description + '\'' +
                ", specs_json='" + specs_json + '\'' +
                ", id='" + id + '\'' +
                ", image_small='" + image_small + '\'' +
                ", app_long_image1='" + app_long_image1 + '\'' +
                ", app_long_image2='" + app_long_image2 + '\'' +
                ", app_long_image3='" + app_long_image3 + '\'' +
                ", app_long_image4='" + app_long_image4 + '\'' +
                ", app_long_image5='" + app_long_image5 + '\'' +
                '}';
    }
}
