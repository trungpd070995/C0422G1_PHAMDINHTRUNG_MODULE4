package com.codegym.application_expansion_blog.service;

import com.codegym.application_expansion_blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    void save(Category category);

    void remove(Integer id);

}
