package com.codegym.application_expansion_blog.repository;

import com.codegym.application_expansion_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}