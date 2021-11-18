package io.javabrains.musicapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.musicapi.models.UserEmailModel;
import io.javabrains.musicapi.repositories.UserEmailRepository;

@Service
public class UserEmailService {

    @Autowired
    UserEmailRepository userEmailRepository;
    
    public List<UserEmailModel> getUserEmails(){
        return (List<UserEmailModel>) userEmailRepository.findAll();
    }

    public UserEmailModel getUserByEmail(String email){
        return userEmailRepository.findUserByEmail(email);
    }

    public UserEmailModel saveUserEmail(UserEmailModel user){
        return userEmailRepository.save(user);
    }

    
}