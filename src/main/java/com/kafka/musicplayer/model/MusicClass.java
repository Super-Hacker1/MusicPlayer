package com.kafka.musicplayer.model;

import jakarta.persistence.*;

@Entity
@Table(name="musicDetails")
public class MusicClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "album")
    private String album;
    @Column(name = "genre")
    private String genre;
    @Column(name = "release_year")
    private String release_year;
    @Column(name = "duration")
    private String duration;


    public MusicClass(){};

    public MusicClass(String title, String artist, String album, String genre, String release_year, String duration){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.release_year = release_year;
        this.duration = duration;
    }
    public String getTitle() {return this.title;}
    public void setTitle(String title) {this.title = title;}

    public String getArtist() {return this.artist;}
    public void setArtist(String artist) {this.artist = artist;}

    public String getAlbum() {return this.album;}
    public void setAlbum(String album) {this.album = album;}

    public String getGenre() {return this.genre;}
    public void setGenre(String genre) {this.genre = genre;}

    public String getRelease_year() {return this.release_year;}
    public void setRelease_year(String release_year) {this.release_year = release_year;}

    public String getDuration() {return this.duration;}
    public void setDuration(String duration) {this.duration = duration;}

}
