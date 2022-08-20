package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {

    void save(Product product);

    Product findById(int id);

    List<Product> findAllSearch(String name);

    void update(Product product);

    void remove(int id);
}