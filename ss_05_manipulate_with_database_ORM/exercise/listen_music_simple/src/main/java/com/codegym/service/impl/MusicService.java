
package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findOne(int id) {
        return musicRepository.findOne(id);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }
}