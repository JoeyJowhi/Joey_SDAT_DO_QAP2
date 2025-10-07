package com.joey.rest.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service public class AlbumService {
    @Autowired private AlbumRepository albumRepository;


    //Search Methods
    public List<Album> getAllAlbums() {
        return (List<Album>) albumRepository.findAll();
    }


    //HTTP Methods
    public Album getAlbumByTitle(String title) {
        return albumRepository.findByTitle(title);
    }

    public Album getAlbumByArtist(String artist) {
        return albumRepository.findByArtist(artist);
    }

    public Album getAlbumById(long id) {
        Optional<Album> albumOptional = albumRepository.findById(id);

        return albumOptional.orElse(null);
    }

    public Album putAlbum(long idOfAlbumToUpdate, Album updatedAlbum) {
        Optional<Album> albumToUpdateOptional = albumRepository.findById(idOfAlbumToUpdate);

        if (albumToUpdateOptional.isPresent()) {
            Album albumToUpdate = albumToUpdateOptional.get();

            albumToUpdate.setTitle(updatedAlbum.getTitle());
            albumToUpdate.setArtist(updatedAlbum.getArtist());
            albumToUpdate.setDescription(updatedAlbum.getDescription());
            albumToUpdate.setGenre(updatedAlbum.getGenre());

            return albumRepository.save(albumToUpdate);
        }

        return null;
    }

    public Album postAlbum(Album newAlbum) {
        return albumRepository.save(newAlbum);
    }

    public void deleteAlbumById(long idOfAlbumToDelete) {
        albumRepository.deleteById(idOfAlbumToDelete);
    }
}