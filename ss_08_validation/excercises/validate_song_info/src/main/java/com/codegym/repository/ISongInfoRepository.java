package com.codegym.repository;

import com.codegym.model.SongInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongInfoRepository extends JpaRepository<SongInfo, Integer> {

}
