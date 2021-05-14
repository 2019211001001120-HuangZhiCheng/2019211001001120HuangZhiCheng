package com.HuangZhiCheng.model;

import java.io.InputStream;

/**
 * @author : hzc
 * @date: 2021/5/14 - 05 - 14 - 18:50
 * @Description: com.HuangZhiCheng.model
 * @version: 1.0
 */
public class Product {
    private Integer productId=null;
    private String productName=null;
    private String productDescription=null;
    private InputStream picture=null;
    private Double price=null;
    private Integer categoryId=null;

    public Product() {
    }

    public Product(Integer productId, String productName, String productDescription, InputStream picture, Double price, Integer categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.picture = picture;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }

}
