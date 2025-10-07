package com.joey.rest.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController @CrossOrigin public class AlbumController {
    @Autowired AlbumService albumService;


    //GET Routes
    @GetMapping("/album") public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/album/{id}") public Album getAlbumById(@PathVariable long albumId) {
        return albumService.getAlbumById(albumId);
    }

    @GetMapping("/album_search") public List<Album> searchAlbums(@RequestParam(value = "album_title", required = false) String albumTitle, @RequestParam(value = "album_artist", required = false) String albumArtist) {
        ArrayList<Album> results = new ArrayList<>();

        if (albumTitle != null) {
            Album albumFound = albumService.getAlbumByTitle(albumTitle);

            results.add(albumFound);
        } else if (albumArtist != null) {
            Album albumFound = albumService.getAlbumByArtist(albumArtist);

            results.add(albumFound);
        }

        return results;
    }


    //POST Routes
    @PostMapping("/album") public Album postAlbum(@RequestBody Album newAlbum) {
        return albumService.postAlbum(newAlbum);
    }


    //PUT Routes
    @PutMapping("/album/{id}") public ResponseEntity<Album> putAlbum(@PathVariable long albumId, @RequestBody Album updatedAlbum) {
        return ResponseEntity.ok(albumService.putAlbum(albumId, updatedAlbum));
    }


    //DELETE Routes
    @DeleteMapping("/album/{id}") public void deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbumById(albumId);
    }
}