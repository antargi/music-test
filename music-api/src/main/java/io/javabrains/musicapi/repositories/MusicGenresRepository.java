package io.javabrains.musicapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.musicapi.models.MusicGenreModel;

@Repository
public interface MusicGenresRepository extends CrudRepository<MusicGenreModel, Long> {
    
}
