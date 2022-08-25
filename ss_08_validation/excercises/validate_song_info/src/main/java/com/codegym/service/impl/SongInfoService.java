package com.codegym.service.impl;

import com.codegym.model.SongInfo;
import com.codegym.repository.ISongInfoRepository;
import com.codegym.service.ISongInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongInfoService implements ISongInfoService {

    @Autowired
    private ISongInfoRepository iSongInfoRepository;

    @Override
    public List<SongInfo> findAll() {
        return iSongInfoRepository.findAll();
    }

    @Override
    public void save(SongInfo songInfo) {
        iSongInfoRepository.save(songInfo);
    }

    @Override
    public Optional<SongInfo> findById(int id) {
        return iSongInfoRepository.findById(id);
    }
}
