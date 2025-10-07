package com.joey.rest.album;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository public interface AlbumRepository extends CrudRepository<Album, Long> {
    //Search Queries
    Album findByTitle(String title);

    Album findByArtist(String artist);
}