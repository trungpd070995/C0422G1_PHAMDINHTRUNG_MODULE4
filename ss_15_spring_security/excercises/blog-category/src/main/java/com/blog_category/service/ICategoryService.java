package com.blog_category.service;

import com.blog_category.model.Blog;
import com.blog_category.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
