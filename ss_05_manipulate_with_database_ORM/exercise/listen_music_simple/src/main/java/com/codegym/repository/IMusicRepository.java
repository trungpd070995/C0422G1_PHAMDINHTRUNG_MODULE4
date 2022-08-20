package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {

    List<Music> findAll();

    Music findOne(int id);

    void save(Music music);

    void delete(int id);

    void update(Music music);
}