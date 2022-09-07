package com.blog_category.repository;

import com.blog_category.model.Blog;
import com.blog_category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
