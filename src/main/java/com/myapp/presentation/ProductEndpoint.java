package com.myapp.presentation;

import com.myapp.repository.ProductEntity;
import com.myapp.repository.ProductRepository;

public class ProductEndpoint {

    private ProductRepository productRepository;

    public void save(String name) {
        if (isNull(name)) {
            throw new RuntimeException("Help");
        }
        ProductEntity product = new ProductEntity(name);
        productRepository.save(product);
    }

    public static boolean isNull(String name) {
        return name == null;
    }

}
