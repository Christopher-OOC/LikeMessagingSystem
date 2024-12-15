package com.appdevelopersblog.ws.ProductsMicroservice.model;

public class CreateProductModel {

    private String productName;
    private String productPrice;

    public CreateProductModel() {

    }

    public CreateProductModel(String productName, String productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
