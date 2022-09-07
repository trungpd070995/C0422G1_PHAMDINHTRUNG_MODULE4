package com.blog_category.service.impl;

import com.blog_category.model.Blog;
import com.blog_category.model.Category;
import com.blog_category.repository.ICategoryRepository;
import com.blog_category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        iCategoryRepository.delete(findById(id));
    }
}
