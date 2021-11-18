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
import io.javabrains.musicapi.models.UserEmailModel;
import io.javabrains.musicapi.models.UserPreferences;
import io.javabrains.musicapi.services.MusicGenresService;
import io.javabrains.musicapi.services.UserEmailService;

@RestController
@RequestMapping("/emailUser")
public class UserEmailController {
    
    @Autowired
    UserEmailService userEmailService;

    @Autowired
    MusicGenresService musicGenreService;

    @CrossOrigin
    @GetMapping()
    public List<UserEmailModel> getUserEmails(){
        return userEmailService.getUserEmails();
    }

    @CrossOrigin
    @PostMapping()
    public Boolean saveUserEmail(@RequestBody UserPreferences userpreferences) {
        UserEmailModel checkUser = userEmailService.getUserByEmail(userpreferences.getuseremail().getEmail());
        if (checkUser == null) {
            UserEmailModel userSaved = userEmailService.saveUserEmail(userpreferences.getuseremail());
            List<MusicGenreModel> musicPreferences = userpreferences.getMusicPreferences();
            for (MusicGenreModel preference : musicPreferences) {
                userSaved.getPreferences().add(preference);
            }
            userEmailService.saveUserEmail(userSaved);
            return true;
        }
        return false;
    }
}
