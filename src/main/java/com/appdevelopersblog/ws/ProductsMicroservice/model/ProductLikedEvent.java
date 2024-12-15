package com.appdevelopersblog.ws.ProductsMicroservice.model;

public class ProductLikedEvent {

    private String productId;

    public ProductLikedEvent() {

    }

    public ProductLikedEvent(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
