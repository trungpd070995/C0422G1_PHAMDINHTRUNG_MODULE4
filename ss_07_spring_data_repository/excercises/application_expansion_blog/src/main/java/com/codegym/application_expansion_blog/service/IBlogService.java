package com.codegym.application_expansion_blog.service;

import com.codegym.application_expansion_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> findKeywordByName(String keyword, Pageable pageable);

}
