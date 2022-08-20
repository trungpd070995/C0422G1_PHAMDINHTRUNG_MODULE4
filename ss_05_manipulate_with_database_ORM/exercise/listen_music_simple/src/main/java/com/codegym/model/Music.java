package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTheSong;
    private String nameOfTheSong;
    private String performingArtist;
    private String kindOfMusic;
    private String songFilePath;

    public Music() {
    }

    public Music(String nameOfTheSong, String performingArtist, String kindOfMusic, String songFilePath) {
        this.nameOfTheSong = nameOfTheSong;
        this.performingArtist = performingArtist;
        this.kindOfMusic = kindOfMusic;
        this.songFilePath = songFilePath;
    }

    public Music(int idTheSong, String nameOfTheSong, String performingArtist, String kindOfMusic, String songFilePath) {
        this.idTheSong = idTheSong;
        this.nameOfTheSong = nameOfTheSong;
        this.performingArtist = performingArtist;
        this.kindOfMusic = kindOfMusic;
        this.songFilePath = songFilePath;
    }

    public int getIdTheSong() {
        return idTheSong;
    }

    public void setIdTheSong(int idTheSong) {
        this.idTheSong = idTheSong;
    }

    public String getNameOfTheSong() {
        return nameOfTheSong;
    }

    public void setNameOfTheSong(String nameOfTheSong) {
        this.nameOfTheSong = nameOfTheSong;
    }

    public String getPerformingArtist() {
        return performingArtist;
    }

    public void setPerformingArtist(String performingArtist) {
        this.performingArtist = performingArtist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(String songFilePath) {
        this.songFilePath = songFilePath;
    }

    @Override
    public Music clone() {
        Music music = new Music();
        music.setIdTheSong(idTheSong);
        music.setNameOfTheSong(nameOfTheSong);
        music.setPerformingArtist(performingArtist);
        music.setKindOfMusic(kindOfMusic);
        music. setSongFilePath(songFilePath);
        return music;
    }
}