package com.codegym.repository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpiceRepositoryImpl implements ISpiceRepository {

    private static List<String> spice = new ArrayList<>();

    static {
        spice.add("Lettuce");
        spice.add("Tomato");
        spice.add("Mustard");
        spice.add("Sprouts");
    }

    @Override
    public List<String> findAll() {
        return spice;
    }

    @Override
    public List<String> save(String[] condiment) {
        List<String> condiments = new ArrayList<>();
        for (int i = 0; i < condiment.length ; i++) {
            condiments.add(condiment[i]);
        }
        return condiments;
    }
}
