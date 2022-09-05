package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findAllByNameContains(String keyword);

    List<Blog> findAllByCategoryId(Integer id);

    Page<Blog> findByNameContaining(Pageable pageable, String name);
}

