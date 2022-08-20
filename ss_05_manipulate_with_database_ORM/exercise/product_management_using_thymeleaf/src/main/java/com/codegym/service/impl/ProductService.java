package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repositoryProduct;

    @Override
    public void save(Product product) {
        repositoryProduct.save(product);
    }

    @Override
    public Product findById(int id) {
        return repositoryProduct.findById(id);
    }

    @Override
    public List<Product> findAllSearch(String name) {
        return repositoryProduct.findAllSearch(name);
    }

    @Override
    public void update(Product product) {
        repositoryProduct.update(product);
    }

    @Override
    public void remove(int id) {
        repositoryProduct.remove(id);
    }
}