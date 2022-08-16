package com.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.repository.ISpiceRepository;

import java.util.List;

@Service
public class SpiceServiceImpl implements ISpiceService{

    @Autowired
    private ISpiceRepository spiceRepository;

    @Override
    public List<String> findAll() {
        return this.spiceRepository.findAll();
    }

    @Override
    public List<String> save(String[] condiment) {
        return this.spiceRepository.save(condiment);
    }
}
