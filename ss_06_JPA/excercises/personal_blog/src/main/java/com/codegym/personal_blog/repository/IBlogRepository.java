package com.codegym.personal_blog.repository;

import com.codegym.personal_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}