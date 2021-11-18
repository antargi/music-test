package io.javabrains.musicapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.musicapi.models.MusicGenreModel;
import io.javabrains.musicapi.services.MusicGenresService;

@RestController
@RequestMapping("/musicGenres")
public class MusicGenresController {
    
    @Autowired
    MusicGenresService musicService;

    @CrossOrigin
    @GetMapping()
    public List<MusicGenreModel> getMusicGenres(){
        return musicService.getMusicGenres();
    }
    
    @CrossOrigin
    @PostMapping()
    public MusicGenreModel saveMusicGenre(@RequestBody MusicGenreModel genre) {
        return musicService.saveMusicGenre(genre);
    }
}
