package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    List<Blog> findAllByCategoryId(Integer id);

    List<Blog> find(String keyword);

    Page<Blog> findAllByName(Pageable pageable ,String name);
}
