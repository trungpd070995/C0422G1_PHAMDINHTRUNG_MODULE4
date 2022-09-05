package com.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blog.setDateCreate(new Date(System.currentTimeMillis()));
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAllByCategoryId(Integer id) {
        return iBlogRepository.findAllByCategoryId(id);
    }

    @Override
    public List<Blog> find(String keyword) {
        return iBlogRepository.findAllByNameContains(keyword);
    }

    @Override
    public Page<Blog> findAllByName(Pageable pageable, String name) {
        return iBlogRepository.findByNameContaining(pageable, name);
    }

}
