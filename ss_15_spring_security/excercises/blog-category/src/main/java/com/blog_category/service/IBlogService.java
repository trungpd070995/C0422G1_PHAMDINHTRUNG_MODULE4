package com.blog_category.service;

import com.blog_category.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService{
    Page<Blog> findAll(String name, String cName, Pageable pageable);
    Page<Blog> findAll(Pageable pageable, String name);
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    Page<Blog> findAllBlogByCategoryId(Long id, Pageable pageable);
}
