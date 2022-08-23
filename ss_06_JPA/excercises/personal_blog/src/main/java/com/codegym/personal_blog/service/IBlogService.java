package com.codegym.personal_blog.service;

import com.codegym.personal_blog.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void update(Blog blog);

    void remove(Integer id);
    
}
