package com.joey.rest.album;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Album {
    @Id
    @SequenceGenerator(name = "album_sequence", sequenceName = "album_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "album_sequence")
    private long id;

    private String title;
    private String artist;
    private String description;
    private String genre;


    //Getter Methods
    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGenre() {
        return this.genre;
    }


    //Setter Methods
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}