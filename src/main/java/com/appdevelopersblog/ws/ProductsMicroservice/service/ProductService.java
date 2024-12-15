package com.appdevelopersblog.ws.ProductsMicroservice.service;

import com.appdevelopersblog.ws.ProductsMicroservice.model.CreateProductModel;
import com.appdevelopersblog.ws.ProductsMicroservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    public Product createProduct(CreateProductModel model) {

        Product product = new Product();
        product.setProductId(UUID.randomUUID().toString());
        product.setProductName(model.getProductName());
        product.setProductPrice(model.getProductPrice());

        return product;
    }

}
