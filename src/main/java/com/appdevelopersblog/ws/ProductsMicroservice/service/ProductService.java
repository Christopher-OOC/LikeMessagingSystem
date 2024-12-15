package com.appdevelopersblog.ws.ProductsMicroservice.service;

import com.appdevelopersblog.ws.ProductsMicroservice.model.CreateProductModel;
import com.appdevelopersblog.ws.ProductsMicroservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {

    private Map<String, Product> productList = new LinkedHashMap<>();

    public Product createProduct(CreateProductModel model) {

        Product product = new Product();
        product.setProductId(UUID.randomUUID().toString());
        product.setProductName(model.getProductName());
        product.setProductPrice(model.getProductPrice());

        productList.put(product.getProductId(), product);

        return product;
    }

    public Product getProduct(String productId) {

        return productList.get(productId);
    }

    public Product sendLike(String productId) {

        Product product = productList.get(productId);

        // Send like to kafka

        product.setLikes(product.getLikes() + 1);

        return product;
    }
}
