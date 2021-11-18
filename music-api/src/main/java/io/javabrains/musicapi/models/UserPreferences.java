package io.javabrains.musicapi.models;

import java.util.List;

public class UserPreferences {
    UserEmailModel useremail;
    List<MusicGenreModel> musicPreferences;

    public UserEmailModel getuseremail() {
        return this.useremail;
    }

    public void setuseremail(UserEmailModel useremail) {
        this.useremail = useremail;
    }

    public List<MusicGenreModel> getMusicPreferences() {
        return this.musicPreferences;
    }

    public void setMusicPreferences(List<MusicGenreModel> musicPreferences) {
        this.musicPreferences = musicPreferences;
    }

}