package com.appdevelopersblog.ws.ProductsMicroservice.service;

import com.appdevelopersblog.ws.ProductsMicroservice.model.CreateProductModel;
import com.appdevelopersblog.ws.ProductsMicroservice.model.Product;
import com.appdevelopersblog.ws.ProductsMicroservice.model.ProductLikedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {

    private KafkaTemplate<String, ProductLikedEvent> kafkaTemplate;
    private Map<String, Product> productList = new LinkedHashMap<>();

    public ProductService(KafkaTemplate<String, ProductLikedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

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
        product.setLikes(product.getLikes() + 1);

        // Send like to kafka
        kafkaTemplate.send("product-created-events-topic2", productId, new ProductLikedEvent(productId));

        return product;
    }
}
