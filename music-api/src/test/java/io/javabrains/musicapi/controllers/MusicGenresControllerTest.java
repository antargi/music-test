package io.javabrains.musicapi.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import io.javabrains.musicapi.models.MusicGenreModel;
import io.javabrains.musicapi.repositories.MusicGenresRepository;
import io.javabrains.musicapi.services.MusicGenresService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class MusicGenresControllerTest {

    @Autowired
    private MusicGenresRepository repository;

    @Test   
    void UserEmailTest() {

        MusicGenresController controller = new MusicGenresController();
        MusicGenresService service = new MusicGenresService();
        service.musicPreferenceRepo = repository;
        controller.musicService = service;
        List<MusicGenreModel> response = controller.getMusicGenres();
        assertNotNull(response);
    }

    @Test   
    void saveUserEmailTest() {
        MusicGenresController controller = new MusicGenresController();
        MusicGenresService service = new MusicGenresService();
        service.musicPreferenceRepo = repository;
        controller.musicService = service;
        MusicGenreModel genre = new MusicGenreModel();
        MusicGenreModel response = controller.saveMusicGenre(genre);
        assertEquals(response.getName(), genre.getName());
    }
    
    
}
