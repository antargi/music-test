package io.javabrains.musicapi.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user_email")
public class UserEmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="email_music_pref", 
        joinColumns = {  @JoinColumn(name="useremail_id")},
        inverseJoinColumns = { @JoinColumn(name="music_genre_id") }
    )
    private Set<MusicGenreModel> preferences = new HashSet<>();


    public UserEmailModel() {
    }


    public UserEmailModel(String email, Set<MusicGenreModel> preferences) {
        this.email = email;
        this.preferences = preferences;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<MusicGenreModel> getPreferences() {
        return this.preferences;
    }

    public void setPreferences(Set<MusicGenreModel> preferences) {
        this.preferences = preferences;
    }
}
