package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.BaseRepository;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> findAllSearch(String name) {
        String queryStr = "SELECT p FROM Product AS p where p.name like : name" ;
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name", '%' + name + '%');
        return query.getResultList();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }
}