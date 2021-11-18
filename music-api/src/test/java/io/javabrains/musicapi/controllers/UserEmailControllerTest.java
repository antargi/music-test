package io.javabrains.musicapi.controllers;

import org.junit.jupiter.api.Test;
import io.javabrains.musicapi.models.UserEmailModel;
import io.javabrains.musicapi.models.UserPreferences;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class UserEmailControllerTest {
    

    @Test
    void UserEmailTest() {

        UserEmailController controller = new UserEmailController();
        List<UserEmailModel> response = controller.getUserEmails();
        assertNotNull(response);
    }

    @Test   
    void saveUserEmailTest() {
        UserEmailController controller = new UserEmailController();
        UserPreferences preferences = new UserPreferences();
        Boolean response = controller.saveUserEmail(preferences);
        assertFalse(response);
    }
    
    
}
