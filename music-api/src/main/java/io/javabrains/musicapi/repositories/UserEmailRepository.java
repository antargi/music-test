package io.javabrains.musicapi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.musicapi.models.UserEmailModel;

@Repository
public interface UserEmailRepository extends CrudRepository<UserEmailModel, Long> {

    @Query(value = "SELECT * FROM user_email WHERE email = ?", nativeQuery = true)
    UserEmailModel findUserByEmail(String email);
    
}
