package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IMusicRepository implements com.codegym.repository.IMusicRepository {
    @Override
    public List<Music> findAll() {
        String queryStr = "SELECT m FROM Music AS m";
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public Music findOne(int id) {
        String queryStr = "SELECT m FROM Music AS m WHERE m.idTheSong = :id";
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery(queryStr, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        String queryStr = "DELETE FROM Music AS m WHERE m.idTheSong = :id";
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery(queryStr, Music.class);
        query.setParameter("id", id);
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }
}