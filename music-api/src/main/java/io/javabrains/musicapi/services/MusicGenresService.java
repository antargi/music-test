package io.javabrains.musicapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.musicapi.models.MusicGenreModel;
import io.javabrains.musicapi.repositories.MusicGenresRepository;

@Service
public class MusicGenresService {

    @Autowired
    public
    MusicGenresRepository musicPreferenceRepo;
    
    public List<MusicGenreModel> getMusicGenres(){
        return (List<MusicGenreModel>) musicPreferenceRepo.findAll();
    }

    public MusicGenreModel saveMusicGenre(MusicGenreModel genre){
        return musicPreferenceRepo.save(genre);
    }

    public Optional<MusicGenreModel> findById(Long id){
        return musicPreferenceRepo.findById(id);
    }

    
}
