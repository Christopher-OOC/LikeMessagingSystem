package com.appdevelopersblog.ws.ProductsMicroservice.controller;

import com.appdevelopersblog.ws.ProductsMicroservice.model.CreateProductModel;
import com.appdevelopersblog.ws.ProductsMicroservice.model.Product;
import com.appdevelopersblog.ws.ProductsMicroservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/products")
public class ProductApiController {

    private ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductModel model) {

        Product product = productService.createProduct(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }



}
