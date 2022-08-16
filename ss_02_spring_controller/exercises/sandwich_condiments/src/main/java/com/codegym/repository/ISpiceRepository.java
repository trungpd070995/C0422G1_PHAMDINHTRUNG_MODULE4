package com.codegym.repository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISpiceRepository {
    List<String> findAll();

    List<String> save(String[] condiment);
}
