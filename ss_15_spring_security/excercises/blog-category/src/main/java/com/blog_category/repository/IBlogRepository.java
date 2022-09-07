package com.blog_category.repository;

import com.blog_category.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByBlogNameContainingAndCategory_CategoryNameContaining
            (String name, String cName, Pageable pageable);
    Page<Blog> findAllByBlogNameContaining(Pageable pageable, String name);
    Page<Blog> findAllByCategory_CategoryId(Long id, Pageable pageable);
}
