package com.codegym.service;

import java.util.List;

public interface ISpiceService {
    List<String> findAll();

    List<String> save(String[] condiment);
}
