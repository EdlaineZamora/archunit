package com.myapp.repository;

import com.myapp.presentation.ProductEndpoint;

public class ProductRepository {


    public void save(ProductEntity product) {

        if (ProductEndpoint.isNull(product.getName())) {
            throw new RuntimeException("Help");
        }

    }

}
