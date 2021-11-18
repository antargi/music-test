package io.javabrains.musicapi.models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "music_genre")
public class MusicGenreModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "preferences")
    private Set<UserEmailModel> users = new HashSet<>();


    public MusicGenreModel() {
    }
    

    public MusicGenreModel(String name) {
        this.name = name;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEmailModel> getUsers() {
        return this.users;
    }

    public void setUsers(Set<UserEmailModel> users) {
        this.users = users;
    }

}