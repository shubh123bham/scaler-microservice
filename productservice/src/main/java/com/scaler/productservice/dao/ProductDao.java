package com.scaler.productservice.dao;

import com.scaler.productservice.entities.Product;

public interface ProductDao {
    Product getProductById(Long id);
    void save(Product productw);
}
