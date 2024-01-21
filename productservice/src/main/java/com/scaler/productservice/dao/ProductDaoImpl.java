package com.scaler.productservice.dao;

import com.scaler.productservice.entities.Product;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    EntityManager entityManager;
    @Override
    public Product getProductById(Long id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public void save(Product product) {
        entityManager.merge(product);
    }
}
